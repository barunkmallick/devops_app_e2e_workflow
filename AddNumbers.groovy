node()
{
    environment {
           result = 0
    }
    stage ("Add Number")
    {
        println "Add the numbers" 
            def x = 2;
            def y = 2;
            def z =0;
            
            z = x + y;
            env.result= z
          
            echo "RESULT=${result}"
            
        
    }
    stage ("Condition Check")
    {
        println "Check the condition: " 
        def brf = env.result.toInteger()
        
        
        if (brf > 5) {
                println("I m in IF")
                println (brf)
                println "The Build is a Stable"

            } 
            else {
                println("I m in ELSE")
                println (brf)
                println "The Build is UnStable"

            }           
    }
}
