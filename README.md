# Client List Spring Boot Application



## TODO BackEnd SpringBoot: 

- *[...doing]* Microservicio desarrollado en JAVA Spring boot​ 
    - API Rest documentada en Swagger​
    - Deployado en AWS o algún CLOUD + código subido en GITHUB​
    
    - **[DONE]** Endpoint de Entrada POST /api/clients/create 
        - **[DONE]** Name
        - **[DONE]** LastName
        - **[DONE]** Age   *Should be birthDate dependant, we are gonna asume users are honest in their math*
        - **[DONE]** BirthDate

    - **[DONE]** Endpoint de salida GET /api/clients/kpi 
        - **[DONE]** Promedio edad entre todos los clientes​
        - *[...doing]* Desviación estándar entre las edades de todos los clientes​ 
        
    - **[DONE]** Endpoint de salida GET /api/clients/list
        - **[DONE]** Lista de personas con todos los datos + fecha probable de muerte de cada una​ 


## TODO DevOPS Docker&Jenkins:

- *[...doing]* Desplegar un contenedor Docker de Jenkins en una Instancia EC2 de AWS​
    
    - Crear una Pipeline de CI/CD para el microservicio del paso 1 en Jenkins​
        - Job de Build con Maven y codigo en Github​
        - Job de Unit Test con Maven​
        - Job de Deploy en una instancia EC2 con Docker​
        - Job de Functional Test con Jmeter o Postman​

    - Enviar links, usuarios y password por correo para poder probar:​
        - La aplicación y sus endpoints​
        - Jenkins y el pipeline



