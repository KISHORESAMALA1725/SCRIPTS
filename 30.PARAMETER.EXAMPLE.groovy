pipeline {
    agent any
    parameters {
        string (name: 'USERNAME', defaultValue: 'KISHORE', description: 'ENTER YOUR NAME')
        choice (name: 'BRANCH_NAME', choices: ['main','hotfix','feature'], description: 'ENTER CHOICE')
    }
    stages {
        stage ('MAIN-STAGE') {
            when {
                expression {
                    params.BRANCH_NAME == 'main'
                }
                steps {
                    echo "MAIN BRANCH EXECUTED"
                }
            }
        }
        stage ('HOTFIX-STAGE') {
            when {
                expression {
                    params.BRANCH_NAME == 'hotfix'
                }
                steps {
                    echo "HOTFIX BRANCH EXECUTED"
                }
            }
        }
    }
}