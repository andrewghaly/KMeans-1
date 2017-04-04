import matplotlib.pyplot as plt
import numpy as np
from math import sqrt
from random import randint


class Centroid:
    def __init__(self, number, color, position):
        self.number = number
        self.color = color
        self.position = position
        self.coordinateList = list()

    def euclid(self, b):
        """
        Euclidean Distance Algorithm
        SQRT((x1-x2)^2 + (y1-x2)^2))
        """
        x, y = self.position
        input_x, input_y = b.position
        return sqrt((x - input_x) ** 2 + (y - input_y) ** 2)

    def plot(self):
        x, y = self.position
        plt.scatter(x, y, s=250, marker=u'^', color=self.color, zorder=5)

    def computePosition(self):
        x_value_list = list()
        y_value_list = list()
        for i in self.coordinateList:
            x, y = i.position
            x_value_list.append(x)
            y_value_list.append(y)

        self.position = (np.mean(x_value_list), np.mean(y_value_list))

    def equals(self, input_position):
        if input_position[0] == self.position[0] and input_position[1] == self.position[1]:
            return True
        else:
            return False


class Coordinate:
    """
    Structure for each point

    """

    def __init__(self, position, color):
        self.position = position
        self.color = color

    def plot(self):
        x, y = self.position
        plt.scatter(x, y, marker="o", color=self.color, alpha=.5)


def plotCoordinates(coordinateList, centroidList):
    """
    Plots the individual points on the map
    Find the closest centroid to a given coordinate
    Add that point to the centroidList and plot it on the map
    """
    for current_centroid in centroidList:
        current_centroid.coordinateList = list()

    for coordinate in coordinateList:
        distanceList = list()
        for centroid in centroidList:
            distanceList.append(centroid.euclid(coordinate))

        minDistance = min(distanceList)

        for i in range(len(centroidList)):
            temp_distance = distanceList[i]

            if temp_distance == minDistance:
                closestCentroid = centroidList[i]
                closestCentroid.coordinateList.append(coordinate)
                coordinate.color = closestCentroid.color
                coordinate.plot()


def plotCentroids(centroidList):
    """ Plots the centroids on the map """
    for centroid in centroidList:
        centroid.plot()


def main(dataList):
    k = 2
    r = lambda: randint(0, 255)
    # numberOfCoordinates = int(sys.argv[2])
    # coordinates = len(x) * np.random.random((numberOfCoordinates, 2)) + 1

    coordinateList = list()
    for position in dataList:
        coordinateList.append(Coordinate(position, None))

    # This will generate 3 unique coordinates from x
    randomCentroidList = list()
    while len(randomCentroidList) != k:
        newCoordinate = dataList[np.random.randint(0, len(dataList))]
        if newCoordinate not in randomCentroidList:
            randomCentroidList.append(newCoordinate)

    # This will generate 3 random coordinates from x
    # randomCentroidList = 10 * np.random.random((k, 2)) + 1
    # randomCentroidList = [x[index] for index in
    #                       [np.random.randint(0, len(x)) for i in range(0, k)]]

    centroidList = list()
    i = 0
    for centroid_position in randomCentroidList:
        centroidList.append(Centroid(i, '#%02X%02X%02X' % (r(), r(), r()), centroid_position))
        i += 1

    # Initial Centroid
    plotCentroids(centroidList)
    plotCoordinates(coordinateList, centroidList)
    plt.show()

    completed = 0
    while completed != k:
        completed = 0
        for i in centroidList:
            tempPosition = i.position
            i.computePosition()
            if i.equals(tempPosition):
                completed += 1
        plotCentroids(centroidList)
        plotCoordinates(coordinateList, centroidList)
        plt.show()
