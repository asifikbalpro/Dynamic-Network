from random import random
import numpy as np
import time

node_A = []
node_B = []
degree = []
degreeAverage = []

# this will genarate network.and all the nodes that needed.
def nodeGenarator(netsize):
    print("node genarator")
    for i in range (netsize):
        degree.append(1)
        degreeAverage.append(0)

    for i in range (netsize):
        node_A.append(i+1)
        node_B.append(np.random.randint(i+1))
        degreeDistribution(node_B[i])

    # for i in range(len(node_A)):
    #     print(node_A[i], " ",  node_B[i])

# making degree total degree data.
# this will find the random value and put in right spot.
def degreeDistribution(rand):
    degree[rand] = degree[rand] + 1
    return degree

# making degree average data from here.
def degreeDistributionAverage(node):
    degreeAverage[node] = degreeAverage[node]+1 # putting in index of degree Average on degree Average index with +1
    return degreeAverage

# Degree distribution calling from here for average data.
def degreeDistributionAverageDane():
    print("degreeDistributionAverageDane")
    for i in range (len(degreeAverage)):
        degreeDistributionAverage(degree[i]) # calling degreeDistributionAverage() -> one argc needed

# data will be writen in this function.
# all the nodes
# all the degree
# all the average degree
def dataWrite():
    print("Data writing ")
    nodeFile = open("nodefile.txt","w")
    degreeFile = open("degreeDistribution.txt", "w")
    degreeAverageFile = open("degreeDistributionAverage.txt", "w")

    # for i in range(len(node_A)):
    #     nodeFile.write('{0} \t {1} \n'.format(node_A[i], node_B[i]))
    #
    # for i in range(1, len(degree)):
    #     degreeFile.write('{0} \t {1} \n'.format(i,degree[i]))

    for i in range(1, 200):
        degreeAverageFile.write('{0} \t {1} \n'.format(i, degreeAverage[i]))

    nodeFile.close() # closing file
    degreeFile.close() # closing file
    degreeAverageFile.close() # closing file

# all the value from all the object will print / show here.
def view():
    print("viewing ")
    print("Node's")
    for i in range(len(node_A)):
        print (node_A[i], " ", node_B[i])
    print("degree")
    for i in range(len(degree)):
        print(i, " ",degree[i])
    print("degree average")
    for i in range(len(degreeAverage)):
        print (i, " ", degreeAverage[i])


startTime = time.time() # for program time

# all the functions all called from here.
nodeGenarator(1000000)
degreeDistributionAverageDane()
# view()
dataWrite()

print('program time : {0} sec'.format(time.time() - startTime)) # end of program time calculated
