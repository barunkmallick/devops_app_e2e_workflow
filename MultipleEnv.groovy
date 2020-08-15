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
    label('x86 && ubuntu')
    
     publishers {
        archiveArtifacts {
            pattern('build/test-output/**/*.html')
            pattern('build/test-output/**/*.xml')
            onlyIfSuccessful()
        }
    }
    
    parameters {
       stringParam('env', '','emv name:')
       booleanParam('RUN_TESTS', true, 'uncheck to disable tests')
    }
    
     
    concurrentBuild(true)
      
    multiscm {
        git {
            remote {
                url('https://github.com/barunkmallick/devops_app_e2e_workflow.git')
		        credentials('test')    
             }
            branch('master')
        }
        git {
            remote {
                url('https://github.com/barunkmallick/devops_app_e2e_workflow.git')
		        credentials('test')    
             }
            branch('master/indiaSCM')
        }
     } 
    
    wrappers {
         credentialsBinding {
            file('KEYSTORE', 'keystore.jks')
            usernamePassword('PASSWORD', 'keystore password')
        }
    }
}
}
