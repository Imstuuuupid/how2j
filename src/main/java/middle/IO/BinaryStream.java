package middle.IO;

import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.Arrays;

/**
 * InputStream字节输入流
 * OutputStream字节输出流
 * 用于以字节的形式读取和写入数据
 *
 * @Author: xzx
 * @Date: 2020/8/11 7:47 下午
 **/
public class BinaryStream {

    private static File choose = new File("/Users/bjsl/Documents/ideaTest/binaryStream/lol.txt");

    private static File txt = new File("/Users/bjsl/Documents/ideaTest/lol.txt");

    public static void main(String[] args) {
        outputStream();
        fileInStream();

//        exerise1();
//        exercise2();
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
        InputStream input = null;
        try {
            input = new FileInputStream(choose);

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


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
     * <p>
     * 思路：
     * 先读出全部文件，再进行写入新文件
     *
     * @Author: xzx
     * @Date: 2020/8/11 8:48 下午
     **/
    public static void exerise1() {
        System.out.println("=============== exercise1 ====================");
//        获取父文件夹
        File dic = new File(String.valueOf(txt.getParentFile().getAbsoluteFile()));
        System.out.println(txt.length());
        long size = 102400;
        System.out.println(size);
        InputStream input = null;
        OutputStream output = null;
        byte[] all = new byte[(int) txt.length()];

//        读取出全部
        try {
            input = new FileInputStream(txt);
            input.read(all);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

//        给出写入文件
        File path = new File(dic, "result");
        System.out.println(path);

//        循环写入
        for (int i = 1; i <= txt.length() / size + 1; i++) {
            String str = i + ".txt";
            File temp = new File(path, str);
            temp.getParentFile().mkdirs();
            try {
                System.out.println("创建文件：" + temp.createNewFile());
                output = new FileOutputStream(temp);
                output.write(all, (i - 1) * (int) size, (int) (Math.min(size, txt.length() - (i - 1) * size)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("文件名：" + temp.getName());
            System.out.println("文件长度： " + temp.length());
        }

    }

    /**
     * 合并上述文件
     * <p>
     * 思路：
     * 读取全部文件到一个byte[]中，然后写入合并文件
     *
     * @Author: xzx
     * @Date: 2020/8/12 10:46 上午
     **/
    public static void exercise2() {
        System.out.println("=============== exercise2 ====================");

        File from = new File("/Users/bjsl/Documents/ideaTest/result");
        System.out.println("存在from ？：" + from.exists());
        File to = new File("/Users/bjsl/Documents/ideaTest/binaryStream/merge.txt");
        System.out.println("存在to ？：" + from.exists());

        int size = 0;
        for (File a : from.listFiles()) {
            size += a.length();
        }
        byte[] merge = new byte[0];

//        循环读取文件
        File[] files = from.listFiles();
        for (File a : files) {
            byte[] tmp = new byte[(int) a.length()];
            try (InputStream input = new FileInputStream(a)) {
                input.read(tmp);
                merge = ArrayUtils.addAll(tmp, merge);
                System.out.println("res的长度： " + tmp.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        写入
        try (OutputStream output = new FileOutputStream(to)) {
            if (to.exists()) {
                boolean delete = to.delete();
                System.out.println(delete);
            }
            if (!to.exists()) {
                to.getParentFile().mkdirs();
            }
            output.write(merge);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("to的名字： " + to.getAbsolutePath());
        System.out.println("to的长度： " + to.length());
    }
}
