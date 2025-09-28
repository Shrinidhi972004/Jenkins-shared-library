def call(Map config = [:]) {
    stage(config.stageName ?: 'Docker Build') {
        def image = config.image ?: "my-image"
        def tag = config.tag ?: "latest"
        def context = config.context ?: "."

        sh "docker build -t ${image}:${tag} ${context}"
    }
}
