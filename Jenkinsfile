#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
        try{
                 withMaven(maven: 'Maven3') {
                                sh 'mvn clean install'
                        }
        }  catch (e) {
                     currentBuild.result = 'FAILURE'
                     throw e
         }finally {
             stage('Reports') {
                                allure([
                                    includeProperties: false,
                                    jdk: '',
                                    properties: [],
                                    reportBuildPolicy: 'ALWAYS',
                                    results: [[path: 'target/allure-results']]
                                ])
                            }
         }

    }

}