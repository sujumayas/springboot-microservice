pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                // This will test the applicatin with maven test.
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build & Deploy to Docker Intance'){
            steps{
                def image_name = 'springboot-deploy'
                def version = '0.0.1' //this should be automatic on later builds.
                def username = 'sujumayas'
                // create the build 
                sh 'docker build -t ${image_name} .'
                sh 'docker login'             
                sh 'docker tag ${image_name} ${username}/${image_name}:v.${version}'
                sh 'docker push ${username}/${image_name}:v.${version}'
                sh 'docker run -d -p 4000:80 ${image_name}'         
            }
        }
    }
}
