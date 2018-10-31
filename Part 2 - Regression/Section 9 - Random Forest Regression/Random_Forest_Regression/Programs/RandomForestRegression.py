# -*- coding: utf-8 -*-
"""
Created on Wed Sep 26 14:51:03 2018

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

# splitting dataset into training and test set.
""" from sklearn.cross_validation import train_test_split
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.2, random_state = 0) """

# feature scaling
""" from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test) """ 

# Fitting the regression model to the data set
from sklearn.ensemble import RandomForestRegressor
regressor = RandomForestRegressor(n_estimators = 300, criterion = "mse", random_state = 0) # mse is mean sqaure error
regressor.fit(X, Y)


# Predicting the new result with polynomial regression
Y_Pred = regressor.predict(6.5)

# Visualizing the polynomial linear regression results
plt.scatter(X, Y, color = 'red')
plt.plot(X, regressor.predict(X), color = 'blue') # need clarity
plt.title("Truth of Bluff (Regression Model)")
plt.xlabel("Position Level")
plt.ylabel("Salary")
plt.show()

# Visualizing the Random Forest regression results with enhanced resolution
X_Grid = np.arange(min(X), max(X), 0.01)  # Increasing the resolution of X-Axis
X_Grid = X_Grid.reshape(len(X_Grid), 1) # Converting X_Grid type from vector to Matrix 

plt.scatter(X, Y, color = 'red')
plt.plot(X_Grid, regressor.predict(X_Grid), color = 'blue') # need clarity
plt.title("Truth of Bluff (Random Forest Regression Model)")
plt.xlabel("Position Level")
plt.ylabel("Salary")
plt.show()
