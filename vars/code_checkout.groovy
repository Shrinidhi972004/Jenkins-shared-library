def call(Map config = [:]) {
    stage("Git Checkout") {
        checkout([
            $class: 'GitSCM',
            branches: [[name: config.branch ?: "main"]],
            userRemoteConfigs: [[
                url: config.repoUrl,
                credentialsId: config.get('credentialsId', null)
            ]]
        ])
    }
}
