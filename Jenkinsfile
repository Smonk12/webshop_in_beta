pipeline {
    agent any
    tools {
        jdk 'JDK21'
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
                bat 'mvn clean compile'
            }
        }
        stage('Run Tests') {
            steps {
                // Run tests in headless mode
                bat 'mvn test -Dheadless=true'
            }
        }
        stage('Publish Reports') {
            steps {
                // Publish JUnit test results
                junit 'target/surefire-reports/*.xml'
        
                // Publish HTML report
                publishHTML([
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/extent-reports',  // path where HTML reports are generated
                    reportFiles: 'index.html',           // main HTML file of the report
                    reportName: 'Extent Test Report'     // name shown in Jenkins
                ])
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
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
