pipeline {
    agent any
    stages {
        stage ("this is stage 1"){
            steps {
                echo " ***** this is script example ***** "
            }
        }
        stage  ("this is stage 2 with script example") {
            steps {
                script {
                    def courses = 'GCP-CLOUD'
                    if (courses == 'GCP-CLOUD')
                    println ("Welcome to ${courses}")
                    else
                    println ("please enroll to ${courses} - course")
                }
            }
        }
    }
}