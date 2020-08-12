package middle.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 建立文件输入输出流
 *
 * inputStream :  流向是 从 硬盘-》内存  故可以读取文件内容输出到控制台中
 * outputStream : 同理
 *
 * @Author: xzx
 * @Date: 2020/8/11 7:17 下午
 **/
public class FileStream {
    public static void main(String[] args) {
        fileInStream();
        fileOutStream();
    }

    /**
     * 建立文件输入流，没有输入，只是建立
     *
     * @Author: xzx
     * @Date: 2020/8/11 7:33 下午
     **/
    public static void fileInStream() {
        System.out.println("=============  fileInStream  ===================");
//        新建 File 对象的时候，字符串开始位置不能有空格
        File f = new File("/Users/bjsl/Documents/ideaTest/lolo.txt");
        System.out.println(f.exists());
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
//            通过这个流，可以把数据从硬盘读取到java虚拟机内，也就是内存中
            FileInputStream in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 建立文件输出流
     * @Author: xzx
     * @Date: 2020/8/11 7:40 下午
     **/
    public static void fileOutStream() {
        System.out.println("=============  fileOutStream  ===================");
        File f = new File("/Users/bjsl/Documents/ideaTest/lolo.txt");
        System.out.println(f.exists());
    }
}
