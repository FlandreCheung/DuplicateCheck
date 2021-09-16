package Utils;

import org.junit.Test;

public class HammingUtilsTest {

    public final String path = "C:\\Users\\10920\\Desktop\\test\\";

    @Test
    public void getHammingDistanceTest(){
        String text1 = IOUtils.read(path+"orig.txt");
        String text2 = IOUtils.read(path+"orig_0.8_dis_1.txt");
        int distance = HammingUtils.getHammingDistance(CalculateUtils.getSimHash(text1), CalculateUtils.getSimHash(text2));
        System.out.println(distance);
    }

    @Test
    public void getSimilarityTest(){
        String text1 = IOUtils.read(path+"orig.txt");
        String text2 = IOUtils.read(path+"orig_0.8_dis_1.txt");
        double similarity = HammingUtils.getSimilarity(CalculateUtils.getSimHash(text1), CalculateUtils.getSimHash(text2));
        System.out.println(similarity);
    }

    /**
     * 用于测试两个乱序的字符串
     */
    @Test
    public void disOrderStringTest(){
        String text1 = "猛然我一看就猛然看到，这个评论，直呼我我直呼上次，看到这么的发言这么还是上次，典型了属于是这评论属于是典型的";
        String text2 = "我猛然一看，就猛然看到这个评论，我直呼我直呼，上次看到这么这么的发言还是上次，这评论属于是典型的典型了属于是";
        int distance = HammingUtils.getHammingDistance(CalculateUtils.getSimHash(text1), CalculateUtils.getSimHash(text2));
        System.out.println(distance);
    }
}
