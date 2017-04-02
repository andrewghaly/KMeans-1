# See extractTests.py in pa6-calendar-student-1/extractTests.py
# #!/usr/bin/python
#
# import os
# import sys
# import subprocess
# import string
# import glob
# import re
# import time
#
# # TODO change output format for k-means
#
# # RUN FROM DIR pa6-calendar-student
# utestfile = 'src/edu/wit/cs/comp1000/tests/PA6aTestCase.java'
# studentcode = 'src/edu/wit/cs/comp1000/'
# compile = "javac " + utestfile + ' -classpath src:src/junit-4.12.jar'
# run = 'java -cp src/junit-4.12.jar:src/hamcrest-core-1.3.jar:src org.junit.runner.JUnitCore edu.wit.cs.comp1000.tests.PA6aTestCase'
#
# resultsDict = {}
#
#
# def checkTests(out):
#     if "OK (" in out:
#         return "OK"
#     else:
#         # print "SOMETHING FAILED !!"
#         list = []
#         r = re.compile(r"\) |\(")
#         for line in out.split('\n'):
#             if ") test" in line:
#                 failure = r.split(line)
#                 list.append(failure[1])
#         return list
#
#
# i = 1
# for file in glob.glob(studentcode + '*.java'):
#     file_name_with_extension = file.split("src/edu/wit/cs/comp1000/PA6a")
#     file_name = file_name_with_extension[1][:-5]
#     try:
#         f = open(utestfile, 'r')
#     except IOError, e:
#         print "Could not open file."
#         sys.exit()
#     filedata = f.read()
#     f.close()
#
#     newtest = "    private static edu.wit.cs.comp1000.PA6a" + file_name + " testClass;"
#
#     for line in filedata.split('\n'):
#         if "private static edu.wit.cs.comp1000.PA6a" in line:
#             oldtest = line
#             newdata = filedata.replace(oldtest, newtest)
#
#             f = open(utestfile, 'w')
#             f.write(newdata)
#             f.close()
#
#     os.system(compile)
#     out = subprocess.Popen([run], stdout=subprocess.PIPE,
#                            shell=True)  # run java file via subprocess to fix stdout and stderr
#     out = out.stdout.read()
#
#     # print "\nCHECKING", i
#     check = checkTests(out)
#     # print check
#
#     resultsDict[i] = check
#
#     i += 1
# # print "\nCOMPLETE\n"
# # print resultsDict
#
# for index, results in resultsDict.items():
#     print index, results, len(results)
#
