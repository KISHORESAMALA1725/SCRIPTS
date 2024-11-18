pipeline {
    agent any
    stages {

        stage ("this is another retry example") {
            steps {
                retry (3) {
                    echo "welcome to jenkins"
                }
                echo "other retry block"
            }
        }
    }
}