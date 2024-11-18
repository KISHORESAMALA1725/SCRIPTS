pipeline {
    agent any
    stages {
        stage ('this is FEATURE stage') {
            steps {
                echo "CODE EXECUTED IN FEATURE BRANCH"
            }
        }
    }
}