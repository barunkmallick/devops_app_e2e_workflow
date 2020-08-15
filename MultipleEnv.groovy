def listProjNames = ['epmp_dev','epmp_Stage', 'epmp_ptod' ]

listProjNames.eachWithIndex {projNames, index->

freeStyleJob(projNames) {
    
    logRotator {
        numToKeep(3)
        daysToKeep(3)
    }
        
    parameters {
       stringParam('env', '','emv name:')
    }
     
    concurrentBuild(true)
        
    scm {
        git {
            remote {
                url('https://github.com/barunkmallick/devops_app_e2e_workflow.git')
		        credentials('test')    
             }
            branch('master')
        }
     } 
}
}
