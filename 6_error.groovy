pipeline {
    agent any
    stages {
        stage ("this is error example") {
            steps {
                echo "this is error example, job will fail now"
                error " this parameter will fail the code"
            }
        }
    }
}