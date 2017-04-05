#!/usr/bin/python
# Student sections: s1=1-18 s2 = 19-37 s3 = 38-60

import glob
import os
import re
import subprocess
import sys
import time
import json

import plot_K

# TODO change output format for k-means

# RUN FROM DIR pa6-calendar-student
utestfile = 'src/edu/wit/cs/tests/PA6aTestCase.java'
studentcode = 'src/edu/wit/cs/comp1000/'
compile = "javac " + utestfile + ' -classpath src:junit-4.12.jar'
run = 'java -cp junit-4.12.jar:hamcrest-core-1.3.jar:src org.junit.runner.JUnitCore edu.wit.cs.tests.PA6aTestCase'
resultsDict = {}


def testNames():
    # Getting names of all tests PA6aTestCase
    try:
        f = open(utestfile, 'r')
    except IOError, e:
        print e
        sys.exit()
    filedata = f.read()
    f.close()

    tests = []
    r = re.compile(r" test|\(")
    for line in filedata.split('\n'):
        if " test" in line and " testClass" not in line:
            test = "test" + r.split(line)[1]
            tests.append(test)
    return tests

# Parses the output from running the unit tests
# Appends it into a dictionary with results
def checkTests(out):
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

# Reads from a txt document which classes are already compiled
# Return a list of keys and the loaded dictionary
def readList():
    path_to_list = "compiled_list.json"
    loaded_dictionary = {}
    # Check if file path exists
    if os.path.isfile(path_to_list):
        # Open and read in lines
        # Append into a list
        with open(path_to_list, 'r') as f:
            try:
                loaded_dictionary = json.load(f)
            except ValueError:
                print "No data inside of file continuing..."
        f.close()
    else:
        print "Could not find file for loading in data"

    return loaded_dictionary

# Used in case .class are already compiled
# Just run them right from the imported data
data_dictionary = readList()
precompiled_list = list(data_dictionary.keys())

# Compiles and runs the code
# If code has previously been run, it was imported
# Reduces amount of compiling
i = 1
curr_compiled_list = list()
rewrite_json_file = False
print "Running unit tests on data..."
for file in glob.glob(studentcode + '*.java'):
    print i,
    file_name_with_extension = file.split("src/edu/wit/cs/comp1000/PA6a")
    student_number = file_name_with_extension[1][:-5]
    curr_compiled_list.append(student_number)

    # Check if the code has already been compiled
    # Pull data from imported file and continue for rest of data
    if student_number in precompiled_list:
        print "Skipping"
        resultsDict[student_number] = data_dictionary[student_number]
        pass
    else:
        # Set the flag that the JSON file must be rewrote
        rewrite_json_file = True
        try:
            f = open(utestfile, 'r')
        except IOError, e:
            print "Could not open file."
            sys.exit()
        filedata = f.read()
        f.close()

        # Changes the class used to run the unit tests
        newtest = "    private static edu.wit.cs.comp1000.PA6a" + student_number + " testClass;"

        # Search and replace the old class for the one set to new test
        for line in filedata.split('\n'):
            if "private static edu.wit.cs.comp1000.PA6a" in line:
                oldtest = line
                newdata = filedata.replace(oldtest, newtest)
                f = open(utestfile, 'w')
                f.write(newdata)
                f.close()

        # Compile the test case with the new student code
        # IF it does not exist
        os.system(compile)
        # run java file via subprocess to fix stdout and stderr
        out = subprocess.Popen([run], stdout=subprocess.PIPE, shell=True)
        out = out.stdout.read()

        # Parse the output
        check = checkTests(out)
        resultsDict[student_number] = check

    i += 1
# End of compiling and running tests

# Begin data analyzing and parsing
# Write to a file list of all compiled classes
try:
    # Check if the rewrite_json flag was set
    if rewrite_json_file:
        print "Writing data to JSON file"
        fi = open("compiled_list.json", 'w')
        json.dump(resultsDict, fi, sort_keys=True)
        fi.close()
except IOError, e:
    print "Could not open file"

print "\nCOMPLETE\n"

tests = testNames()
matrix = list()

"""
    Next two for loops are redundant, exist elsewhere in the code
"""
total_num_tests = len(tests)

for index, results in resultsDict.items():
    print index, results, "Failed: ", len(results), "/", total_num_tests

dataList = []

for index, results in resultsDict.items():
    if results == 0:
        row = []
        for test in tests:
            row.append(1)
        matrix.append(row)
        # print index, "\t", row  # temp printing stuff
    else:
        row = []
        for test in tests:
            if test not in results:
                row.append(1)
            else:
                row.append(0)
        matrix.append(row)
        # print index, "\t", row,  # temp printing stuff

        # Categorize vector to calculate y-coordinate
        y = 0
        if row[0] == 1 or row[3] == 1:
            y += 1
        if row[1] == 1 or row[6] == 1:
            y += 1
        if row[5] == 1:
            y += 1
        if row[2] == 1 or row[4] == 1:
            y += 1

        # Sum vector to calculate x coordinate, use calculated y coordinate
        # print "({0}, {1})".format(sum(row), y)
        dataList.append((sum(row), y))

# plot_K.main(dataList)
