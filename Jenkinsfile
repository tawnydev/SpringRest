pipeline {
    agent any
    stages {
        stage('Pre-build') {
            steps{
                git 'https://github.com/tawnydev/SpringRest.git'
            }
        }
        stage('Test') {
            steps{
                script{
                    if (isUnix()) {
                        sh './gradlew -i test'
                    } else {
                        bat(/gradlew -i test/)
                    }
                }
            }
        }
        stage('Build') {
            steps{
                script{
                    if (isUnix()) {
                        sh './gradlew clean build'
                    } else {
                        bat(/gradlew clean build/)
                    }
                }
            }
        }
        stage ('Quality Analysis'){
            steps{
                withSonarQubeEnv('MonSonarQube') { 
                    script{
                        if (isUnix()) {
                           sh './gradlew sonarqube'
                        } else {
                            bat (/gradlew sonarqube/)
                        }
                    }
                }
            }
        }
        stage ('Notification') {
            steps{
                step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: emailextrecipients([culprits(), requestor()])])
            }
        }
        stage('Docker Deployment') {
            agent {
                label 'agent1'
            }
            steps {
                script{
                    checkout scm
                    def customImage = docker.build("9485632/springrestpgapp:${env.BUILD_ID}", "-f Dockerfile ./dockerfiles") 
                }
            }
        }
    }
}
