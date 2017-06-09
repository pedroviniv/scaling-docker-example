# scaling-docker-example

This project demonstrates a scale out of a java web application
using Docker, Tomcat as the java application server and Nginx to handle the incoming requests and redirect to one of the java webapp replic;

The project is divided in three modules;
- **dac-exemplo-shared** that will contain all the shared classes between the modules below;
- **dac-exemplo-jse** that is a jse application that communicates to the database to list the persisted clients;
- **dac-exemplo-web** that is a web application that communicates to the database to list the persisted clients; 

## Requirements

- JDK8
- Maven
- Docker
- Docker-Compose

Make sure you have the softwares above installed on your machine.

## Deploying

- First of all, you need to create the network `cliente-default` defined in the docker-compose.yaml file. Do that by running the command `sudo docker network create cliente-default` 
- You need to compile the source code and install these applications in your
maven local repository. You can do this by running the command: `mvn install`
- Now you have to create all the images defined in the dockerfiles. You can do this by running the command: `sudo docker-compose build`
- Now let's scale our container based on the web application image. Let's create 5 replics. To do that run the command: `sudo docker-compose scale web=5`
- Finally, run the command `sudo docker-compose up -d` to start our containers;
