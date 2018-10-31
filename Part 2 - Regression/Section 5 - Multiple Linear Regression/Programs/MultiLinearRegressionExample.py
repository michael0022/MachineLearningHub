# -*- coding: utf-8 -*-
"""
Created on Sun Sep 16 11:02:38 2018

@author: Despacito
"""

# importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# importing the dataset
dataSet = pd.read_csv("50_Startups.csv")
X = dataSet.iloc[:, :-1].values
Y = dataSet.iloc[:, 4].values

#Encode categorical data
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
labelEncoder_X = LabelEncoder()
X[:, 3] = labelEncoder_X.fit_transform(X[:, 3])
oneHotEncoder = OneHotEncoder(categorical_features = [3])
X = oneHotEncoder.fit_transform(X).toarray()

# Avoiding the dummy variable trap
X = X[:, 1:]

# splitting dataset into training and test set.
from sklearn.cross_validation import train_test_split
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.2, random_state = 0)

# feature scaling
""" from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test) """ 

# Fitting multiple linear regression to the training set
from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train, Y_train)

# Predicting the test set results
Y_pred = regressor.predict(X_test)

# Building the optimal model using backward elimination
import statsmodels.formula.api as sm

#Adding column in front with all valeus as 1 to accomodate bZero variable
X = np.append(arr = np.ones([50, 1]).astype(int), values = X, axis = 1)

X_Opt = X[:, [0, 1, 2, 3 , 4, 5]]
regressor_OLS = sm.OLS(endog = Y, exog = X_Opt).fit()
regressor_OLS.summary()

# Highest P value column is removed and again fit without removed variable
X_Opt = X[:, [0, 1, 3, 4, 5]]
regressor_OLS = sm.OLS(endog = Y, exog = X_Opt).fit()
regressor_OLS.summary()

# Highest P value column is removed and again fit without removed variable
X_Opt = X[:, [0, 3, 4, 5]]
regressor_OLS = sm.OLS(endog = Y, exog = X_Opt).fit()
regressor_OLS.summary()

# Highest P value column is removed and again fit without removed variable
X_Opt = X[:, [0, 3, 5]]
regressor_OLS = sm.OLS(endog = Y, exog = X_Opt).fit()
regressor_OLS.summary()

# Highest P value column is removed and again fit without removed variable
X_Opt = X[:, [0, 3]]
regressor_OLS = sm.OLS(endog = Y, exog = X_Opt).fit()
regressor_OLS.summary()




