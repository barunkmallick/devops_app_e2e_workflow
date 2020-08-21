node()
{
   
    stage ("Execute Shell -1")
    {
        for(int i =0;i<5;i++) {
            sh "wget https://raw.githubusercontent.com/raspberrypi/linux/rpi-4.9.y/arch/arm/configs/bcmrpi_defconfig"
        }
    }
    stage ("Execute Shell -2")
    {
        sh "mv bcmrpi_defconfig bcmrpi_defconfig.json ; mkdir testjson -p ; mv bcmrpi_defconfig.json testjson/"
    }
    stage ("Execute Shell -3")
    {
        sh "cd testjson"
        sh 'JPM_FILENAME=$(ls)'
        sh 'echo "${JPM_FILENAME}> log.txt"'
    }
    stage ("Execute Shell -4")
    {
        println "Hello World"
    }
}
