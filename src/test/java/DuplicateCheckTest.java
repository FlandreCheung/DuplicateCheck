import Utils.HammingUtils;
import Utils.IOUtils;
import Utils.CalculateUtils;
import org.junit.Test;

public class DuplicateCheckTest {

    public final String path = "C:\\Users\\10920\\Desktop\\test\\";

    @Test
    public void testDuplicateCheck(){
        String originFile = IOUtils.read(path+"orig.txt");
        String[] copyFile = new String[5];
        copyFile[0] = IOUtils.read(path+"orig_0.8_add.txt");
        copyFile[1] = IOUtils.read(path+"orig_0.8_del.txt");
        copyFile[2] = IOUtils.read(path+"orig_0.8_dis_1.txt");
        copyFile[3] = IOUtils.read(path+"orig_0.8_dis_10.txt");
        copyFile[4] = IOUtils.read(path+"orig_0.8_dis_15.txt");

        String resultPath = path+"result.txt";

        for(int i=0;i<5;i++){
            double res = HammingUtils.getSimilarity(CalculateUtils.getSimHash(originFile), CalculateUtils.getSimHash(copyFile[i]));
            IOUtils.write(res,resultPath);
        }

    }

}

