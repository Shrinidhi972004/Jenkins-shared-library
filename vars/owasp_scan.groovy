def call(Map config = [:]) {
    stage("OWASP Dependency Check") {
        def project = config.project ?: "project"
        def scanPath = config.scanPath ?: "."
        def format = config.format ?: "HTML"
        def output = config.output ?: "dependency-check-report"

        sh """
          dependency-check.sh \
            --project ${project} \
            --scan ${scanPath} \
            --format ${format} \
            --out ${output} || true
        """
    }
}
