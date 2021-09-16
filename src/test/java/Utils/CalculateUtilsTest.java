package Utils;

import org.junit.Test;

public class CalculateUtilsTest {

    @Test
    public void byteToBinStringTest(){
        byte[] bytes = {12,13,14};
        String binString = CalculateUtils.bytesToBinString(bytes);
        System.out.println(binString);
    }

    @Test
    public void hashKeyForDiskTest(){
        String key = "test hash key";
        System.out.println(CalculateUtils.hashKeyForDisk(key));
    }

    @Test
    public void getSimHashTest(){
        String test = "懂得都懂懂得都懂懂得都懂懂得都懂懂得都懂懂得都懂懂得都懂懂得都懂懂得都懂";
        System.out.println(CalculateUtils.getSimHash(test));
    }

    @Test
    public void invalidStringTest(){
        String test = "abc";
        System.out.println(CalculateUtils.getSimHash(test));
    }
}
