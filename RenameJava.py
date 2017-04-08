import os
import re
import sys


def main():
    if len(sys.argv) < 2:
        print "Please enter a path to the data directory."
        sys.exit()

    path = sys.argv[1]
    if os.path.exists(path):
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

        print "Renaming Complete."
    else:
        print "Please enter a valid path to the data directory."


if __name__ == "__main__":
    main()
