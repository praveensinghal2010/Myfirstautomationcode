pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven'  // Use the configured Maven tool in Jenkins
        DOCKER_REGISTRY = 'yourdockerhubusername'  // Replace with your Docker Hub username
        DOCKER_IMAGE_NAME = 'mywebapp'  // Replace with your desired Docker image name
        DOCKER_IMAGE_TAG = 'latest'  // Replace with your desired Docker image tag/version
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout your Maven project from version control system (e.g., Git)
                // Modify the URL and credentials accordingly
                checkout([$class: 'GitSCM', 
                          branches: [[name: '*/main']],
                          userRemoteConfigs: [[url: 'https://github.com/yourusername/your-maven-project.git']]])
            }
        }

        stage('Build and Test') {
            steps {
                // Build your Maven project and run the Selenium tests
                sh "${MAVEN_HOME}/bin/mvn clean test"
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
            // Perform any cleanup or post-build actions here if needed
        }

        success {
            // Actions to perform when the build is successful
        }

        failure {
            // Actions to perform when the build fails
        }
    }
}
