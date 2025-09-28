def call(Map config = [:]) {
    stage(config.stageName ?: 'SonarQube Analysis') {
        withSonarQubeEnv(config.server ?: 'Sonar') {
            sh """
              sonar-scanner \
                -Dsonar.projectKey=${config.projectKey ?: 'default-project'} \
                -Dsonar.projectName=${config.projectName ?: 'default'} \
                -Dsonar.sources=${config.sources ?: '.'}
            """
        }
    }
}
