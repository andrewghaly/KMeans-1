import os
import re

path = """/Users/andrewghaly/Google Drive/Home/School/Classes/Semester VII/Artificial Intelligence/Project/pa6-calendar-student/source"""
for root, dirs, files in os.walk(path):
    for file in files:
        if file.endswith(".java"):
            originalPath = os.path.join(root, file)
            parentFolder = os.path.basename(os.path.normpath(root))
            finalPath = os.path.join(path, file[:-5] + parentFolder + file[-5:])
            os.rename(originalPath, finalPath)

            className = file[:-5] + parentFolder

            f = open(finalPath, "r")
            lines = f.readlines()
            f.close()

            f = open(finalPath, "w")
            for line in lines:
                line = re.sub(r"class %s" % file[:-5], "class " + className, line)
                f.write(line)

        os.rmdir(root)
