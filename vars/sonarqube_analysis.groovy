def call(Map config = [:]) {
    stage(config.stageName ?: 'SonarQube Analysis') {
        def scannerHome = tool 'SonarScanner'   // name from Jenkins Tool config
        withSonarQubeEnv(config.server ?: 'Sonar') {
            sh """
              ${scannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=${config.projectKey ?: 'default-project'} \
                -Dsonar.projectName=${config.projectName ?: 'default'} \
                -Dsonar.sources=${config.sources ?: '.'}
            """
        }
    }
}
