############################################################
# Dockerfile to build spring boot app container images
# Based on Ubuntu
# MAINTAINER Meir Wahnon
############################################################

FROM ubuntu:latest

RUN apt-get update

RUN apt-get install default-jre -y

RUN apt-get install default-jdk -y

RUN apt-get install maven -y

ADD pom.xml /app/

ADD src/ /app/src/

WORKDIR /app/

RUN mvn package

EXPOSE  8081

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/clientsmicroservice-0.0.1-SNAPSHOT.jar"]