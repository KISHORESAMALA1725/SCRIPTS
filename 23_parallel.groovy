pipeline {
    agent any
    stages {
        stage ('STAGE-1 OF PARALLEL') {
            steps {
                echo "PARALLEL EXAMPLE"
            }
        }
        stage ('parallel-stage') {
            parallel {
                stage ('sonar') {
                    steps {
                        echo " this is sonar stage"
                    }
                }
                stage ('Fortify') {
                    steps {
                        echo "this is fortify stage"
                    }
                }
                stage ('trivy') {
                    steps {
                        echo "this is trivy stage"
                    }
                }
            }
        }
        stage ('deploy') {
            steps {
                echo 'this is deploy stage'
            }
        }
    }
}