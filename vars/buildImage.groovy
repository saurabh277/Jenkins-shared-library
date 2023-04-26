def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credential', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t saurabh277/jenkinsapp .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push saurabh277/jenkinsapp'
    }
}
