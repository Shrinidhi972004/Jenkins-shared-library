def call(Map config = [:]) {
    stage("Kubernetes YAML Scan") {
        def path = config.path ?: "k8s/"
        sh "kube-score score ${path} || true"
    }
}
