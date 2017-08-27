package groovy
/**
 * @title
 * @author dreamyao
 * @Date 2017/8/14 20:58
 * @version 1.0.0
 */
class GroovyTest {
    static void main(String[] args) {
        3.times{
            println "Hello Groovy"
        }
        testPrint("lalalala")
        openFile("none")
    }

    static def testPrint(a){
        print(a)
    }

    static def openFile(fileName) {
        new FileInputStream(fileName)
    }

}
