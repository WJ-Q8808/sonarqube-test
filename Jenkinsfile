 node {
        stage('Preparation') {  
          git 'https://github.com/xyctruth/sonarqube-test.git'
        }
        stage("代码编译与分析") {
          def mvnHome = tool 'mvn-3.6.3'
          withEnv(["MVN_HOME=$mvnHome"]) {
            withSonarQubeEnv('ONES-Server') {
                sh '"$MVN_HOME/bin/mvn" sonar:sonar -Dsonar.projectKey=xyc-sonarqube-test -Dsonar.java.binaries=.'
            }
          }
          def qg = waitForQualityGate()
          println qg.status
        }
}
