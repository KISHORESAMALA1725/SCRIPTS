pipeline {
    agent any
    parameters {
        string (name: 'USERNAME', defaultValue: 'KISHORE', description: 'Enter your name')
        choice (name: 'DeployToPROD', choices: ['yes','no'], description: 'choose your option')  
    }
    stages {
        stage ('this is build'){
            steps{
                echo "this is build stage"
            }
        }
        stage ('this to deploy in prod-stage') {
            when {
                expression{
                    params.DeployToPROD == 'yes'
                }
            }
            steps {
                echo "Deployment is done on PROD-ENV"
            }
        }
    }
}