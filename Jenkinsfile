pipeline {
    agent any

    environment {
     
        DOCKER_REGISTRY = 'praveensinghal'  // Replace with your Docker Hub username
        DOCKER_IMAGE_NAME = 'mywebapp'  // Replace with your desired Docker image name
        DOCKER_IMAGE_TAG = 'latest'  // Replace with your desired Docker image tag/version
    }

    

        stage('Build and Test') {
            steps {
                // Build your Maven project and run the Selenium tests
                sh "clean test"
            }
        }

        stage('Create Docker Image') {
            steps {
                // Build the Docker image using the Dockerfile
                sh "docker build -t ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                // Log in to Docker Hub
                withCredentials([string(credentialsId: 'docker-hub-credentials', variable: 'DOCKER_HUB_CREDENTIALS')]) {
                    sh "docker login -u ${DOCKER_REGISTRY} -p ${DOCKER_HUB_CREDENTIALS}"
                }

                // Push Docker image to Docker Hub
                sh "docker push ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
            }
        }
    }

    post {
        always {
            // This block will always run, regardless of the build result
            echo 'Post-build action: Always'
        }

        success {
            // This block will run only if the build is successful
            echo 'Post-build action: Success'
        }

        failure {
            // This block will run only if the build fails
            echo 'Post-build action: Failure'
        }
    }
}
