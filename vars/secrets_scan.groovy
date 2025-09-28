def call(Map config = [:]) {
    stage(config.stageName ?: 'Secrets Scan') {
        def path = config.path ?: "."
        sh "trufflehog filesystem ${path} || true"
    }
}
