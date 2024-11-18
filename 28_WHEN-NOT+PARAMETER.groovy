pipeline {
    agent any
    parameters {
        string (name: 'USERNAME', defaultValue: 'KISHORE', description: 'Please Enter Your Name')
        choice (name: 'CHOICES', choices: ['yes','no'], description: 'Please enter your choice')
    }
    stages {
        stage('This is first stage') {
            steps {
                echo "This is First stage"
            }
        }
        stage ('This is choice stage') {
            when {
                expression {
                    params.CHOICES == 'yes'
                }
            }
            steps {
                echo "DEPLOYED TO PROD"
            }
        }
        stage ('This is NO stage') {
            when {
                expression {
                    params.CHOICES == 'no'
                }
            }
            steps {
                echo "DEPLOYED to NON-PROD"
            }
        }
    }
}