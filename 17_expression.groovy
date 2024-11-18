pipeline {
    agent any
    stages {
        stage ('this is expression stage') {
            when {
                expression {
                    branch_name ==~ /(feature|hotfix)/
                }
            }
            steps {
                echo "this feature/hotfix branch is executed"
            }
        }
    }
}