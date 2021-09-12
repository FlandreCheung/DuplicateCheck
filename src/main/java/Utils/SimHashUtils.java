package Utils;


import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class SimHashUtils {

    /**
     * 将字节数组转换为二进制字符串
     * @param bytes 字节数组
     * @return 二进制字符串
     */
    private static String bytesToBinString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            String bin = Integer.toBinaryString(0xFF & aByte);
            if (bin.length() == 1) {
                sb.append('0');
            }
            sb.append(bin);
        }
        return sb.toString();
    }

    /**
     * 求输入字符串的hash值
     * @param key 输入字符串
     * @return hash
     */
    public static String hashKeyForDisk(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            cacheKey = bytesToBinString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    /**
     * 求输入字符串的simHash值
     * @param str 输入字符串
     * @return simHash
     */
    public static String getSimHash(String str) {
        int i=0;
        int[] vector = new int[128];
        //1.分词
        List<Term> termList = StandardTokenizer.segment(str);
        int size = termList.size();
        //2.获取Hash值
        for (Term term : termList) {
            StringBuilder hashRate = new StringBuilder(hashKeyForDisk(term.word));
            if (hashRate.length() < 128) {
                // hash值可能少于128位，在低位以0补齐
                int dif = 128 - hashRate.length();
                for (int j = 0; j < dif; j++) {
                    hashRate.append("0");
                }
            }
            // 3、加权与合并
            for (int j = 0; j < vector.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (hashRate.charAt(j) == '1') {
                    //权重分10级，由词频从高到低，取权重10~0
                    vector[j] += (10 - (i / (size / 10)));
                } else {
                    vector[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
            // 4、降维
            StringBuilder simHash = new StringBuilder();// 储存返回的simHash值
        for (int k : vector) {
            if (k <= 0) {
                simHash.append("0");
            } else {
                simHash.append("1");
            }
        }
            return simHash.toString();
        }

}


