# -*- coding: utf-8 -*-
"""
Created on Tue Sep 25 15:21:05 2018

@author: Despacito
"""

# importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# importing the dataset
dataSet = pd.read_csv("Position_Salaries.csv")
X = dataSet.iloc[:, 1:2].values # :2 used to convert X vector to matrix 
Y = dataSet.iloc[:, 2:3].values

# splitting dataset into training and test set.
""" from sklearn.cross_validation import train_test_split
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.2, random_state = 0) """

# feature scaling
from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
sc_Y = StandardScaler()
X = sc_X.fit_transform(X)
Y = sc_Y.fit_transform(Y) 

# Fitting SVR to the data set
from sklearn.svm import SVR
regressor = SVR(kernel = 'rbf')
regressor.fit(X, Y)

# Predicting the new result
Y_Pred = sc_Y.inverse_transform(regressor.predict(sc_X.transform(np.array([[6.5]]))))

# Visualizing the SVR results
plt.scatter(X, Y, color = 'red')
plt.plot(X, regressor.predict(X), color = 'blue') # need clarity
plt.title("Truth of Bluff (SVR Model)")
plt.xlabel("Position Level")
plt.ylabel("Salary")
plt.show()
