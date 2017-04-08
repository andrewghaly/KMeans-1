#!/usr/bin/python
# Student sections: s1=1-18 s2 = 19-37 s3 = 38-60

import glob
import os
import re
import subprocess
import sys
import json
import plotK


def readCompiledList():
    """
    Reads from a JSON file where classes are already compiled
    Returns the dictionary to prevent recompiling
    """
    pathToList = "compiled_list.json"
    loadedDictionary = {}

    # Check if file path exists
    if os.path.isfile(pathToList):
        # Open and read in lines
        # Append into a list
        with open(pathToList, 'r') as f:
            try:
                loadedDictionary = json.load(f)
            except ValueError:
                print "No data inside of file continuing..."
        f.close()
    else:
        print "Could not find file for loading in data"

    return loadedDictionary


def parseTestResults(out):
    """
    Parses the output from running the unit tests
    Appends it into a dictionary with results
    """

    # User passed all Unit Tests
    if "OK (" in out:
        return []
    # User failed atleast 1 test
    else:
        list = []
        r = re.compile(r"\) |\(")
        # Append each failed test to a list
        for line in out.split('\n'):
            if ") test" in line:
                failure = r.split(line)
                list.append(failure[1])
        return list


def getTestNames(unitTestFile):
    """Get all test names from Unit Test File"""
    try:
        f = open(unitTestFile, 'r')
    except IOError, e:
        print e
        sys.exit()
    filedata = f.read()
    f.close()

    testList = []
    r = re.compile(r" test|\(")

    # Iterate through the data and find the line for test without testClass
    for line in filedata.split('\n'):
        if " test" in line and " testClass" not in line:
            test = "test" + r.split(line)[1]
            testList.append(test)
    return testList


def rewriteJSONFile(rewriteJSONFlag, dataDictionary):
    # Begin data analyzing and parsing
    # Write to a file list of all compiled classes
    try:
        # Check if the rewrite_json flag was set
        if rewriteJSONFlag:
            print "Writing data to JSON file"
            fi = open("compiled_list.json", 'w')
            json.dump(dataDictionary, fi, sort_keys=True)
            fi.close()
    except IOError, e:
        print "Could not open file"

    print "\nCOMPLETE\n"


def printResultsFromTests(dictionary, numTests):
    # Prints the failed tests for each student
    for studentID, failedTestList in dictionary.items():
        print studentID, failedTestList, "Failed: ", len(failedTestList), "/", numTests


def generateCoordinates(unitTestFile, resultsDict):
    """
    Returns a list of coordinates(x,y) that represent the data
    Uses the data from resultsDict to create a Boolean Matrix
    Iterates through the matrix and sums the rows and uses it as the yCoordinate
    """

    testList = getTestNames(unitTestFile)
    totalNumTests = len(testList)
    matrix = list()
    dataList = []

    # List of tests failed by each student
    # print printResultsFromTests(resultsDict, totalNumTests)

    # Weight each test from the Boolean Matrix
    for studentID, failedTestList in resultsDict.items():
        if failedTestList == 0:
            testVector = []
            for test in testList:
                testVector.append(1)
            matrix.append(testVector)
        else:
            testVector = []
            for test in testList:
                if test not in failedTestList:
                    testVector.append(1)
                else:
                    testVector.append(0)
            matrix.append(testVector)

            # Categorize vector to calculate y-coordinate
            yCoord = 0
            if testVector[0] == 1:
                # isLeapYear
                yCoord += 1

            if testVector[1] == 1:
                # isNegYear
                yCoord += 2

            if testVector[2] == 1:
                # test2015
                yCoord += 2

            if testVector[3] == 1:
                # test2016
                yCoord += 4

            if testVector[4] == 1:
                # printMonth
                yCoord += 2

            if testVector[5] == 1:
                # invalidDay
                yCoord += 1

            if testVector[6] == 1:
                # zeroYear
                yCoord += 2

            # Sum vector to calculate x coordinate, use calculated y coordinate
            # print "({0}, {1})".format(sum(row), y)
            dataList.append((sum(testVector), yCoord))

    return dataList


def main():
    # STATIC FILE LOCATIONS
    # STATIC FILE COMMANDS
    unitTestFile = 'src/edu/wit/cs/tests/PA6aTestCase.java'
    studentCodeDirectory = 'src/edu/wit/cs/comp1000/'
    compileTestCommand = "javac " + unitTestFile + ' -classpath src:junit-4.12.jar'
    runTestCommand = 'java -cp junit-4.12.jar:hamcrest-core-1.3.jar:src org.junit.runner.JUnitCore edu.wit.cs.tests.PA6aTestCase'

    # Run in case .java are already compiled
    # Get dictionary from the compiled_list.json file if exists
    # Set a flag to True if any file needs to be compiled
    dataDictionary = readCompiledList()
    precompiledList = list(dataDictionary.keys())
    rewriteJSONFlag = False

    # Store current session data and name of compiled files
    resultsDict = {}

    # Run each test and store the results in the resultsDict
    print "Running unit tests on data..."
    for file in glob.glob(studentCodeDirectory + '*.java'):
        # Splice each filename to get a unique identifier
        fileNameWithExtension = file.split("src/edu/wit/cs/comp1000/PA6a")
        studentNumber = fileNameWithExtension[1][:-5]
        print studentNumber,

        # Check if the code has already been compiled
        # Pull data from imported file and continue for rest of data
        if studentNumber in precompiledList:
            print "Skipping"
            resultsDict[studentNumber] = dataDictionary[studentNumber]
            pass
        else:
            # Set the flag that the JSON file must be rewrote
            rewriteJSONFlag = True
            try:
                f = open(unitTestFile, 'r')
            except IOError, e:
                print "Could not open file."
                sys.exit()
            filedata = f.read()
            f.close()

            # Changes the class used to run the unit tests
            newtest = "    private static edu.wit.cs.comp1000.PA6a" + studentNumber + " testClass;"

            # Search and replace the old class for the one set to new test
            for line in filedata.split('\n'):
                if "private static edu.wit.cs.comp1000.PA6a" in line:
                    oldtest = line
                    newdata = filedata.replace(oldtest, newtest)
                    f = open(unitTestFile, 'w')
                    f.write(newdata)
                    f.close()

            # Compile the test case with the new student code
            os.system(compileTestCommand)

            # Run the Unit Test file
            runUnitTest = subprocess.Popen([runTestCommand], stdout=subprocess.PIPE, shell=True)
            results = runUnitTest.stdout.read()

            # Parse the output and put it into the dictionary
            failedTestsList = parseTestResults(results)
            resultsDict[studentNumber] = failedTestsList

    # Check if Dictionary needs to be rewritten
    rewriteJSONFile(rewriteJSONFlag, resultsDict)

    dataList = generateCoordinates(unitTestFile, resultsDict)
    plotK.main(dataList, 1000)


if __name__ == "__main__":
    main()
