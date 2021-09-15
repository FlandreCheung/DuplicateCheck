import Utils.HammingUtils;
import Utils.IOUtils;
import Utils.SimHashUtils;
import org.junit.Test;

public class DuplicateCheckTest {
    @Test
    public void testDuplicateCheck(){
        String originFile = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig.txt");
        String[] copyFile = new String[5];
        copyFile[0] = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_add.txt");
        copyFile[1] = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_del.txt");
        copyFile[2] = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_dis_1.txt");
        copyFile[3] = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_dis_10.txt");
        copyFile[4] = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_dis_15.txt");

        String resultPath = "C:\\Users\\10920\\Desktop\\test\\result.txt";

        for(int i=0;i<5;i++){
            double res = HammingUtils.getSimilarity(SimHashUtils.getSimHash(originFile), SimHashUtils.getSimHash(copyFile[i]));
            IOUtils.write(res,resultPath);
        }

    }

}
