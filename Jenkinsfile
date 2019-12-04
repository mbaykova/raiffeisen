#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }

    stage('Run tests') {
        try{
            withCredentials([
                    usernamePassword(credentialsId: '03307749-c583-4c4f-9b8c-fffe4e2ea026',
                            usernameVariable: 'username',
                            passwordVariable: 'password')
            ])
                 withMaven(maven: 'Maven3') {
                                bat 'mvn clean -Dusername='+username +' -Dpassword='+password+' install'
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