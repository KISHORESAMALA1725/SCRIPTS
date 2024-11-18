pipeline {
    agent {
        label 'java-agent'
    }
    stages {
        stage ('This stage is executing in java-agent'){
            steps {
                echo " this is coming from java-agent "
            }
        }
        stage ("this stage is executing in node-agent"){
            agent {
                label node-agent
            }
            steps {
                echo " this is comming from node-agent "                
            }
        }
    }
}