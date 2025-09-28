def call(Map config = [:]) {
    stage(config.stageName ?: 'Secrets Scan') {   // Stage name defaults to "Secrets Scan"
        def path = config.path ?: "."            // Path defaults to current dir

        sh """
          export GIT_PYTHON_GIT_EXECUTABLE=/usr/bin/git   # Tell GitPython where git is
          /var/lib/jenkins/venvs/trufflehog/bin/trufflehog filesystem ${path} || true
        """
    }
}
