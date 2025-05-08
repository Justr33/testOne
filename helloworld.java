pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Compile Java') {
            steps {
                echo 'Compiling HelloWorld.java...'
                sh 'javac HelloWorld.java'
            }
        }

        stage('Run Java') {
            steps {
                echo 'Running HelloWorld class...'
                sh 'java HelloWorld'
            }
        }
    }

    post {
        success {
            echo '✅ Java HelloWorld ran successfully!'
        }
        failure {
            echo '❌ Something went wrong.'
        }
    }
}
