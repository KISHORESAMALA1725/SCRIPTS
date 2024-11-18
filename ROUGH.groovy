pipeline {
    agent any
    stages {
        stage ('BRANCH_EXECUTION') {
            when {
                expression {
                    branch_name ==~ /(feature|hotfix|kishore)/
                }
            }
            steps {
                echo "Required feature branch got executed"
            }
        }
    }
}