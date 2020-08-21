package middle.IO;

import java.io.*;
import java.util.Objects;

/**
 * 以介质是硬盘为例，字节流和字符流的弊端：
 * 在每一次读写的时候，都会访问硬盘。 如果读写的频率比较高的时候，其性能表现不佳。
 * <p>
 * 为了解决以上弊端，采用缓存流。
 * 缓存流在读取的时候，会一次性读较多的数据到缓存中，以后每一次的读取，都是在缓存中访问，直到缓存中的数据读取完毕，再到硬盘中读取。
 * <p>
 * 就好比吃饭，不用缓存就是每吃一口都到锅里去铲。用缓存就是先把饭盛到碗里，碗里的吃完了，再到锅里去铲
 * <p>
 * 缓存流在写入数据的时候，会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。按照这种操作模式，就不会像字节流，字符流那样每写一个字节都访问硬盘，从而减少了IO操作
 *
 * @Author: xzx
 * @Date: 2020/8/14 4:20 下午
 **/
public class BufferStream {
    private static File file = new File("/Users/bjsl/Documents/ideaTest/bufferStream/garenAndTeemo.txt");
    private static File txt = new File("/Users/bjsl/Documents/ideaTest/bufferStream/teemoAndGaren.txt");
    private static File anno = new File("/Users/bjsl/Documents/ideaTest/bufferStream/annotation.txt");
    private static File non_anno = new File("/Users/bjsl/Documents/ideaTest/bufferStream/non_annotation.txt");


    public static void main(String[] args) {

//        bufferRead();
//        bufferWrite();

        flushBuffer();

        exercise();
    }


    /**
     * 缓存流必须建立在另外一个流上
     *
     * @Author: xzx
     * @Date: 2020/8/14 4:28 下午
     **/
    public static void bufferRead() {
        System.out.println("================= bufferRead  ======================");
        System.out.println(file.exists());
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

        ) {

            while (true) {
                String line = br.readLine();
                if (!Objects.nonNull(line))
                    break;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 缓存写入
     *
     * @Author: xzx
     * @Date: 2020/8/14 5:04 下午
     **/
    public static void bufferWrite() {
        System.out.println("================= bufferWrite  ======================");
        System.out.println("txt exist? : " + txt.exists());
        if (!txt.exists()) {
            txt.getParentFile().mkdirs();
            try {
                txt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 向文件lol2.txt中写入三行语句

        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(txt);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 minutes");
//            pw.println("teemo try to garen, but killed again");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * flush 可以立刻执行写入命令，而不是等到缓存满了再去执行
     *
     * @Author: xzx
     * @Date: 2020/8/15 2:17 下午
     **/
    public static void flushBuffer() {
        System.out.println("=================== flushBuffer ==============");

        System.out.println(txt.exists());
        try (
                FileWriter fw = new FileWriter(txt);
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println("fuck life ");
            pw.flush();
            pw.println("life fucked me");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对一个java文件删除注释
     *
     * @Author: xzx
     * @Date: 2020/8/15 2:23 下午
     **/
    public static void exercise() {
        System.out.println("==============  exercise  ===============");
        System.out.println("annotation exist ? " + anno);
        if(!non_anno.exists())
        {
            non_anno.getParentFile().mkdirs();
            try {
                non_anno.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        读一行判断一行写一行
        try (
                FileReader fr = new FileReader(anno);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(non_anno);
                PrintWriter pw = new PrintWriter(fw);
        ) {
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                if (!line.startsWith("//")) {
                    pw.println(line);
                    pw.flush();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
