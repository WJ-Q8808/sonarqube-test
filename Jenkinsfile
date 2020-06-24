 pipeline {
        agent none
        tools {
            maven 'mvn-3.6.3'
        }
        stages {
          stage("代码编译与分析") {
            agent any
            steps {
              withSonarQubeEnv('ONES-Server') {
                sh 'mvn sonar:sonar -Dsonar.projectKey=xyc-sonarqube-test -Dsonar.java.binaries=.'
              }
              script {
                def qg = waitForQualityGate()
                println qg.status
              }
            }
          }
        }
      }
