node {
    stage('test') {
        build job: 'test-compile', propagate: false
        build job: 'test', propagate: false
    }

    stage('Build') {
        input 'Do you want to proceed to the Deployment?'
        build job: 'build', propagate: false
    }



    stage('deploy') {
        build job: 'deploy', propagate: false
    }

}