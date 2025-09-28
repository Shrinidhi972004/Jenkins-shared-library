def call(String SonarQubeAPI, String Projectname, String ProjectKey) {
    withSonarQubeEnv("${SonarQubeAPI}") {
        sh """
          ${SONAR_HOME}/bin/sonar-scanner \
            -Dsonar.projectName='${Projectname}' \
            -Dsonar.projectKey=${ProjectKey} \
            -Dsonar.sources=. \
            -Dsonar.host.url=$SONAR_HOST_URL \
            -Dsonar.login=$SONAR_AUTH_TOKEN
        """
    }
}
