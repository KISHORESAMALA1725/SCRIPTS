pipeline {
    agent none
    stages {
        stage ("this is none example") {
            steps {
                echo " this stage is getting executed in NONE agent "
            }
        }
    }
}