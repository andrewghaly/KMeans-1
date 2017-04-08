#!/usr/bin/python
# Student sections: s1=1-18 s2 = 19-37 s3 = 38-60

import glob
import os
import re
import subprocess
import sys
import json
import plotK

# TODO change output format for k-means

# RUN FROM DIR pa6-calendar-student
unitTestFile = 'src/edu/wit/cs/tests/PA6aTestCase.java'
studentCodeDirectory = 'src/edu/wit/cs/comp1000/'
compileTestCommand = "javac " + unitTestFile + ' -classpath src:junit-4.12.jar'
runTestCommand = 'java -cp junit-4.12.jar:hamcrest-core-1.3.jar:src org.junit.runner.JUnitCore edu.wit.cs.tests.PA6aTestCase'
resultsDict = {}


# Reads from a txt document which classes are already compiled
# Return a list of keys and the loaded dictionary
def readCompiledList():
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


# Parses the output from running the unit tests
# Appends it into a dictionary with results
def parseTestResults(out):
    if "OK (" in out:
        return []
    else:
        list = []
        r = re.compile(r"\) |\(")
        for line in out.split('\n'):
            if ") test" in line:
                failure = r.split(line)
                list.append(failure[1])
        return list


def getTestNames():
    # Getting names of all tests PA6aTestCase
    try:
        f = open(unitTestFile, 'r')
    except IOError, e:
        print e
        sys.exit()
    filedata = f.read()
    f.close()

    testList = []
    r = re.compile(r" test|\(")
    for line in filedata.split('\n'):
        if " test" in line and " testClass" not in line:
            test = "test" + r.split(line)[1]
            testList.append(test)
    return testList


# Used in case .class are already compiled
# Just run them right from the imported data
dataDictionary = readCompiledList()
precompiledList = list(dataDictionary.keys())

# Compiles and runs the code
# If code has previously been run, it was imported
# Reduces amount of compiling
i = 1
currCompiledList = list()
rewriteJSONFile = False
print "Running unit tests on data..."
for file in glob.glob(studentCodeDirectory + '*.java'):
    print i,
    fileNameWIthExtension = file.split("src/edu/wit/cs/comp1000/PA6a")
    studentNumber = fileNameWIthExtension[1][:-5]
    currCompiledList.append(studentNumber)

    # Check if the code has already been compiled
    # Pull data from imported file and continue for rest of data
    if studentNumber in precompiledList:
        print "Skipping"
        resultsDict[studentNumber] = dataDictionary[studentNumber]
        pass
    else:
        # Set the flag that the JSON file must be rewrote
        rewriteJSONFile = True
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
        # IF it does not exist
        os.system(compileTestCommand)
        # run java file via subprocess to fix stdout and stderr
        runUnitTest = subprocess.Popen([runTestCommand], stdout=subprocess.PIPE, shell=True)
        runUnitTest = runUnitTest.stdout.read()

        # Parse the output
        failedTestsList = parseTestResults(runUnitTest)
        resultsDict[studentNumber] = failedTestsList

    i += 1
# End of compiling and running tests

# Begin data analyzing and parsing
# Write to a file list of all compiled classes
try:
    # Check if the rewrite_json flag was set
    if rewriteJSONFile:
        print "Writing data to JSON file"
        fi = open("compiled_list.json", 'w')
        json.dump(resultsDict, fi, sort_keys=True)
        fi.close()
except IOError, e:
    print "Could not open file"

print "\nCOMPLETE\n"

testList = getTestNames()
matrix = list()

"""
    Next two for loops are redundant, exist elsewhere in the code
"""
totalNumTests = len(testList)

# Prints the failed tests for each student
# for studentID, failedTestList in resultsDict.items():
#     print studentID, failedTestList, "Failed: ", len(failedTestList), "/", totalNumTests

dataList = []

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
            yCoord += 1

        # Sum vector to calculate x coordinate, use calculated y coordinate
        # print "({0}, {1})".format(sum(row), y)
        dataList.append((sum(testVector), yCoord))

plotK.main(dataList, 4)
