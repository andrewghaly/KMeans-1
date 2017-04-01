#!/usr/bin/python

import os
import sys
import subprocess
import string
import glob
import re

# TODO change output format for k-means

# RUN FROM DIR pa6-calendar-student

utestfile = 'src/edu/wit/cs/comp1000/tests/PA6aTestCase.java'
studentcode = 'src/calendar/source/'
compile = "javac " + utestfile + ' -classpath src:src/junit-4.12.jar'
run = 'java -cp src/junit-4.12.jar:src/hamcrest-core-1.3.jar:src org.junit.runner.JUnitCore edu.wit.cs.comp1000.tests.PA6aTestCase'


def checkTests(out):
    if "OK (" in out:
        return "PASSED ALL"
    else:
        print "SOMETHING FAILED !!"
        failed = []
        r = re.compile(r"\) |\(")
        for line in out.split('\n'):
            if ") test" in line:
                # list = line.split("(")
                list = r.split(line)
                failed.append(list[1])
        return failed


i = 1
for file in glob.glob(studentcode + '*.java'):
    try:
        f = open(utestfile, 'r')
    except IOError, e:
        print "Could not open file."
        sys.exit()
    filedata = f.read()
    f.close()

    newtest = "    private static calendar.source.PA6a" + str(i) + " testClass;"

    for line in filedata.split('\n'):
        if "private static calendar.source.PA6a" in line:
            oldtest = line
            newdata = filedata.replace(oldtest, newtest)

            f = open(utestfile, 'w')
            f.write(newdata)
            f.close()

    os.system(compile)
    out = subprocess.Popen([run], stdout=subprocess.PIPE,
                           shell=True)  # run java file via subprocess to fix stdout and stderr
    out = out.stdout.read()

    print "\nCHECKING", i, "\n", checkTests(out)
    i += 1

print "\nCOMPLETE"