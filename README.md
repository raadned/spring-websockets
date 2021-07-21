# spring-websocket-example
Sample Spring Boot Service using Websockets

## Dependencies required to run the project

* Docker
* MongoDB

## Dependencies setup

* Download the latest Mongo image

`docker pull mongo`

* Create folder locally to contain mongo data

`mkdir -p /mongo/data`

* Start MongoDB

`docker run -it -v /mongo/data:/data/db -p 27017:27017 --name mongodb -d mongo`

## Running the project using Intellij

1. Import the project in IntelliJ
2. Start the project by running Application.java 