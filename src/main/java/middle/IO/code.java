package middle.IO;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * 编码中的中文
 * @Author: xzx
 * @Date: 2020/8/12 6:07 下午
 **/
public class code {

    public static void main(String[] args) {
        String str = "中";
        showCode(str);

        fileInputChinese();
    }

    private static void showCode(String str) {
        String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
        for (String encode : encodes) {
            showCode(str, encode);
        }

    }

    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b & 0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }



    /**
     * 为了能够正确的读取中文内容
     * 1. 必须了解文本是以哪种编码方式保存字符的
     * 2. 使用字节流读取了文本后，再使用对应的编码方式去识别这些数字，得到正确的字符
     * 如本例，一个文件中的内容是字符中，编码方式是GBK，那么读出来的数据一定是D6D0。
     * 再使用GBK编码方式识别D6D0，就能正确的得到字符中
     * @Author: xzx
     * @Date: 2020/8/14 2:54 下午
     **/
    public static void fileInputChinese()
    {
        System.out.println("=================== fileInputChinese  =====================");
        File txt = new File("/Users/bjsl/Documents/ideaTest/codeType.txt");


    }



}
