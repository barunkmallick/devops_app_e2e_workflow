def listProjNames = ['dev','stage', 'prod' ]

def disableProj = [ "dev": true,
                    "stage": false,
                    "prod": false
                  ]      
                   
listProjNames.eachWithIndex {projNames, index->

def jobName = "epmp-${projNames}"
    
freeStyleJob(jobName) {
    
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
    job('epmp-dev') {
    label(null)
	}     
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
