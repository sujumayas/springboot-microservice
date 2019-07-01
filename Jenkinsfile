pipeline {
    agent any
    // global env variables
    stages {
        stage('Build') {
            steps{
                // Run the maven build
                script {
                    def mvnHome = tool 'Maven 3.5.2'
                    sh "'${mvnHome}/bin/mvn' clean spring-boot:run"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    def mvnHome = tool 'Maven 3.5.2'
                    sh "'${mvnHome}/bin/mvn' test"
                }
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