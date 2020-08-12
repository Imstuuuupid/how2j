package middle.IO;

import java.io.*;

/**
 * InputStream字节输入流
 * OutputStream字节输出流
 * 用于以字节的形式读取和写入数据
 *
 * @Author: xzx
 * @Date: 2020/8/11 7:47 下午
 **/
public class BinaryStream {

    private static File choose = new File("/Users/bjsl/Documents/ideaTest/lolo.txt");

    private static File txt = new File("/Users/bjsl/Documents/ideaTest/lol.txt");

    public static void main(String[] args) {
        outputStream();
        fileInStream();

        exerise1();
    }


    /**
     * InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
     * FileInputStream 是InputStream子类，以FileInputStream 为例进行文件读取
     *
     * @Author: xzx
     * @Date: 2020/8/11 7:53 下午
     **/
    public static void fileInStream() {
        System.out.println("=================  fileInStream  ===================");
        System.out.println(choose.exists());

        try {
            InputStream input = new FileInputStream(choose);

//            System.out.println("");
////            read()读取一个字符后，会有记录，下次一再读取时会自动后移，类似读取迭代器时的next
//            System.out.println(input.read());
//            System.out.println(input.read());
//            System.out.println("");

            System.out.println(choose.length());
            byte[] bytes = new byte[(int) choose.length()];
            int read = input.read(bytes);
            System.out.println(read);

            System.out.println();
            for (byte a : bytes)
                System.out.println(a);

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
     * FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据
     *
     * @Author: xzx
     * @Date: 2020/8/11 8:39 下午
     **/
    public static void outputStream() {
        System.out.println("=================  outputStream  ===================");

        System.out.println(choose.exists());
        if (!choose.getParentFile().exists())
            choose.mkdirs();
        try {
            OutputStream outputStream = new FileOutputStream(choose);
            byte[] bytes = new byte[]{14, 23, 54};
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 拆分文件:
     * 找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
     * 比如文件 eclipse.exe，大小是309k。
     * 拆分之后，成为
     * eclipse.exe-0
     * eclipse.exe-1
     * eclipse.exe-2
     * eclipse.exe-3
     *
     * @Author: xzx
     * @Date: 2020/8/11 8:48 下午
     **/
    public static void exerise1() {
        System.out.println("=============== exercise ====================");

        System.out.println(txt.length());
        long size = 102400;
        System.out.println(size);

        try {
            InputStream input = new FileInputStream(txt);
            byte[] red = new byte[(int) txt.length()];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
