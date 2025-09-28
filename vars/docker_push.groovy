def call(Map config = [:]) {
    stage("Docker Push") {
        withCredentials([usernamePassword(credentialsId: config.credentialsId,
                                          usernameVariable: 'DOCKER_USER',
                                          passwordVariable: 'DOCKER_PASS')]) {
            sh """
              echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
              docker push ${config.image}:${config.tag}
            """
        }
    }
}
