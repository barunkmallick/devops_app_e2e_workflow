pipeline {
    agent any
    stages {
        stage("Initialization") {
            steps {
                // use name of the patchset as the build name
                buildName "${CHANGE_TITLE}"
                buildDescription "Executed @ ${NODE_NAME}"
            }
        }
    }
    post {
        failure {
            // in case of failure, we'd like to have simple 'git blame' on build history :)
            currentBuild.displayName = 'This build needs help!!!'
            buildDescription("Committer: ${CHANGE_AUTHOR}")
        }
    }
}
