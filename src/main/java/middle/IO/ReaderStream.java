package middle.IO;

import java.io.*;
import java.util.Arrays;

/**
 * Reader字符输入流
 * Writer字符输出流
 * 专门用于字符的形式读取和写入数据
 * 字符流：char[]
 *
 * @Author: xzx
 * @Date: 2020/8/12 2:20 下午
 **/
public class ReaderStream {
    private static File lolo = new File("/Users/bjsl/Documents/ideaTest/lolo.txt");

    private static File ingFile = new File("/Users/bjsl/Documents/ideaTest/encode/encoding.txt");
    private static File edFile = new File("/Users/bjsl/Documents/ideaTest/encode/encoded.txt");

    public static void main(String[] args) {
        System.out.println("encodingFile: " + ingFile.exists());
        System.out.println("encodedFile: " + edFile.exists());
        encodeFile(ingFile, edFile);
//        writeWriter();
//        readerRead();
    }

    /**
     * FileReader 是Reader子类，
     * 以FileReader 为例进行文件读取
     *
     * @Author: xzx
     * @Date: 2020/8/12 2:40 下午
     **/
    public static void readerRead() {
        System.out.println("================== readerRead ======================");
        System.out.println(lolo.exists());
        char[] chars = new char[(int) lolo.length()];
        try (Reader reader = new FileReader(lolo)) {
            reader.read(chars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (char a : chars) {
            System.out.println(a);
        }
        System.out.println(Arrays.toString(chars));
    }

    /**
     * FileWriter 是Writer的子类，
     * 以FileWriter 为例把字符串写入到文件
     *
     * @Author: xzx
     * @Date: 2020/8/12 2:59 下午
     **/
    public static void writeWriter() {
        System.out.println("================== writeWriter ======================");
        System.out.println(lolo.exists());

        char[] chars = new char[]{'A', 'V', 'E', 'G', 'D'};
        try (Writer writer = new FileWriter(lolo)) {
            writer.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void encodeFile(File encodingFile, File encodedFile) {
        System.out.println("================== encodeFile ======================");
        char[] encoding = new char[(int) encodingFile.length()];
        System.out.println("encodingFile.length(): " + encodingFile.length());

//        读取内容
        try (Reader reader = new FileReader(encodingFile)) {
            reader.read(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("加密之前内容为： ");
        for (char a : encoding)
            System.out.print(a + " ");

//        加密  写入
        try (Writer writer = new FileWriter(encodedFile)) {
            for (char a : encoding) {
                char encod = encod(a);
                writer.write(encod);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        读取内容
        try (Reader reader = new FileReader(encodedFile)) {
            reader.read(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("加密之后的内容为： ");
        for (char a : encoding)
            System.out.print(a + " ");
    }

    private static char encod(char a) {
        if ('b' <= a && a <= 'z') {
            a--;
        } else if ('B' <= a && 'Z' >= a) {
            a--;
        } else if ('1' <= a && '8' >= a) {
            a++;
        } else if (a == '9') {
            a = '0';
        } else if ('A' == a) {
            a = 'Z';
        } else if ('a' == a) {
            a = 'z';
        }
        return a;
    }


}
