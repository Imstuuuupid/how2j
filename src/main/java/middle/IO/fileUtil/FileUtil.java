package middle.IO.fileUtil;

import java.io.*;

/**
 * @author 谢子轩
 * @date 2021/09/14 11/06
 */
public class FileUtil {

    public static void main(String[] args) {
        String sourceFile = "/Users/xzx/Desktop/Ai-sql/section2.jpg";
        String targetPath = "/Users/xzx/Desktop/Ai-sql";
        copyFile(sourceFile, targetPath);
    }

    public static void copyFile(String sourceFile, String targetPath) {

        File in = new File(sourceFile);
        File out = new File(targetPath);
        if (!in.exists()) {
            System.out.println(in.getAbsolutePath() + "源文件路径错误！！！");
            return;
        } else {
            System.out.println("源文件路径" + in.getAbsolutePath());
            System.out.println("目标路径" + out.getAbsolutePath());
        }
        if (!out.exists()) {
            out.mkdirs();
        }
        //File[] file = in.listFiles();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(in);
            fos = new FileOutputStream(new File(targetPath + "\\" + in.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int c;
        byte[] b = new byte[1024 * 5];

        try {
            while ((c = fis.read(b)) != -1) {
                fos.write(b, 0, c);
            }

            fis.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;

    }
}
