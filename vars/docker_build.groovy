def call(Map config = [:]) {
    stage("Docker Build") {
        sh "docker build -t ${config.image}:${config.tag} ."
    }
}
