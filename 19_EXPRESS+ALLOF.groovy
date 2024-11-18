pipeline {
    agent any
    stages {
        stage ("this is stage 1"){
            environment {
                deployto = 'production'
            }
            when {
                expression {
                    branch_name ==~ /(main|stage)/
                }
                anyOf {
                    environment name: 'deployto', value: 'production'
                }
            }
            steps {
                echo " this stage is good"
            }
        }
        stage (" this normal stage") {
            steps { 
            echo '****** please check once again ******'
            }

        }
    }
}