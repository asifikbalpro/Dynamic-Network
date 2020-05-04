import matplotlib.pyplot as plt
import numpy as np

X, Y = [], []
for line in open('degree_average.txt', 'r'):
  	values = [float(s) for s in line.split()]
  	X.append(values[0])
  	Y.append(values[1])

#plt.plot(X, Y)
#plt.show()
plt.plot(np.log(X), np.log(Y))
plt.show()