# -*- coding: utf-8 -*-
"""
Created on Mon Sep 24 17:54:22 2018

@author: Despacito
"""

# importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# importing the dataset
dataSet = pd.read_csv("Position_Salaries.csv")
X = dataSet.iloc[:, 1:2].values # :2 used to convert X vector to matrix 
Y = dataSet.iloc[:, 2].values

# Fitting linear regression to the data set
from sklearn.linear_model import LinearRegression
linearRegressor_1 = LinearRegression()
linearRegressor_1.fit(X, Y)

# Fitting polynomial linear regression to the data set
from sklearn.preprocessing import PolynomialFeatures
polyLinearRegressor = PolynomialFeatures(degree = 4)
X_Poly = polyLinearRegressor.fit_transform(X)
linearRegressor_2 = LinearRegression()
linearRegressor_2.fit(X_Poly, Y)

# Visualizing the linear regression results
plt.scatter(X, Y, color = 'red')
plt.plot(X, linearRegressor_1.predict(X), color = 'blue')
plt.title("Truth of Bluff (Linear Regression)")
plt.xlabel("Position Level")
plt.ylabel("Salary")
plt.show()

# Visualizing the polynomial linear regression results
X_Grid = np.arange(min(X), max(X), 0.1)  # Increasing the resolution of X-Axis
X_Grid = X_Grid.reshape(len(X_Grid), 1) # Converting X_Grid type from vector to Matrix 
plt.scatter(X, Y, color = 'red')
plt.plot(X_Grid, linearRegressor_2.predict(polyLinearRegressor.fit_transform(X_Grid)), color = 'blue') # need clarity
plt.title("Truth of Bluff (Polynomial Linear Regression)")
plt.xlabel("Position Level")
plt.ylabel("Salary")
plt.show()

# Prediction as per the linear regression model
linearRegressor_1.predict(6.5)

# Prediction as per the polynomial linear regression model
linearRegressor_2.predict(polyLinearRegressor.fit_transform(6.5))



















