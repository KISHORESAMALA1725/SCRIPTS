pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages {
        stage ("this is anyOf stage") {
            when {
                anyOf {
                    branch 'production'
                    environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps {
                echo " this anyOf condition is working well"
            }
        }
        stage ("this is default stage"){
            steps {
                echo " ***** NORMAL STAGE *****"
            }
        }
    }
}

