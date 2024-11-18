pipeline {
    agent any
    tools {
        maven  'Maven-3.8.8'
        jdk 'JDK-17'
    }
    environment {
        TOMCAT_CREDS = credentials('tomcat_credentials')
        // please change tomcat credentials as per your credentials     
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCAL = "http"
        NEXUS_URL = "PUT NEXUS PUBLIC IP"
        NEXUS_REPO = "new-repo-test" // create a new repository in the nexus //
    }
    stages {
        stage ('clone'){
            steps {
                git credentialsId: 'github_siva_credentials', url: '<SPRING_PETCLINIC>'
            }
        }
        stage ('Build') {
            steps {
                sh "mvn clean package -Dmaven.test.failure.ignore=true"
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.war', followSymlinks: false
                }
            }
        }
        stage ('Deploy to tomcat') {
            steps {
                // curl commands
                //  please make necessary changes in IP and credentials sections
                sh "curl -v -u ${TOMCAT_CREDS_USR}:${TOMCAT_CREDS_PSW} -T /var/lib/jenkins/workspace/allpipeline/target/spring3-mvc-maven-xml-hello-world-1.0-SNAPSHOT.war 'http://<tomcat.ip>:8080/manager/text/deploy?path=/spring-hello&update=true'"
            }
        }
        stage ('Nexus') {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml"
                    // now pom is having all pom.xml data, using readMavenPom method we pulled pom.xml data to pom variable //
                    files = findFiles(glob: "target/*.${pom.packaging}")
                    // packaging means <package>war/jar</package> in pom if u recall
                    // FOR VERIFICATION, NO USE
                    echo "echo ${files[0].name} ${files[0].path} ${files[0].directory} ${files[0].length} ${files[0].lastmodified}"
                    // get the path means (target location war/jar file) location, to check below 
                    artifactPath = files[0].path;
                    // if file  exists  and storing  in a variable "artifactExists"
                    artifactExists = fileExists artifactPath;
                    // code "If artifacts exists" echo below will show us
                    echo "${artifactExists}"
                    // code
                    if (artifactExists){
                        // run the piece of code
                        echo "******* Artifacts is available , going to deploy to nexus"
                        echo "File is: ${artifactPath} , package is: ${pom.packaging} , Version is: ${pom.version} , groupId is: ${pom.groupId}"
                        // now we need to deploy to nexus, using a plugin called as Nexus-Artifact-Uploader //   
                        nexusArtifactUploader {
                            nexusVersion: "${env.NEXUS_VERSION}",
                            protocol: "${env.NEXUS_PROTOCOL}",
                            nexusUrl: "${env.NEXUS_URL}",
                            groupId: "${pom.groupId}",
                            // version: "${pom.version}",
                            version: "${BUILD_NUMBER}",
                            repository: "${pom.NEXUS_REPO}",
                            credentialsId: "nexus_creds" // your nexus credentials which u have created in your jenkins credentials //
                            artifact [
                                artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging
                            ]
                        }
                    }
                    else {
                        error "*********** ${artifactPath} is not available **********"
                    }
                }
            }
        }
    }
}