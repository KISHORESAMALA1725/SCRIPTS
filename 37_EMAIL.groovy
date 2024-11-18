pipeline {
    agent any
    stages {
        stage ('build') {
            steps {
                echo "***** Testing POST Mail Job"
            }
        }
    }
    post {
        success{
            script{
                  def subject = "Success: Job is ${env.JOB_NAME} -- Build # is [${env.BUILD_NUMBER}] status: ${currentBuild.currentResult}"
                  def body =  "Build Number: ${env.BUILD_NUMBER} \n\n" +
                           "status: ${currentBuild.currentResult} \n\n" +
                           "Job URL: ${env.BUILD_URL}"
            sendEmailNotification('kishorecloud.1725@gmail.com', subject, body)               
            }            
        }
        
        failure{
            script{
                  def subject = "Success: Job is ${env.JOB_NAME} -- Build # is [${env.BUILD_NUMBER}] status: ${currentBuild.currentResult}"
                  def body =  "Build Number: ${env.BUILD_NUMBER} \n\n" +
                           "status: ${currentBuild.currentResult} \n\n" +
                           "Job URL: ${env.BUILD_URL}"
            sendEmailNotification('kishorecloud.1725@gmail.com', subject, body)               
            }            
        }
    }
}

def sendEmailNotification(String recipient, String subject, String body) {
    mail (
        to: recipient,
        subject: subject,
        body: body
    )
}