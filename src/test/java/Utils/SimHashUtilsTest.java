package Utils;

import org.junit.Test;

public class SimHashUtilsTest {

    @Test
    public void byteToBinStringTest(){
        byte[] bytes = {12,13,14};
        String binString = SimHashUtils.bytesToBinString(bytes);
        System.out.println(binString);
    }

    @Test
    public void hashKeyForDiskTest(){
        String key = "test hash key";
        System.out.println(SimHashUtils.hashKeyForDisk(key));
    }

    @Test
    public void getSimHashTest(){
        String test = "test simHash keytest simHash keytest simHash keytest simHash keytest simHash keytest simHash keytest simHash key";
        System.out.println(SimHashUtils.getSimHash(test));
    }
}
