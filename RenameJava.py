import os
import re
import sys


def main():
    if len(sys.argv) < 2:
        print "Please enter a path to the data directory."
        sys.exit()

    path = sys.argv[1]
    if os.path.exists(path):
        # Given the root, find all directories and files
        for root, dirs, files in os.walk(path):
            for file in files:
                # If a file ends with .java we know it is a student submission
                if file.endswith(".java"):
                    # Path to the root
                    originalPath = os.path.join(root, file)
                    parentFolder = os.path.basename(os.path.normpath(root))
                    # Create the new file path which consists of the exercise name, the folder it was located
                    # followed by the extension (.java) in this example
                    finalPath = os.path.join(path, file[:-5] + parentFolder + file[-5:])

                    # Move the files out of their subdirectories to the source directory
                    os.rename(originalPath, finalPath)

                    # Prepare the class name for regex later on
                    className = file[:-5] + parentFolder

                    # Open every file to read to lines array
                    f = open(finalPath, "r")
                    lines = f.readlines()
                    f.close()

                    # Regex to change the class name of each file to correspond with the filename
                    f = open(finalPath, "w")
                    for line in lines:
                        line = re.sub(r"class %s" % file[:-5], "class " + className, line)
                        f.write(line)

        print "Renaming complete."
    else:
        print "Please enter a valid path to the data directory."


if __name__ == "__main__":
    main()
