from random import randrange
import numpy as np
import time

node_A = []
node_B = []
degree = []
degreeAverage = []
degreeMultiple = [] # this will sum all the times that degree average value are created.
breakingmultiple = [] # this will find the average from those multiple value.
netsize = 10000
runTimes = 100

def initValues(netsize):
    for i in range(netsize):
        degreeAverage.append(0)
        degreeMultiple.append(0)

# this will genarate network.and all the nodes that needed.
def nodeGenarator(netsize):
    # print("node genarator")
    for i in range (netsize):
        node_A.append(i+1)
        node_B.append(randrange(i+1))
        degree.append(1)
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
    # print("degreeDistributionAverageDane")
    for i in range (len(degreeAverage)):
        degreeDistributionAverage(degree[i]) # calling degreeDistributionAverage() -> one argc needed

# data will be writen in this function.
# all the nodes
# all the degree
# all the average degree
def dataWrite(i):
    print("Data writing ")
    nodeFile = open("nodefile.txt","w")
    degreeFile = open("degreeDistribution.txt", "w")
    degreeAverageFile = open("Data\\degreeDistributionAverage"+str(i)+".txt", "w")

    # for i in range(len(node_A)):
    #     nodeFile.write('{0} \t {1} \n'.format(node_A[i], node_B[i]))
    #
    # for i in range(1, len(degree)):
    #     degreeFile.write('{0} \t {1} \n'.format(i,degree[i]))

    for i in range(1, 200):
        degreeAverageFile.write('{0} \t {1} \n'.format(i, breakingmultiple[i]))

    nodeFile.close() # closing file
    degreeFile.close() # closing file
    degreeAverageFile.close() # closing file

# this will clone the degree average value and sum all the value in degree multiple.
def cloning():
    # print("entering cloning")
    for i in range(len(degreeAverage)):
        degreeMultiple[i] += degreeAverage[i]

    # for i in range(netsize):
    #     print(degreeMultiple[i])

def finalizingValue():
    print("finalizing ")
    for i in range(len(degreeMultiple)):
        breakingmultiple.append(degreeMultiple[i]/runTimes)

    # for i in range(len(breakingmultiple)):
    #     print(breakingmultiple[i])

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

def clear():
    node_A.clear()
    node_B.clear()
    degree.clear()
    degreeAverage.clear()

startTime = time.time() # for program time

# all the functions all called from here.
# nodeGenarator(1000000)
# degreeDistributionAverageDane()
# view()
# dataWrite()

# run same program multiple times
# initValues(netsize)
# for i in range(runTimes):
#     print("current runtime: {}".format(i))
#     nodeGenarator(netsize)
#     degreeDistributionAverageDane()
#     cloning()
#     clear()
# finalizingValue()
# dataWrite()

# for creating multiple file.

for i in range(5):
    initValues(netsize)
    print("current runtime: {}".format(i))
    for j in range(runTimes):
        # print("current runtime: {}".format(j))
        nodeGenarator(netsize)
        degreeDistributionAverageDane()
        cloning()
        clear()
    finalizingValue()
    dataWrite(i)
    degreeMultiple.clear()
    breakingmultiple.clear()


print('program time : {0} sec'.format(time.time() - startTime)) # end of program time calculated









