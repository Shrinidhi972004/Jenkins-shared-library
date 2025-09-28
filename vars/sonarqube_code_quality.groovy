def call() {
    timeout(time: 30, unit: "MINUTES") {
        waitForQualityGate abortPipeline: true
    }
}

