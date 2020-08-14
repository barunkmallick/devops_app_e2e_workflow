
job('Freestyle job'){
	
    concurrentBuild(true)
    
    logRotator {
        numToKeep(3)
        daysToKeep(3)
    }
     parameters {
        choiceParam('OPTION', ['option 1 (default)', 'option 2', 'option 3'])
        stringParam('MY STRING PARAM', defaultValue = null, description = 'This is a dsl script generated string param')
    }
    scm {
        git {
            remote {
                url('https://github.com/barunkmallick/devops_app_e2e_workflow.git')
		credentials('test')    
                   }
		extensions {
                cleanAfterCheckout()
                            }
            branch('master')
		triggers {
        	scm('5 * * * *')
    		}
        }
    }
   wrappers {
	   
        buildName('JenkinsMaven@${BUILD_NUMBER}')
	    buildUserVars()
    }
       steps {
       buildDescription(/.*\[INFO\] Uploading project information for [^\s]* ([^\s]*)/)
       shell ('echo ${JOB_NAME}>log.txt')
       shell ('echo "Hello World!">>log.txt')
    	  
    }
    
}
