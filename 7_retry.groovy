pipeline {
    agent any
    stages{
        stage ("this is re-try example"){
            steps {
                retry 3{
                echo " ***** retry example ***** "
                error ('this error parameter will fail the job')
                }
            }
        }
    }
}