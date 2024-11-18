pipeline {
    agent any
    environment {
        name = 'siva'
        course = 'k8s'
        location = 'hyderabad'
    }
    stages {
        stage ("this is stage-1") {
            steps {
                echo "Welcome Mr.${name}"
                echo "thanks for your ${course}"
                echo "you are from ${location}"
            }
        }
        
    }
}