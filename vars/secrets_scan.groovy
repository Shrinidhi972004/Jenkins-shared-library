def call(Map config = [:]) {
    stage(config.stageName ?: 'Secrets Scan') {
        def path = config.path ?: "."
        sh """
          ${env.TRUFFLEHOG_PATH} filesystem ${path} || true
        """
    }
}
