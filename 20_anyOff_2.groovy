pipeline {
    agent any 
    environment {
        DEPLOY_TO = 'production'
    }
    stages {
        stage ('this is allOff Example') { 
            when {
                anyOf{
                    expression{
                        branch_name ==~ /(main|staging)/
                    } 
                }
                environment name: 'DEPLOY_TO', value: 'production'
            }
            steps {
                echo "this allOf stage is SUCCESS"
            }

        }
        stage ('allOf Failed stage') {
            steps {
                echo "'***** THIS STAGE IS EXECUTED WHEN allOf CONDITIION IS FAILED *****'"
            }
        }
    }
}