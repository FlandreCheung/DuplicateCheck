package Utils;

public class HammingUtils {

    /**
     * 求两个simHash值的汉明距离
     * @param simHash1 simHash1
     * @param simHash2 simHash2
     * @return distance 汉明距离
     */
    public static int getHammingDistance(String simHash1,String simHash2){
        int distance = 0;

        for(int i=0;i<simHash1.length();i++){
            if(simHash1.charAt(i)!=simHash2.charAt(i)){
                distance++;
            }
        }
        return distance;
    }

    /**
     * 求两个simHash值的相似度
     * @param simHash1 simHash1
     * @param simHash2 simHash2
     * @return 相似度
     */
    public static double getSimilarity(String simHash1,String simHash2){
        double distance = getHammingDistance(simHash1,simHash2);
        return 0.01*(100-distance*100/128);
    }
}
