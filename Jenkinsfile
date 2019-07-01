pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh '${Maven3}/bin/mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                // This will test the applicatin with maven test.
                sh '${Maven3}/bin/mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build & Deploy to Docker Intance'){
            steps{
                // create the build 
                sh 'docker build -t springboot-deploy .'
                sh 'docker login'
                sh 'docker tag springboot-deploy sujumayas/springboot-deploy:v.0.0.1'
                sh 'docker push sujumayas/springboot-deploy:v.0.0.1'
                sh 'docker run -d -p 4000:80 springboot-deploy'
            }
        }
    }
}