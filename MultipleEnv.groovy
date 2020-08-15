def listProjNames = ['epmp_dev','epmp_Stage', 'epmp_Prod' ]

def disableProj = [ "epmp_dev": true,
                     "epmp_Stage": false,
                   "epmp_Prod": false
                  ]      
                   
listProjNames.eachWithIndex {projNames, index->

freeStyleJob(projNames) {
    
    logRotator {
        numToKeep(3)
        daysToKeep(3)
    }
    disabled(disableProj[projNames])
    
    parameters {
       stringParam('env', '','emv name:')
       booleanParam('RUN_TESTS', true, 'uncheck to disable tests')
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
