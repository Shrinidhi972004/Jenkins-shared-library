def call(Map config = [:]) {
    stage(config.stageName ?: 'Run Tests') {
        def command = config.command ?: "npm test"
        sh "${command}"
    }
}
