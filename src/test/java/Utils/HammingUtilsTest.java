package Utils;

import org.junit.Test;

public class HammingUtilsTest {

    @Test
    public void getHammingDistanceTest(){
        String text1 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig.txt");
        String text2 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_dis_1.txt");
        int distance = HammingUtils.getHammingDistance(SimHashUtils.getSimHash(text1),SimHashUtils.getSimHash(text2));
        System.out.println(distance);
    }

    @Test
    public void getSimilarityTest(){
        String text1 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig.txt");
        String text2 = IOUtils.read("C:\\Users\\10920\\Desktop\\test\\orig_0.8_dis_1.txt");
        double similarity = HammingUtils.getSimilarity(SimHashUtils.getSimHash(text1),SimHashUtils.getSimHash(text2));
        System.out.println(similarity);
    }
}
