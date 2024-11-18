pipeline {
    agent any 
    stages {
        stage ('allOff stage') {
            environment {
                DEPLOY_TO = 'production'
            }
            when {
                allOf {
                    expression {
                        branch_name ==~ /(main|staging)/
                }
                environment name: 'DEPLOY_TO', value: 'production'
            }
            }
            steps {
                echo " ***** allOf condition is successful *****"
            }
        }
        stage (' FAILED allOf') {
            steps {
                echo "YOU ARE SEEING THIS MESSAGE BECAUSE allOf IS FAILED"
            }
        }
    }
}