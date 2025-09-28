def call(Map config = [:]) {
    stage(config.stageName ?: 'Git Checkout') {
        if (config.credentialsId) {
            // For private repos
            checkout([
                $class: 'GitSCM',
                branches: [[name: config.branch ?: 'main']],
                userRemoteConfigs: [[
                    url: config.repoUrl,
                    credentialsId: config.credentialsId
                ]]
            ])
        } else {
            // For public repos
            git branch: (config.branch ?: 'main'),
                url: (config.repoUrl ?: 'https://github.com/example/repo.git')
        }
    }
}
