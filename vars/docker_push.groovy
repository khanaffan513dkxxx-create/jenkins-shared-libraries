def call(String Project, String ImageTag, String dockerhubuser) {

    withCredentials([usernamePassword(
        credentialsId: 'DockerHubCred',
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {

        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"

        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
}
