 pipeline {
        agent none
        stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('ONES-Server') {
                sh 'mvn clean package sonar:sonar'
              }
            }
          }
        stage("Quality Gate"){
              timeout(time: 1, unit: 'HOURS') {
                  def qg = waitForQualityGate()
                  if (qg.status != 'OK') {
                      error "Pipeline aborted due to quality gate failure: ${qg.status}"
                  }
              }
          }
        }
      }