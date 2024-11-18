pipeline {
    agent any
    tools {
        maven "Maven_AutoInstaller"
    }
    stages {
        stage ("This is MAVEN stage") {
            steps {
                echo " **** BELOW IS MAVEN VERSION **** "
                sh 'mvn --version'
            }
        }
        stage ("this is manual version of mavan") {
            tools {
                jdk "JDK-17"
            }
            steps {
                echo " this is mvn manual version details "
                sh 'mvn --version'
            }
        }
    }
}