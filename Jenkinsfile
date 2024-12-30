pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage("SCM Checkout") {
            steps {
                git branch: 'master', url: 'https://github.com/Ajaygupta1993/jenkins-ci-cd-demo.git'
                script {
                    echo "SCM Checkout completed successfully."
                }
            }
        }
        stage("Build Process") {
            steps {
                script {
                    bat 'mvn clean install'
                }
            }
        }
        stage("Deploye to container"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090/')], contextPath: 'jenkinsCiCd', war: '**/*.war'
            }
        }
    }
    post{
        always{
            emailext attachLog: true, body: '''<html>
    <body>
        <p>Build Status: ${BUILD_STATUS}</p>
        <p>Build Number: ${BUILD_NUMBER}</p>
        <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
    </body>''', mimeType: 'text/html', replyTo: 'kumarajaygupta04@gmail.com', subject: 'pipeline status : ${BUILD_NUMBER}', to: 'kumarajaygupta04@gmail.com'
        }
    }
}
