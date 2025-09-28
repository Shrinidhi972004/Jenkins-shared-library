def call(Map config = [:]) {
    stage(config.stageName ?: 'Docker Push') {
        def image = config.image ?: "my-image"
        def tag = config.tag ?: "latest"
        def creds = config.credentialsId ?: "docker-credentials"

        withCredentials([usernamePassword(
            credentialsId: creds,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            sh """
              echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
              docker push ${image}:${tag}
            """
        }
    }
}
