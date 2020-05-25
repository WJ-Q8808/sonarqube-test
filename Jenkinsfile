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
                sh 'mvn sonar:sonar -Dsonar.projectKey=xyc-sonarqube-test -Dsonar.login=e63c01198f8a624867f764d027c0e25dbe2e33dc'
              }
            }
          }
          stage("Quality Gate") {
            steps {
                script {
                 timeout(time: 1, unit: 'HOURS') {
                     sleep(5)
                     def qg = waitForQualityGate()
                     if (qg.status != 'OK') {
                         error "未通过SonarQube的代码检查，请及时修改! failure: ${qg.status}"
                     }
                 }
             }
            }
          }
        }
      }