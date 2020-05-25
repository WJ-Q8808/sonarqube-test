pipeline {
        agent none
        stages {
          stage("build & SonarQube analysis") {
            agent any
            def m3 = tool name: 'mvn'
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh "${m3}/bin/mvn -B -e clean install -Dmaven.test.skip=true"
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
