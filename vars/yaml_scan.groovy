def call(Map config = [:]) {
    stage(config.stageName ?: 'Kubernetes YAML Scan') {
        def path = config.path ?: "k8s/"
        sh "kube-score score ${path} || true"
    }
}
