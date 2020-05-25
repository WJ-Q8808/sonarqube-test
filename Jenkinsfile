pipeline {
        agent none
         tools {
                mvn 'apache-maven-3.6.3'
                sonar
         }
        stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh "mvn -B -e clean install -Dmaven.test.skip=true"
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
