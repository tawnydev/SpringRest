node {
    stage('Pre-build') {
        git 'https://github.com/tawnydev/SpringRest.git'
    }
    stage('Test') {
        if (isUnix()) {
            sh './gradlew -i test'
        } else {
            bat(/gradlew -i test/)
        }
    }
    stage('Build') {
        if (isUnix()) {
            sh './gradlew clean build'
        } else {
            bat(/gradlew clean build/)
        }
    }
    stage ('Quality Analysis'){
        withSonarQubeEnv() { // Will pick the global server connection you have configured
            if (isUnix()) {
                sh './gradlew sonarqube'
            } else {
                bat (/gradlew sonarqube/)
            }
        }
    }
    stage ('Notification') {
        /*
        Please note this is a direct conversion of post-build actions.
        It may not necessarily work/behave in the same way as post-build actions work.
        A logic review is suggested.
        */
        // Mailer notification
        step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'kevin.matrix@hotmail.fr', sendToIndividuals: false])
    }
}
