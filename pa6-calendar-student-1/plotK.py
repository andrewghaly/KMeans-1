import matplotlib.pyplot as plt
import numpy as np
from math import sqrt
from random import randint


class Centroid:
    def __init__(self, color, position):
        self.color = color
        self.position = position
        self.coordinateList = list()

    def euclid(self, b):
        """
        Euclidean Distance Algorithm
        sqrt((x1-x2)^2 + (y1-x2)^2))
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
        plt.scatter(x, y, marker="o", color=self.color, alpha=.35, s=75)


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


def plotGraph(inCentroidList, inCoordinateList):
    plotCentroids(inCentroidList)
    plotCoordinates(inCoordinateList, inCentroidList)
    plt.xlabel('# of tests passed', fontsize=16, style='italic')
    plt.ylabel('# of tests passed (weighted) ', fontsize=16, style='italic')
    plt.show()


def main(dataList, k):
    r = lambda: randint(0, 255)

    coordinateList = list()
    for position in dataList:
        coordinateList.append(Coordinate(position, None))

    # <-----Algorithms to generate Centroids----->
    # This will generate 3 unique coordinates from x
    randomCentroidList = list()
    while len(randomCentroidList) != k:
        newCoordinate = dataList[np.random.randint(0, len(dataList))]
        if newCoordinate not in randomCentroidList:
            randomCentroidList.append(newCoordinate)

    # Generate 3 random coordinates within the data set
    # Get the max bounds for the coordinates
    # maxY = max([yCoordinate[1] for yCoordinate in dataList])
    # maxX = max([xCoordinate[0] for xCoordinate in dataList])
    # coordinateY = maxY * np.random.random((k,1))
    # coordinateX = maxX * np.random.random((k,1))
    # randomCentroidList = [(coordinateX[i], coordinateY[i])for i in range(0,k)]
    # <-----End Centroid Generation Algorithms----->

    centroidList = list()
    i = 0
    for centroid_position in randomCentroidList:
        centroidList.append(Centroid('#%02X%02X%02X' % (r(), r(), r()), centroid_position))
        i += 1

    # Initial Centroid
    plotGraph(centroidList, coordinateList)

    # Keep plotting new graph
    # until positions do not change
    completed = 0
    while completed != k:
        completed = 0
        for i in centroidList:
            tempPosition = i.position
            i.computePosition()
            if i.equals(tempPosition):
                completed += 1
        plotGraph(centroidList, coordinateList)
