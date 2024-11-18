pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages {
        stage ('this is stage - 1') {
            when {
                anyOf{
                    expression {
                        BRANCH_NAME ==~ /(production|staging)/
                    }
                    environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps {
                echo '***** THIS anyOf STAGE IS GOOD *****'
            }
        }
        stage ('TAG STAGE') {
            when {
                tag pattern: "v\\d{1,2}.\\d{1,2}.\\d{1,2}", comparator: "REGEXP"
            }
            steps {
                echo 'deploy to K8S cluster'
            }
        }
    }
}