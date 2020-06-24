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
            }
          }
          // stage("质量检查") {
          //   steps {
          //       script {
          //        timeout(time: 1, unit: 'HOURS') {
          //            sleep(5)
          //            def qg = waitForQualityGate()
          //            println qg.status
          //            if (qg.status != 'OK') {
          //                error "未通过SonarQube的代码检查，请及时修改! failure: ${qg.status}"
          //            }
          //        }
          //    }
          //   }
          // }
            stage('代码构建') {
              steps {
                  echo "build is ok"
              }
          }
        }
      }
