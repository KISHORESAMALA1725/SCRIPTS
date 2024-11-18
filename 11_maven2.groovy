pipeline {
    agent any
    stages {
        stage (" ***** MANUAL MAVEN INFO ***** ") {
            tools {
                maven "Maven-3.8.8"
                jdk "JDK-17"
            }
            steps {
            echo " MAVEN INFO IS PRINTED HERE"
            sh 'mvn -version'
            }
        }
        stage ("Maven_AutoInstaller") {
            tools {
                maven "Maven_AutoInstaller"
            }
            steps {
                echo " **** this is maven auto installer info *****"
                sh 'mvn --version'
            }
         }
    }
}