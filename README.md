# Clients Microservice Spring Boot Sample Application

Just a simple Spring Boot Sample API using Swagger, Maven, and Jenkins & Docker for CI/CD pipelines. 

## Getting Started

Spring Boot Applications are too simple to run. Just Install JAVA and Maven, and use the best IDE you want to use. The application comes with a integrated Tomcat server so we do not have to worry about that. 

### Prerequisites

- JDK 1.8 or later
- (Gradle 4+ or) Maven 3.2+ (Althou you could run it with gradle, this project is not configured for that... sorry)

### Installing

If you have Java and Maven installed... 

Just: 

```bash
$ mvnw spring-boot:run
```

That will run the server on the http://localhost:8080/ (*you can change the port in the `/src/main/resources/application.properties` Groovy file)

## Running the tests

**FALTA**
Explain how to run the automated tests for this system
**FALTA**

### Functional Test: 

You can review all api routes in swagger, but here are the main ones: 

- POST /api/v1/clients/create 
- GET /api/v1/clients/kpi 
- GET /api/v1/clients/list

## Deployment 

**FALTA**
Add additional notes about how to deploy this on a live system
`docker run -d -v jenkins_home:/var/jenkins_home -p 8080:8080 jenkins/jenkins:lts`
**FALTA**

## Built With

* [Spring](https://spring.io) - Spring & Spring Boot
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger](https://swagger.io/) - Oh the docs!
* [Jenkins](https://jenkins.io/) - Pipelines
* [Docker](https://docker.com/) - Containeeeeers <3

## Contributing

No contributing allowed for this project. 

## Authors

* **Esen Espinosa** - and his new love for Spring Boot Applications - 

## Acknowledgments

- Just in case we want to acknowledge something someday. 

## TODO BackEnd SpringBoot: 

- *[...doing]* Microservicio desarrollado en JAVA Spring boot​ 
    - API Rest documentada en Swagger​
    - Deployado en AWS o algún CLOUD + código subido en GITHUB​
    
    - **[DONE]** Endpoint de Entrada POST /api/v1/clients/create 
        - **[DONE]** Name
        - **[DONE]** LastName
        - **[DONE]** Age   *Should be birthDate dependant, we are gonna asume users are honest in their math*
        - **[DONE]** BirthDate

    - **[DONE]** Endpoint de salida GET /api/v1/clients/kpi 
        - **[DONE]** Promedio edad entre todos los clientes​
        - *[...doing]* Desviación estándar entre las edades de todos los clientes​ 
        
    - **[DONE]** Endpoint de salida GET /api/v1/clients/list
        - **[DONE]** Lista de personas con todos los datos + fecha probable de muerte de cada una​ 


## TODO DevOPS Docker&Jenkins:

- *[DONE]* Desplegar un contenedor Docker de Jenkins en una Instancia EC2 de AWS​
    
    - Crear una Pipeline de CI/CD para el microservicio del paso 1 en Jenkins​
        - Job de Build con Maven y codigo en Github​
        - Job de Unit Test con Maven​
        - Job de Deploy en una instancia EC2 con Docker​
        - Job de Functional Test con Jmeter o Postman​

    - Enviar links, usuarios y password por correo para poder probar:​
        - La aplicación y sus endpoints​
        - Jenkins y el pipeline


------
# Docker Get Started 
## Basic Docker documentation for later use... 

### Docker Get Started - Part 1 - Overview

Just enjoy learning from the documentation. Tutorials are the worst thing humanity could have ever invented. 

### Docker Get Started - Part 2 - Containers:

```bash
$ docker build -t friendlyhello .  # Create image using this directory's Dockerfile
$ docker run -p 4000:80 friendlyhello  # Run "friendlyhello" mapping port 4000 to 80
$ docker run -d -p 4000:80 friendlyhello         # Same thing, but in detached mode
$ docker container ls                                # List all running containers
$ docker container ls -a             # List all containers, even those not running
$ docker container stop <hash>           # Gracefully stop the specified container
$ docker container kill <hash>         # Force shutdown of the specified container
$ docker container rm <hash>        # Remove specified container from this machine
$ docker container rm $(docker container ls -a -q)         # Remove all containers
$ docker image ls -a                             # List all images on this machine
$ docker image rm <image id>            # Remove specified image from this machine
$ docker image rm $(docker image ls -a -q)   # Remove all images from this machine
$ docker login             # Log in this CLI session using your Docker credentials
$ docker tag <image> username/repository:tag  # Tag <image> for upload to registry
$ docker push username/repository:tag            # Upload tagged image to registry
$ docker run username/repository:tag                   # Run image from a registry
```

### Docker Get Started - Part 3 - Running Services: 

```bash
docker stack ls                                            # List stacks or apps
docker stack deploy -c <composefile> <appname>  # Run the specified Compose file
docker service ls                 # List running services associated with an app
docker service ps <service>                  # List tasks associated with an app
docker inspect <task or container>                   # Inspect task or container
docker container ls -q                                      # List container IDs
docker stack rm <appname>                             # Tear down an application
docker swarm leave --force      # Take down a single node swarm from the manager
```

### Docker Get Started - Part 4 - Swarms:

```bash
docker-machine create --driver virtualbox myvm1 # Create a VM (Mac, Win7, Linux)
docker-machine create -d hyperv --hyperv-virtual-switch "myswitch" myvm1 # Win10
docker-machine env myvm1                # View basic information about your node
docker-machine ssh myvm1 "docker node ls"         # List the nodes in your swarm
docker-machine ssh myvm1 "docker node inspect <node ID>"        # Inspect a node
docker-machine ssh myvm1 "docker swarm join-token -q worker"   # View join token
docker-machine ssh myvm1   # Open an SSH session with the VM; type "exit" to end
docker node ls                # View nodes in swarm (while logged on to manager)
docker-machine ssh myvm2 "docker swarm leave"  # Make the worker leave the swarm
docker-machine ssh myvm1 "docker swarm leave -f" # Make master leave, kill swarm
docker-machine ls # list VMs, asterisk shows which VM this shell is talking to
docker-machine start myvm1            # Start a VM that is currently not running
docker-machine env myvm1      # show environment variables and command for myvm1
eval $(docker-machine env myvm1)         # Mac command to connect shell to myvm1
docker stack deploy -c <file> <app>  # Deploy an app; command shell must be set to talk to manager (myvm1), uses local Compose file
docker-machine scp docker-compose.yml myvm1:~ # Copy file to node's home dir (only required if you use ssh to connect to manager and deploy the app)
docker-machine ssh myvm1 "docker stack deploy -c <file> <app>"   # Deploy an app using ssh (you must have first copied the Compose file to myvm1)
eval $(docker-machine env -u)     # Disconnect shell from VMs, use native docker
docker-machine stop $(docker-machine ls -q)               # Stop all running VMs
docker-machine rm $(docker-machine ls -q) # Delete all VMs and their disk images
```

### About running Jenkins inside Docker "GG WP F life, F"

    1. Almost 3 days trying to fix "jenkings not loading even tho its correctly installed and the logs show no error".... And the problem was: "port 8080 is not open in ec2 instance security groups".  

        This was not the correct way, but interesting anyway. Apparently there are some issues in the current LTS version of Jenkins where you have some ports blocked by the https port not resolving... 
        - https://github.com/jenkinsci/docker/issues/702
        - https://issues.jenkins-ci.org/browse/JENKINS-33412?focusedCommentId=347111&page=com.atlassian.jira.plugin.system.issuetabpanels%3Acomment-tabpanel#comment-347111

    2. After that. Jenkins docker instalation had redirect to login automaticly set.. So I could not reset the admin. I just got inside the Docker with exec and searched all the jenkins_home for clues... until I found a weird /secret/initial_admin_password file with a password in plain text inside.... 

        This saved me: 
        - ssh into a container saved my life: http://phase2.github.io/devtools/common-tasks/ssh-into-a-container/
        
        And then I did a quick search... and its commonly known: 
        - https://stackoverflow.com/questions/40570173/installing-jenkins-the-first-time-and-do-not-know-the-default-user-name

