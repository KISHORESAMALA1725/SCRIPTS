pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages {
        stage ("when not condition") {
            when {
                not{
                environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps {
                echo " this not condition is good"
            }
            
        }
    }
}