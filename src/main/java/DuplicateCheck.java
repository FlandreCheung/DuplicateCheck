import Utils.HammingUtils;
import Utils.IOUtils;
import Utils.SimHashUtils;

public class DuplicateCheck {
    public static void main(String[] args) {
        String str1 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig.txt");
        String str2 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_add.txt");
        String outPutFileName = "result";

        String simHash1 = SimHashUtils.getSimHash(str1);
        String simHash2 = SimHashUtils.getSimHash(str2);

        double sim = HammingUtils.getSimilarity(simHash1,simHash2);
        IOUtils.write(sim,outPutFileName);
    }
}
