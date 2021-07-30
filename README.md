# About
Sample Spring Boot Service using Websockets. The service exposes an API endpoint to persist book related data which then streams the payload using websockets.

## Dependencies required to run the project

* Docker
* MongoDB

## Dependencies setup

### Pull latest MongoDB image and run it

* Download the latest Mongo image

`docker pull mongo`

* Create folder locally to contain mongo data

`mkdir -p /mongo/data`

* Start MongoDB

`docker run -it -v /mongo/data:/data/db -p 27017:27017 --name mongodb -d mongo`

### Use docker compose

* Ensure you are in the root folder

`docker-compose up -d`

If you want to start the application using docker-compose ensure the image is build
with the following application.properties configuration:

`spring.data.mongodb.host=mongodb`
`spring.data.mongodb.port=27017`

## Running the project 

### Using Intellij

* Import the project in IntelliJ
* Start the project by running Application.java 

### Using Maven

In the root folder run : 
* `mvn clean install`

* `mvn spring-boot:run`
