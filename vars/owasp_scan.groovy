def call(Map config = [:]) {
    stage(config.stageName ?: 'OWASP Dependency Check') {
        def project = config.project ?: "default-project"
        def scanPath = config.scanPath ?: "."
        def format = config.format ?: "HTML"
        def output = config.output ?: "dependency-check-report"

        sh """
          dependency-check.sh \
            --project ${project} \
            --scan ${scanPath} \
            --format ${format} \
            --out ${output}
        """
    }
}
