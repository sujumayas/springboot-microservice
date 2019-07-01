pipeline {
    agent any
    // global env variables
    stages {
        stage('Build') {
            // Run the maven build
            script {
                // Get the Maven tool.
                // ** NOTE: This 'M3' Maven tool must be configured
                // **       in the global configuration.
                echo 'Pulling...' + env.BRANCH_NAME
                def mvnHome = tool 'Maven 3.5.2'
                if (isUnix()) {
                    def targetVersion = getDevVersion()
                    print 'target build version...'
                    print targetVersion
                    sh "'${mvnHome}/bin/mvn' -Dintegration-tests.skip=true -Dbuild.number=${targetVersion} clean package"
                    def pom = readMavenPom file: 'pom.xml'
                    // get the current development version
                    developmentArtifactVersion = "${pom.version}-${targetVersion}"
                    print pom.version
                    // execute the unit testing and collect the reports
                    junit '**//*target/surefire-reports/TEST-*.xml'
                    archive 'target*//*.jar'
                } else {
                    bat(/"${mvnHome}\bin\mvn" -Dintegration-tests.skip=true clean package/)
                    def pom = readMavenPom file: 'pom.xml'
                    print pom.version
                    junit '**//*target/surefire-reports/TEST-*.xml'
                    archive 'target*//*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    def mvnHome = tool 'Maven 3.5.2'
                    if (isUnix()) {
                        // just to trigger the integration test without unit testing
                        sh "'${mvnHome}/bin/mvn'  verify -Dunit-tests.skip=true"
                    } else {
                        bat(/"${mvnHome}\bin\mvn" verify -Dunit-tests.skip=true/)
                    }
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