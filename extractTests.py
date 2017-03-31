#!/usr/bin/python

# TODO replace alfanoe stuff with vars
# TODO change hardcoded number of exercises
# TODO
# TODO change output format for k-means
import os
import sys
import subprocess
import string

NUM_ASSIGNMENTS = 18

compile = 'javac /Users/alfanoe/Downloads/pa6-calendar-student-1/src/edu/wit/cs/comp1000/tests/PA6aTestCase.java -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/junit-4.12.jar:/Users/alfanoe/Downloads/pa6-calendar-student-1/src'
run = 'java -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=61533:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/junit/lib/junit-rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/tools.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib/junit-4.12.jar:/Users/alfanoe/Downloads/pa6-calendar-student-1/out/production/pa6-calendar-student-1:/Users/alfanoe/Downloads/pa6-calendar-student-1/junit-4.1.jar" com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 edu.wit.cs.comp1000.tests.PA6aTestCase'

javafile = '/Users/alfanoe/Downloads/pa6-calendar-student-1/src/edu/wit/cs/comp1000/tests/PA6aTestCase.java'


def checkTests(out):
    if "testFailed" in out:
        fail = []
        for line in out.split('\n'):
            if "testFailed" in line:
                list = line.split(" ")
                print "FAILED: ", list[1]
                fail.append(list[1])
        return "LIST", fail
    else:
        return "PASSED ALL"


for i in range(1, NUM_ASSIGNMENTS + 1):

    print "\n**OPENING ", i
    try:
        f = open(javafile, 'r')
    except IOError, e:
        print "Could not open file."
        sys.exit()
    filedata = f.read()
    f.close()

    # TODO: regex
    oldtest = "	private static calendar.source.PA6a" + str(i - 1) + " testClass;"
    newtest = "	private static calendar.source.PA6a" + str(i) + " testClass;"

    # f = open(javafile, 'r')
    # newf = open(javafile + "")
    # for line in f:
    # 	if "	private static calendar.source.PA6a" in line:
    # 				newf.write(newtest)
    # 	else:
    # 		newf.write(line)

    # print "*********NEW FILE IS:"
    # print newf

    if i != 1:
        newdata = filedata.replace(oldtest, newtest)

        f = open(javafile, 'w')
        f.write(newdata)
        f.close()
    else:
        oldtest = "	private static calendar.source.PA6a18 testClass;"
        newdata = filedata.replace(oldtest, newtest)

        f = open(javafile, 'w')
        f.write(newdata)
        f.close()

    os.system(compile)
    os.system(
        "cp /Users/alfanoe/Downloads/pa6-calendar-student-1/src/edu/wit/cs/comp1000/tests/PA6aTestCase.class /Users/alfanoe/Downloads/pa6-calendar-student-1/out/production/pa6-calendar-student-1/edu/wit/cs/comp1000/tests")
    # out = os.system(run)
    out = subprocess.Popen([run], stdout=subprocess.PIPE, shell=True)
    out = out.stdout.read()

    print "CHECKING", i, "\n", checkTests(out)

print "\nCOMPLETE"
