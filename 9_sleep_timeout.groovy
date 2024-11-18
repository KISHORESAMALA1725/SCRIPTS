pipeline {
    agent any
    stages {
        stage ("this is timeout example") {
            steps {
                timeout  (time: 5, unit: 'SECONDS') {
                echo "***** TIMEOUT EXAMPLE *****"
                sleep 30
                }
            }
        }
    }
}