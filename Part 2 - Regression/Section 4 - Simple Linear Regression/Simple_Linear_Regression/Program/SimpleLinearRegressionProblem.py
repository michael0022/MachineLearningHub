# -*- coding: utf-8 -*-
"""
Created on Thu Sep 13 21:06:52 2018

@author: Despacito
"""

# Data Preprocessing Template

# importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# importing the dataset
dataSet = pd.read_csv("Salary_Data.csv")
X = dataSet.iloc[:, :-1].values
Y = dataSet.iloc[:, 1].values


# splitting dataset into training and test set.
from sklearn.cross_validation import train_test_split
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 1/3, random_state = 0)

# feature scaling
""" from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test) """ 

#Fitting the training set to regression model
from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train, Y_train)

# Predicting the test set results
Y_pred = regressor.predict(X_test)

# Visualizing the training set result
plt.scatter(X_train, Y_train, color = 'red')
plt.plot(X_train, regressor.predict(X_train), color = 'blue')
plt.title('Salary vs Experience (Training Set)')
plt.xlabel("Years Of Experience")
plt.ylabel("Salary")
plt.show()

# Visualizing the test set result
plt.scatter(X_test, Y_test, color = 'red')

# No test points because we have to examine our test data corresponsding to training data
plt.plot(X_train, regressor.predict(X_train), color = 'blue')

plt.title('Salary vs Experience (Test Set)')
plt.xlabel("Years Of Experience")
plt.ylabel("Salary")
plt.show()





















