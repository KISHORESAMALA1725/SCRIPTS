pipeline {
    agent any
    environment {
        GITHUB_CREDS = credentials('KISHORE-CREDS')
    }
    stages {
        stage ("This is for credentials") {
            steps {
                echo "GitHub credentials are ${GITHUB_CREDS}"
                echo "username is ${GITHUB_CREDS_USR}"
                echo "password is ${GITHUB_CREDS_PSW}"
            }
        }
    }
}