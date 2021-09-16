package Utils;

import org.junit.Test;

public class IOUtilsTest {

    public final String path = "C:\\Users\\10920\\Desktop\\test\\";


    @Test
    public void readTest(){
        String txt = IOUtils.read(path+"orig.txt");
        System.out.println(txt);
    }

    @Test
    public void writeTest(){
        double[] test = {1,3,555};
        IOUtils.write(test[1],path+"testResult.txt");
    }

    /**
     * 用于测试无效的路径
     */
    @Test
    public void invalidPathTest(){
        //无效路径测试
        String txt = IOUtils.read(path+"null.txt");
        System.out.println(txt);
    }
}
