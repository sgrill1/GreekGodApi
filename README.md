# GreekGodApi

## Introduction

This repo is designed to demonstrate how to integrate a RESTful API with a MongoDB. The initial data set has been webscraped from Wikipedia
using the code developed in https://github.com/katkaypettitt/greek-gods. The generated csv file has been injected into a private MongoDB.
You will need to create a MongoDB instance for yourself to connect to (see below for more details).

## MongoDB setup

For this project I created a managed MongoDB using MongoDB Atlas. Following these steps:

1. Sign up for an account on the MongoDB Atlas website (https://www.mongodb.com/cloud/atlas).
2. Click the "Build a New Cluster" button to start the cluster creation process.
3. Choose a cloud provider (e.g., AWS, GCP, Azure) and a region for your cluster.
4. Select a cluster tier. MongoDB Atlas offers a range of tiers to meet different performance and cost requirements.
5. Configure additional options such as backup, monitoring, and security settings.
6. Click the "Create Cluster" button to create your cluster. This may take a few minutes.
7. Once the cluster has been created, you can connect to it using the MongoDB client. Click the "Connect" button in the Atlas UI, and then follow the prompts to connect using your preferred method (e.g., MongoDB shell, driver, or application).
8. You can secure the connection to your DB using your preferred authentication method

### Injecting data to Mongo

There are many ways to do this. I cloned the repo cited in the introduction and created an `inject_data.py` file that did the following:

```python
from pymongo import MongoClient
import csv

client = MongoClient("<mongo.db.url>/?retryWrites=true&w=majority")
db = client.test

db = client['greek_gods']
gods_collection = db['bios']


with open("greek_gods.csv","r") as file:
    reader = csv.DictReader(file)

    for row in reader:
        gods_collection.insert_one(row)

client.close()
```

Remembering to insert your own MongoDB url!

## Configuration
In for Spring to connect to your MongoDB you will need to create an application.properties file.
This should be created at `src/main/resources/application.properties` and should contain the following :

```properties
server.port=5000
spring.data.mongodb.uri=<mongo.db.url>/greek_gods
spring.data.mongodb.database=greek_gods
```

