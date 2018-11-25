# -*- coding: utf-8 -*-
"""
Created on Sun Nov 25 13:38:13 2018

@author: Despacito
"""

# Importing the libraries
import pandas as pd
import matplotlib.pyplot as plt

# Convert string to date format
from pandas import datetime
def parser(x):
    return datetime.strptime(x, '%Y-%m')

# Importing the dataset
sales = pd.read_csv('sales-cars.csv',index_col = 0, parse_dates = [0], date_parser = parser)

# Plotting the data
sales.plot()

# checking for stationarity uing Auto correlation function(ACF)
from statsmodels.graphics.tsaplots import plot_acf
plot_acf(sales)

# Integrated of order 1, to make data stationary. This is ARIMA model.
sales_diff = sales.diff(periods = 1)[1:]
plot_acf(sales_diff)
sales_diff.plot()

# Splitting the data into training and test set
X = sales.values
train_dataset = X[0:27]
test_dataset = X[26:]

predictions = []

# Creating the AutoRegressive Model (AR)
from statsmodels.tsa.ar_model import AR
from sklearn.metrics import mean_squared_error
model_ar = AR(train_dataset)
model_ar_fit = model_ar.fit()

# Predicting the result using AR model
predictions = model_ar_fit.predict(start = 27, end = 36)

# PLotting the test dataset and predictions of AR model
plt.plot(test_dataset)
plt.plot(predictions, color = 'red')

# Creating the Arima Model(p, d, q)
# p = periods taken for autoregressive model
# d = order of integration, how many time differencing is done
# q = number of periods in moving average model
from statsmodels.tsa.arima_model import ARIMA
model_arima = ARIMA(train_dataset, order = (4, 1, 0))
model_arima_fit = model_arima.fit()
print(model_arima_fit.aic) # 295.9979

# Prediction the result using ARIMA model
predictions = model_arima_fit.forecast(steps = 10)[0]

# PLotting the test dataset and predictions of ARIMA model
plt.plot(test_dataset)
plt.plot(predictions, color = 'red')

# Caluclate minimum AIC for different p, d, q
import itertools
p = d = q = range(0, 5)
pdq = list(itertools.product(p, d, q))
lesser_aic = 100000
pdq_for_lesser_aic = []

import warnings
warnings.filterwarnings('ignore')
for param in pdq:
    try: # because some combinations of p, d, q are not compatible, throwing exception
        model_arima = ARIMA(train_dataset, order = param)
        model_arima_fit = model_arima.fit()
        current_aic = model_arima_fit.aic
        if(current_aic < lesser_aic):
            lesser_aic = current_aic
            pdq_for_lesser_aic = param
        
    except:
        continue


# Now we can retrain the ARIMA model for that combination of p,d,q which has calculated less AIC above
from statsmodels.tsa.arima_model import ARIMA
model_arima = ARIMA(train_dataset, order = pdq_for_lesser_aic)
model_arima_fit = model_arima.fit()
print(model_arima_fit.aic) # 295.9979

# Prediction the result using ARIMA model
predictions = model_arima_fit.forecast(steps = 10)[0]

# PLotting the test dataset and predictions of ARIMA model
plt.plot(test_dataset)
plt.plot(predictions, color = 'red')














