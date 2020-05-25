pipeline {
        agent none
         tools {
                maven 'maven-3.6.3'
                sonar-scanner 'sonar-scanner-4.3.0'
         }
        stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh "maven -B -e clean install -Dmaven.test.skip=true"
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
