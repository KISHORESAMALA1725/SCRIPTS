pipeline {
    agent any
    environment {
        name = 'siva'
        course = 'kubernetes'
        location = 'hyderabad'
    }
    stages {
        stage ("this is env stage") {
            steps {
                echo " Hello ${name}"
                echo " Thanks for teaching ${course}"
                echo " welcome to ${location}"
            }
        }
        stage ("this is second stage") {
            environment {
                name = 'kishore'
                course = 'DevOps'
            }
            steps {
                echo " Hello My name is ${name}"
                echo " Im interested in ${course}"
            }
        }
    }
}