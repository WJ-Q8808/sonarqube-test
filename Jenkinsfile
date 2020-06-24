 node {
        stage("代码编译与分析") {
          def mvnHome = tool 'mvn-3.6.3'
          withEnv(["MVN_HOME=$mvnHome"]) {
            withSonarQubeEnv('ONES-Server') {
                sh 'mvn sonar:sonar -Dsonar.projectKey=xyc-sonarqube-test -Dsonar.java.binaries=.'
            }
          }
        }
}
