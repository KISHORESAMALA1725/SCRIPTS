//THIS CODE IS WORKING //
pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                echo "Building Node Application"
            }
        }
        stage ('Deploy to prod') {
            options {
                timeout(time: 30, unit: "SECONDS")
            }
            input {
                message "should i continue ??"
                ok "Approved"
                submitter "maha"
                submitterParameter "whoapproved"
                parameters {
                    string (
                        name: 'USR_NAME',
                        defaultValue: 'siva',
                        description: 'Please enter your name'
                    )
                    string (
                        name: 'CHG_TKT',
                        defaultValue: 'CHG1234',
                        description: 'Please enter your name'
                    )
                    booleanParam(
                        name: 'SRE_APPROVED',
                        defaultValue: true,
                        description: 'SRE approval taken for this release ???'
                    )
                    choice(
                        choices: 'Regular\nHotfix',
                        description: "what sort of release is this, Regular or HOT-FIX",
                        name: 'Release'
                    )
                    text(
                        name: 'Notes',
                        defaultValue: "Enter Release Notes",
                        description:  "Please enter description"
                    )
                    credentials(
                        name: 'mycredentials',
                        description: "myCredentials",
                        required: true
                    )
                }
            }
            steps {
                echo "Deploying to production"
                echo "Welcome ${USR_NAME}"
                echo "Status of approval ${SRE_APPROVED}"
                echo "this is a ${Release}-Release"
                echo "Approved by this Person: ${whoapproved}"
            }
        }
    }
}