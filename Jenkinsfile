 pipeline {
        agent none
        tools {
            maven 'mvn-3.6.3'
        }
        stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('ONES-Server') {
                sh 'mvn clean package sonar:sonar -Dsonar.projectName=xyc-sonarqube-test -Dsonar.sources=.'
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        }
      }