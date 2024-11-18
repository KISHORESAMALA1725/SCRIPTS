pipeline {
    agent any
    environment {
        DEPLOY_MAIN = 'main'
        DEPLOY_FEATURE = 'feature'
        DEPLOY_HOTFIX = 'hotfix'
    }
    stages {
        stage ('THIS IS MAIN STAGE') {
            when {
                environment name: 'DEPLOY_NAME', value: 'main'
            }
            steps {
                echo "MAIN STAGE CODE DEPLOYED"
            }
        }
        stage ('THIS IS HOT-FIX STAGE') {
            when {
                environment name: 'DEPLOY_HOTFIX', value: 'hotfix'
            }
            steps {
                echo "HOTIX CODE EXECUTED"
            }
        }
    }
}