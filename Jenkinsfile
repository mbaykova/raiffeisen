#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
            withMaven(maven: 'Maven 3') {
                    sh 'mvn clean install'
            }
    }
}