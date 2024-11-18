pipeline {
    agent any
    parameters {
        string (name: 'USR_NAME', defaultValue: 'SIVA', description: 'Please enter your name')
        string (name: 'CHG_TICKET', defaultValue: 'CHG12345', description: 'Please ENTER CHG# number')
        booleanParam(name: 'SRE_APPROVED', defaultValue: true, description: 'Please select True or False')
        choice (name: 'COURSE', choices: ['Gcp', 'DevOps', 'K8S'], description: 'Please enter description')
        text (name: 'Enter your Text', defaultValue: 'Please input your TEXT', description: 'please input some text her')
        credentials(name: 'DOCKER_CREDS', required: true, description: 'DOCKER_CREDS')
    }
            stages{
            stage ('Welcome to PARAMETER EXAMPLE') {
                steps {
                    echo "Deploying to PRODUCTION"
                    echo "Welcome Mr.${params.USR_NAME}"
                    echo "status of approval ${params.SRE_APPROVED}"
                    echo "this is ${params.CHOICE}"
                    echo "Approved by this person-${}"
              }
          }
    }
}