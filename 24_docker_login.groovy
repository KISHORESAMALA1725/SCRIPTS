pipeline {
    agent {
        label 'docker-slave'
    }
    environment {
    MY_CREDS = credentials('DOCKER_CREDS')
    }
    stages {
        stage ('This is docker') {
            steps {
               sh "whoami"
               echo "********** current images in repo **********"
               sh "docker images"
               echo "********** pulling images **********"
               sh "docker rmi alpine:latest"
               sh "docker pull alpine"
               echo "********** Renaming IMAGE **********"
               sh "docker tag alpine:latest kishoresamala84/alpine:1725"
               echo "********** logging into docker hub **********"
               sh "docker login -u ${MY_CREDS_USR} -p ${MY_CREDS_PSW}"
               echo "********** push image to docker hub **********"
               sh "docker push kishoresamala84/alpine:1725"
            }
        }
    }
}