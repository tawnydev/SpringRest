node {
    def gradleHome
    stage('Pre-build') {
        git 'https://github.com/tawnydev/SpringRest.git'
        gradleHome = tool 'Gradle 4.7'
    }
    stage('Test') {
            withEnv(["GRADLE_HOME=$gradleHome"]) {
                if (isUnix()) {
                    sh '"gradlew -i test'
                } else {
                    bat(/gradlew -i test/)
                }
            }
        }
    stage('Build') {
        withEnv(["GRADLE_HOME=$gradleHome"]) {
            if (isUnix()) {
                sh '"gradlew clean build'
            } else {
                bat(/gradlew clean build/)
            }
        }
    }
}
