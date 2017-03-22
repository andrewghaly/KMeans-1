import os

path = """/pa6-calendar-student/source"""
for root, dirs, files in os.walk(path):
    for file in files:
        if file.endswith(".java"):
            originalPath = os.path.join(root, file)
            parentFolder = os.path.basename(os.path.normpath(root))
            finalPath = os.path.join(path, file[0:4] + parentFolder[-3:] + file[4:])
            os.rename(originalPath, finalPath)
            os.rmdir(root)

