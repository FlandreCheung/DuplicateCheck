import Utils.HammingUtils;
import Utils.IOUtils;
import Utils.CalculateUtils;

/**
 * 主类
 */
public class DuplicateCheck {
    public static void main(String[] args) {
        String str1 = IOUtils.read(args[0]);
        String str2 = IOUtils.read(args[1]);
        String outPutFileName = "result";

        String simHash1 = CalculateUtils.getSimHash(str1);
        String simHash2 = CalculateUtils.getSimHash(str2);

        double sim = HammingUtils.getSimilarity(simHash1,simHash2);
        IOUtils.write(sim,outPutFileName);
    }
}
