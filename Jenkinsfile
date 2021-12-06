node {
    def mvnHome
    stage('Pre-build') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/tawnydev/SpringRest.git'
        // Get the gradle tool.
        gradleHome = tool 'Gradle 4.7'
    }
    stage('Build') {
        // Run the gradle build
        withEnv(["GRADLE_HOME=$gradleHome"]) {
            if (isUnix()) {
                sh '"gradlew build'
            } else {
                bat(/gradlew build/)
            }
        }
    }
}
