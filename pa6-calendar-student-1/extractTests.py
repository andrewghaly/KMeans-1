#!/usr/bin/python
# Student sections: s1=1-18 s2 = 19-37 s3 = 38-60

import os, sys, subprocess, glob, re

# TODO change output format for k-means

# RUN FROM DIR pa6-calendar-student
utestfile = 'src/edu/wit/cs/comp1000/tests/PA6aTestCase.java'
studentcode = 'src/edu/wit/cs/comp1000/'
compile = "javac " + utestfile + ' -classpath src:junit-4.12.jar'
run = 'java -cp junit-4.12.jar:hamcrest-core-1.3.jar:src org.junit.runner.JUnitCore edu.wit.cs.comp1000.tests.PA6aTestCase'
resultsDict = {}


def testNames():
    # Getting names of all tests PA6aTestCase
    try:
        f = open(utestfile, 'r')
    except IOError, e:
        print "Could not open file."
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

# # Parses the output from running the unit tests
# # Appends it into a dictionary with results
def checkTests(out):
    if "OK (" in out:
        return []
    else:
        # print "SOMETHING FAILED !!"
        list = []
        r = re.compile(r"\) |\(")
        for line in out.split('\n'):
            if ") test" in line:
                failure = r.split(line)
                list.append(failure[1])
        return list


i = 1
print "Running unit tests"
for file in glob.glob(studentcode + '*.java'):
    print i,
    file_name_with_extension = file.split(studentcode + "PA6a")
    file_name = file_name_with_extension[1][:-5]
    try:
        f = open(utestfile, 'r')
    except IOError, e:
        print "Could not open file."
        sys.exit()
    filedata = f.read()
    f.close()

    # Changes the class used to run the unit tests
    newtest = "    private static edu.wit.cs.comp1000.PA6a" + file_name + " testClass;"

    # Search and replace the old class for the one set to newtest
    for line in filedata.split('\n'):
        if "private static edu.wit.cs.comp1000.PA6a" in line:
            oldtest = line
            newdata = filedata.replace(oldtest, newtest)

            f = open(utestfile, 'w')
            f.write(newdata)
            f.close()
    if not glob.glob(file[:-5] + ".class"):
        os.system(compile) #compile if not already compiled
    out = subprocess.Popen([run], stdout=subprocess.PIPE,
                           shell=True)  # run java file via subprocess to fix stdout and stderr
    out = out.stdout.read()

    # print "\nCHECKING", i
    check = checkTests(out)
    # print check

    resultsDict[i] = check

    i += 1
print "\nCOMPLETE\n"
# print resultsDict

tests = testNames()
matrix = list()

total_num_tests = len(tests)

for index, results in resultsDict.items():
    print index, results, "Failed: ", len(results), "/", total_num_tests

# print "TESTS", tests

# temp printing stuff
print "\n\t",
for test in tests:
    print str(tests.index(test) + 1) + " ",
print "\n\n"

for index, results in resultsDict.items():
    if results == 0:
        row = []
        for test in tests:
            row.append(1)
        matrix.append(row)
        #print index, "\t", row  # temp printing stuff
    else:
        row = []
        for test in tests:
            if test not in results:
                row.append(1)
            else:
                row.append(0)
        matrix.append(row)
        #print index, "\t", row,  # temp printing stuff
        y = 0
        if row[0] == 1 or row[3] == 1:
            y += 1
        if row[1] == 1 or row[6] == 1:
            y += 1
        if row[5] == 1:
            y += 1
        if row[2] == 1 or row[4] == 1:
            y += 1
        print "({0}, {1})".format(sum(row), y)
        # for row in matrix:
        #     print row
