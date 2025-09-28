def call(Map config = [:]) {
    stage(config.stageName ?: 'Trivy Image Scan') {
        def image = config.image
        def tag = config.tag ?: "latest"
        def severity = config.severity ?: "HIGH,CRITICAL"

        if (!image) {
            error "❌ Trivy scan requires 'image' parameter"
        }

        sh "trivy image --exit-code 0 --severity ${severity} ${image}:${tag} || true"
    }
}
