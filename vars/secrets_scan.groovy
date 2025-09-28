def call(Map config = [:]) {
    stage("Secrets Scan") {
        def path = config.path ?: "."
        sh """
          export GIT_PYTHON_GIT_EXECUTABLE=/usr/bin/git
          /var/lib/jenkins/venvs/trufflehog/bin/trufflehog git file://${path} || true
        """
    }
}
