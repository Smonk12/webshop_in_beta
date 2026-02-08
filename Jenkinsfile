pipeline {
    agent any
    tools {
        jdk 'JDK11'
        maven 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Smonk12/webshop_in_beta.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Run Tests') {
            steps {
                // Run tests in headless mode
                sh 'mvn test -Dheadless=true'
            }
        }
        stage('Publish Reports') {
            steps {
                // Publish JUnit reports
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
    post {
        always {
            echo 'Build finished!'
        }
        success {
            echo 'All tests passed!'
        }
        failure {
            echo 'Some tests failed!'
        }
    }
}
