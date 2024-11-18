pipeline {
    agent {
        label 'java-slave'
    }
    stages {
        stage('input stage') {
            input {
                message "please select any option"
                ok "approved"
                submitter "mahesh123"
            }
            steps {
                echo "this is success"
            }
        }
    }
}