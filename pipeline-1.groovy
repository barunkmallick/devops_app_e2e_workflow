node {
    stage('Git clone') {
        deleteDir()
        checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/barunkmallick/devops_app_e2e_workflow.git']]]
    }
    stage('List') {
         sh "ls"
    }
    stage('List') {
        env.BRANCH_NAME = "master"
        env.sum = sh (label: '', returnStdout: true, script: 'echo "hello" + "world"').trim()
         
         println "${env.BRANCH_NAME}"
         println "${env.sum}"
         sh "mkdir india"
    }
    stage('Example') {
    println "branch ===>${env.BRANCH_NAME}==="
        if (env.BRANCH_NAME == 'master') {
            echo 'I only execute on the master branch'
        } else {
            echo 'I execute elsewhere'
        }
    }
}
