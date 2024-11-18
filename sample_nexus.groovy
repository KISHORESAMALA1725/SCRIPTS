pipeline {
    agent any
    
    environment {
        // Nexus server information
        NEXUS_URL = 'http://your-nexus-server/repository/maven-releases/'
        NEXUS_USERNAME = credentials('nexus-username')  // Set Nexus credentials in Jenkins credentials store
        NEXUS_PASSWORD = credentials('nexus-password')
        MAVEN_HOME = tool 'Maven 3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Deploy to Nexus') {
            steps {
                script {
                    // Run Maven deploy to Nexus
                    sh """
                    ${MAVEN_HOME}/bin/mvn clean deploy -DaltDeploymentRepository=nexus-releases::default::${env.NEXUS_URL} \
                        -Dnexus.username=${env.NEXUS_USERNAME} -Dnexus.password=${env.NEXUS_PASSWORD}
                    """
                }
            }
        }

        stage('Quality Gate Check') {
            steps {
                // Check quality gate results from SonarQube or other tools
            }
        }
    }
}
