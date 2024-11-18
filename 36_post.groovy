pipeline {
    agent {
        label 'java-slave'
    }
    stages {
        stage ('this is build: maven stage') 
        { steps 
            { 
            echo " ********* ********"
            // error: ORA-1555
            }
        }
    }
    post{
        success {
            echo "this stage will execute then job is success"
        }
        failure {
            echo "this stage will execute then job is failure"
        }
        always {
            echo "this stage will execute in any condition"
        }        
    }
}