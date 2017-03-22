import matplotlib.pyplot as plt
import numpy as np
from math import sqrt


class Centroid():
    def __init__(self, iter, color, position):
        self.iter = iter
        self.color = color
        self.position = position

    def euclid(self, a, b):
        """
        Euclidean Distance Algorithm
        SQRT((x1-x2)^2 + (y1-x2)^2))
        """
        return sqrt((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2)

    def plot(self, x, y):
        plt.scatter(x, y, marker="o", color=self.color, alpha=.5)

def euclid(a, b):
    """
    Euclidean Distance Algorithm
    SQRT((x1-x2)^2 + (y1-x2)^2))
    """
    return sqrt((a[0] - b[0])**2 + (a[1] - b[1])**2)

def plotCoordinates(coordinates, centroidList, centroidCoordinateList):
    """
    Plots the individual points on the map
    Find the closest centroid to a given coordinate
    Add that point to the centroidList and plot it on the map
    """
    centroid1Length = len(centroidCoordinateList[0])
    centroid2Length = len(centroidCoordinateList[1])
    centroid3Length = len(centroidCoordinateList[2])
    centroid4Length = len(centroidCoordinateList[3])

    for x, y in coordinates:
        # Calculate the distance from the coordinate to each centroid
        tempCentroid1 = euclid((x, y), centroidList[0])
        tempCentroid2 = euclid((x, y), centroidList[1])
        tempCentroid3 = euclid((x, y), centroidList[2])
        tempCentroid4 = euclid((x, y), centroidList[3])

        # Find the closest centroid to the point
        lowest = min(tempCentroid1, tempCentroid2, tempCentroid3, tempCentroid4)

        # Add the point to the list and plot it on the map
        if lowest == tempCentroid1:
            centroidCoordinateList[0][0].append(x)
            centroidCoordinateList[0][1].append(y)
            plt.scatter(x, y, marker="o", color="r", alpha=.5)
        elif lowest == tempCentroid2:
            centroidCoordinateList[1][0].append(x)
            centroidCoordinateList[1][1].append(y)
            plt.scatter(x, y, marker="o", color="g", alpha=.5)
        elif lowest == tempCentroid3:
            centroidCoordinateList[2][0].append(x)
            centroidCoordinateList[2][1].append(y)
            plt.scatter(x, y, marker="o", color="b", alpha=.5)
        elif lowest == tempCentroid4:
            centroidCoordinateList[3][0].append(x)
            centroidCoordinateList[3][1].append(y)
            plt.scatter(x, y, marker="o", color="c", alpha=.5)
    # Show the map
    plt.show()

    # if centroid1Length != len(centroidCoordinateList[0]) or centroid2Length != len(centroidCoordinateList[1]) or centroid3Length != len(centroidCoordinateList[2]) or centroid4Length != len(centroidCoordinateList[3]):
    #     finished = False

    return centroidCoordinateList

def plotCentroids(centroidList):
    """ Plots the centroids on the map """
    for centroid in centroidList:
        plt.scatter(centroid[0], centroid[1], s=250, marker=u'^', color="black", zorder=5)

def calculateNewCentroids(centroidMasterList):
    """ Calculate the new centroids using the means of each list """
    return (
        (np.mean(centroidMasterList[0][0]), np.mean(centroidMasterList[0][1])),
        (np.mean(centroidMasterList[1][0]), np.mean(centroidMasterList[1][1])),
        (np.mean(centroidMasterList[2][0]), np.mean(centroidMasterList[2][1])),
        (np.mean(centroidMasterList[3][0]), np.mean(centroidMasterList[3][1]))
    )

def start():
    k = 4
    numberOfCoordinates = 200
    coordinates = 10 * np.random.random((numberOfCoordinates, 2)) + 1

    # Build a new list of x and list of y for each k
    centroidCoordinateList = list()
    for i in range(k):
        centroidCoordinateList.append((list(),list()))

    # Initial Centroid
    centroidList = 10 * np.random.random((k, 2)) + 1
    plotCentroids(centroidList)
    centroidCoodinateList = plotCoordinates(coordinates, centroidList, centroidCoordinateList)

    # Generate next centroid and plot
    for i in range(10):
        centroidList = calculateNewCentroids(centroidCoordinateList)
        plotCentroids(centroidList)
        centroidCoodinateList = plotCoordinates(coordinates, centroidList, centroidCoordinateList)


start()