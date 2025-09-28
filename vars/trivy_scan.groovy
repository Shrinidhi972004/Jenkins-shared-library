def call(Map config = [:]) {
    stage("Trivy Scan") {
        sh """
          trivy image --severity ${config.severity ?: "HIGH,CRITICAL"} \
          ${config.image}:${config.tag} || true
        """
    }
}
