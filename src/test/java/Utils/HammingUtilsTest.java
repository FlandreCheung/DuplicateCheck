package Utils;

import org.junit.Test;

public class HammingUtilsTest {

    @Test
    public void getHammingDistanceTest(){
        String text1 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig.txt");
        String text2 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_dis_1.txt");
        int distance = HammingUtils.getHammingDistance(CalculateUtils.getSimHash(text1), CalculateUtils.getSimHash(text2));
        System.out.println(distance);
    }

    @Test
    public void getSimilarityTest(){
        String text1 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig.txt");
        String text2 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_dis_1.txt");
        double similarity = HammingUtils.getSimilarity(CalculateUtils.getSimHash(text1), CalculateUtils.getSimHash(text2));
        System.out.println(similarity);
    }
}
