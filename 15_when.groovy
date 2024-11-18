pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages {
        stage ("this is when condition -- stage") {
                when {
                    environment name: 'DEPLOY_TO', value: 'production'
                }
                steps {
                    echo "the above condition is good"
                }
            }
        }
}