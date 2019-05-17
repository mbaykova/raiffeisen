#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
            withMaven(maven: 'Maven3') {
                    sh 'mvn clean install'
            }
    }
}