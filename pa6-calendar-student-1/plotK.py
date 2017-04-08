import matplotlib.pyplot as plt
import numpy as np
from math import sqrt
import random


class Centroid:
    def __init__(self, color, position):
        self.color = color
        self.position = position
        self.coordinateList = list()

    def euclid(self, b):
        """
        Euclidean Distance Algorithm for two points
        sqrt((x1-x2)^2 + (y1-x2)^2))
        """
        x, y = self.position
        input_x, input_y = b.position
        return sqrt((x - input_x) ** 2 + (y - input_y) ** 2)

    def plot(self):
        """Adds point to the current plot"""
        x, y = self.position
        plt.scatter(x, y, s=250, marker=u'^', color=self.color, zorder=5)

    def computePosition(self):
        """Computes the mean of all points in self.coordinateList()"""
        if self.coordinateList:
            x_value_list = list()
            y_value_list = list()
            for i in self.coordinateList:
                x, y = i.position
                x_value_list.append(x)
                y_value_list.append(y)

            self.position = (np.mean(x_value_list), np.mean(y_value_list))

    def equals(self, input_position):
        """Checks if two Centroids are in the same position"""
        if input_position[0] == self.position[0] and input_position[1] == self.position[1]:
            return True
        else:
            return False

    def __str__(self):
        stringRep = str(
            "Centroid ({0},{1}), has {2} points".format(int(self.position[0]), int(self.position[1]),
                                                        len(self.coordinateList))
        )
        return stringRep


class Coordinate:
    def __init__(self, position, color):
        self.position = position
        self.color = color

    def plot(self):
        """Adds point to the current plot"""
        x, y = self.position
        plt.scatter(x, y, marker="o", color=self.color, alpha=.35, s=75)


def plotCoordinates(coordinateList, centroidList):
    """
    Plots the individual points on the map
    Find the closest centroid to a given coordinate
    Add that point to the centroidList and plot it on the map
    """

    # Reset the coordinateList for each Centroid
    for current_centroid in centroidList:
        current_centroid.coordinateList = list()

    # Calculate the nearest Centroid
    # Append it to the Centroid's coordinate list
    # Color the coordinate the same as the Centroid
    for coordinate in coordinateList:

        # Get a list of all the distances to the Centroids
        distanceList = list()
        for centroid in centroidList:
            distanceList.append(centroid.euclid(coordinate))

        # Gets the lowest numerical distance to a centroid
        minDistance = min(distanceList)

        # Find the index of the closest distance
        # Use that index to get the closest Centroid
        # Apply all the properties to the Coordinate
        for i in range(len(centroidList)):
            temp_distance = distanceList[i]

            if temp_distance == minDistance:
                closestCentroid = centroidList[i]
                closestCentroid.coordinateList.append(coordinate)
                coordinate.color = closestCentroid.color
                coordinate.plot()


def plotCentroids(centroidList):
    """ Plots centroids on to graph"""
    for centroid in centroidList:
        centroid.plot()


def plotGraph(inCentroidList, inCoordinateList):
    """ 
    Plot the centroid and Coordinates 
    Apply the axis to the graph window
    """
    plotCentroids(inCentroidList)
    plotCoordinates(inCoordinateList, inCentroidList)
    plt.xlabel('# of tests passed', fontsize=16, style='italic')
    plt.ylabel('# of tests passed (weighted) ', fontsize=16, style='italic')
    for centroid in inCentroidList:
        print centroid
    print "\n"
    plt.show()


def generateUniqueCentroids(k, dataList):
    """
    Generates a list of centroids used in the k-Means graph
    Selects k-unique coordinates that exist within the data
    Returns the set of coordinates
    """
    uniqueCoordinateList = list()

    # Find all unique coordinates in the list
    for coordinate in dataList:

        # Check that it's not already in the set
        if coordinate not in uniqueCoordinateList:
            uniqueCoordinateList.append(coordinate)

    # Generate k-number of random coordinates
    centroidList = list()

    while len(centroidList) != k and uniqueCoordinateList:
        centroid = random.choice(uniqueCoordinateList)
        uniqueCoordinateList.remove(centroid)

        if centroid not in centroidList:
            centroidList.append(centroid)

    return centroidList


def generateRandomCentroids(k, dataList):
    """
    Generates a list of centroids used in the k-Means graph
    Uses the max x and y values for the upper bounds of the generated coordinates
    Randomly generate k-coordinates within the the bounds
    Returns the list of the coordinates
    """
    # Compute the max x and y values
    maxY = max([yCoordinate[1] for yCoordinate in dataList])
    maxX = max([xCoordinate[0] for xCoordinate in dataList])

    # Selects k-number of unique x and y values
    # Using the bounds from maxX and maxY
    coordinateY = maxY * np.random.random((k, 1))
    coordinateX = maxX * np.random.random((k, 1))

    # Iterates through combining the values as coordinates into a list
    centroidList = [(coordinateX[i], coordinateY[i]) for i in range(k)]
    return centroidList


def main(dataList, k):
    # Lambda function to generate a random color
    r = lambda: random.randint(0, 255)

    # Convert the coordinates into Coordinate objects
    # Fill it into a list
    plottedCoordinateList = list()
    for position in dataList:
        plottedCoordinateList.append(Coordinate(position, None))

    # <-----Algorithms to generate Centroid positions----->
    # This will generate k-unique coordinates from x
    randomCentroidList = generateUniqueCentroids(k, dataList)

    # Generate k-random coordinates within the data set
    # randomCentroidList = generateRandomCentroids(k, dataList)
    # <-----End Centroid Generation Algorithms----->

    # Creates the list of Centroid objects
    plottedCentroidList = list()
    for centroid_position in randomCentroidList:
        plottedCentroidList.append(Centroid('#%02X%02X%02X' % (r(), r(), r()), centroid_position))

    # Initial Centroid
    plotGraph(plottedCentroidList, plottedCoordinateList)

    # Keep plotting new graph
    # until positions do not change
    completed = 0
    while completed != len(plottedCentroidList):
        completed = 0
        for centroid in plottedCentroidList:
            oldPosition = centroid.position
            centroid.computePosition()
            if centroid.equals(oldPosition):
                completed += 1
        plotGraph(plottedCentroidList, plottedCoordinateList)
