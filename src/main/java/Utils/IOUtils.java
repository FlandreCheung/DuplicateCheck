package Utils;

import java.io.*;

public class IOUtils {

    /**
     * 读入文件
     * @param filePath 文件路径
     * @return 文件内容
     */
    public static String read(String filePath){
        StringBuilder str = new StringBuilder();
        String readLine;

        File file = new File(filePath);
        FileInputStream fileInputStream = null;

        try{
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //若字符串不为空，则将其拼接入字符串
            while ((readLine = bufferedReader.readLine())!= null){
                str.append(readLine);
            }
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        return str.toString();
    }

    /**
     * 写入文件
     * @param Elem 文件内容
     * @param filePath 文件路径
     */
    public static void write(double Elem,String filePath){
        String str = Double.toString(Elem);
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file);
            fileWriter.write(str,0,(str.length() > 3 ? 4 : str.length()));
            fileWriter.write("\r\n");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
