package Utils;

import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CalculateUtils {

    /**
     * 将字节数组转换为二进制字符串
     * @param bytes 字节数组
     * @return 二进制字符串
     */
    public static String bytesToBinString(byte[] bytes) {
        //采用线程安全的StringBuilder
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            String bin = Integer.toBinaryString(0xFF & aByte);
            //根据进制转换的规则拼接0和1
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
    public static String hashKeyForDisk(String key){
        String hashKey;
        try {
            //通过MD5加密，输出哈希值
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            hashKey = bytesToBinString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            hashKey = String.valueOf(key.hashCode());
        }
        return hashKey;
    }

    /**
     * 求输入字符串的simHash值
     * @param str 输入字符串
     * @return simHash
     */
    public static String getSimHash(String str) {
        int i=0;
        //用于存放哈希值，最高128位
        int[] vector = new int[128];
        //1.分词
        List<Term> termList = StandardTokenizer.segment(str);
        int size = termList.size();
        //2.获取Hash值
        for (Term term : termList) {
            //采用包HanLP的处理方法
            //从每个term对象中取出word属性，拼接为字符串
            //去除标点符号
            if(Nature.w.equals(term.nature)){
                continue;
            }
            StringBuilder hashRate = new StringBuilder(hashKeyForDisk(term.word));
            if (hashRate.length() < 128) {
                // hash值可能少于128位，在低位以0补齐
                int dif = 128 - hashRate.length();
                for (int j = 0; j < dif; j++) {
                    hashRate.append("0");
                }
            }
            // 3、加权与合并
            // 对keywordHash的每一位与'1'进行比较
                //若读入的文本过短则无法加权合并，抛出异常
                try{
                    for (int j = 0; j < vector.length; j++) {
                        if (hashRate.charAt(j) == '1') {
                            //权重分10级，由词频从高到低，取权重10~0
                            vector[j] += (10 - (i / (size / 10)));
                        } else {
                            vector[j] -= (10 - (i / (size / 10)));
                        }
                    }
                }catch (ArithmeticException e){
                    e.printStackTrace();
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


