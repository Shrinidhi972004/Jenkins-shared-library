def call(Map config = [:]) {
    stage("Run Tests") {
        sh "${config.command ?: 'npm test'}"
    }
}
