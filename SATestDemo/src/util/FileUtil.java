package util;

import java.io.*;

public class FileUtil {
    public String dbFileContent(String filePath) throws IOException {
        // 第一步：建立连接关系
        File file = new File(filePath);

        // 第二步：获取输入流
        FileInputStream stream = new FileInputStream(file);

        // 第三步：读取输入流
        InputStreamReader inputStreamReader = new InputStreamReader(stream);

        // 第四步：将流写进StringBuffer中，输出
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null ;
        StringBuilder strBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null){
            strBuilder.append(line);
        }

        // 第五步：关流
        bufferedReader.close();
        inputStreamReader.close();
        stream.close();

        // 返回
        return strBuilder.toString();
    }
}

