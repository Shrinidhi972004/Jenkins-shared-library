def call(String serverName, String projectName, String projectKey) {
    withSonarQubeEnv(serverName) {
        sh """
          ${SONARQUBE_SCANNER_HOME}/bin/sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.projectName='${projectName}' \
            -Dsonar.sources=. \
            -Dsonar.host.url=$SONAR_HOST_URL \
            -Dsonar.login=$SONAR_AUTH_TOKEN
        """
    }
}
