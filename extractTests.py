#!/usr/bin/python

import os
import sys
import subprocess
import string

# TODO replace alfanoe stuff with vars
# TODO change hardcoded number of exercises
# TODO change output format for k-means

#RUN FROM DIR pa6-calendar-student
NUM_ASSIGNMENTS = 18

javafile = 'src/edu/wit/cs/comp1000/tests/PA6aTestCase.java'
compile = "javac " + javafile + ' -classpath src:src/junit-4.12.jar'
run = 'java -cp src/junit-4.12.jar:src/hamcrest-core-1.3.jar:src org.junit.runner.JUnitCore edu.wit.cs.comp1000.tests.PA6aTestCase'

def checkTests(out):
    if "OK (" in out:
        return "PASSED ALL"
    else:
        print "SOMETHING FAILED !!"
        fail = []
        for line in out.split('\n'):
            #print line
            if ") test" in line:
                #print "FAILED", line
                list = line.split("(")
                #print "LIST", list
                fail.append(list[0])
                #print "FAIL", fail
        return "FAILED", fail


for i in range(1, NUM_ASSIGNMENTS + 1):
    try:
        f = open(javafile, 'r')
    except IOError, e:
        print "Could not open file."
        sys.exit()
    filedata = f.read()
    f.close()

    # TODO: regex
    oldtest = "    private static calendar.source.PA6a" + str(i - 1) + " testClass;"
    newtest = "    private static calendar.source.PA6a" + str(i) + " testClass;"

    if i != 1:
        newdata = filedata.replace(oldtest, newtest)

        f = open(javafile, 'w')
        f.write(newdata)
        f.close()
    else:
        oldtest = "    private static calendar.source.PA6a18 testClass;"
        newdata = filedata.replace(oldtest, newtest)

        f = open(javafile, 'w')
        f.write(newdata)
        f.close()

    os.system(compile)
    out = subprocess.Popen([run], stdout=subprocess.PIPE, shell=True) #run java file via subprocess to fix stdout and stderr
    out = out.stdout.read()

    print "\nCHECKING", i, "\n", checkTests(out)

print "\nCOMPLETE"