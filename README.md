# Moving-To-Brooklyn

This is a project for my Processing  Big Data for Analytics Applications class at New York University. My teammates and I used MapReduce to clean and profile our datasets and then we used Hive to join the datasets to create analytics. 

We used a total of 4 datasets - poverty, automobile crashes, 311 calls, and energy usage for this project and we were able to clean and profile them using MapReduce and Hive. We primarily focused on the borough of Brooklyn to see which neighborhoods were the most ideal to live in by making visualizations and excel tools after cleaning and profiling. We found that East Flatbush and Little Poland were the best neighborhoods to live in as they had the least amount of 311 complaints, low numbers of crashes, and high energy scores.

The data ingest folder contains the steps we took to ingest the file to HDFS after downloading the datasets from online sources.

The ETL code folder contains the MapReduce programs which we all wrote independently to clean our large data sets which had a lot of extra information that we didn’t need

The profiling code folder contains the commands we used for the Hive tables to store the data correctly. 

The test code folder contained the kinds of testing and trialing we did to understand how we can best organize our data by zip code. We experimented in various ways to get the most relevant information from our data. 

The screenshots folder contains the screenshots of the steps we took to create our cleaned and organized datasets.
