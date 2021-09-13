package Utils;

import org.junit.Test;

public class IOUtilsTest {

    @Test
    public void readTest(){
        String txt = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig.txt");
        System.out.println(txt);
    }

    @Test
    public void writeTest(){
        double[] test = {1,3,555};
        IOUtils.write(test[1],"C:\\Users\\10920\\Desktop\\test\\result.txt");
    }

}
