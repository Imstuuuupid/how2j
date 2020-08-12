package middle.IO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * 关于文件处理的部分demo
 * @Author: xzx
 * @Date: 2020/8/11 7:16 下午
 **/
public class FileObject {
    public static void main(String[] args) {
        createFile();
        FileMethod1();
        FileMethod2();
        exercise1();
        exercise2();
    }

    /**
     * 使用绝对路径或相对路径创建File对象
     *
     * @Author: xzx
     * @Date: 2020/8/11 2:32 下午
     **/
    public static void createFile() {
        System.out.println("=============== createFile ========================");
//        绝对路径
        File f1 = new File("/Users/bjsl/Documents/ideaTest ");
        System.out.println("通过构造函数设置文件的绝对路径： " + f1.getAbsolutePath());
//        设置相对路径，获取绝对路径
        File f2 = new File("lol.exe");
        System.out.println("给构造函数设置相对路径，获取绝对路径：" + f2.getAbsolutePath());
//        利用已有的文件目录，创建文件路径
        File f3 = new File(f1, "lol.exe");
        System.out.println("在已有的文件目录基础上，创建文件路径，获取绝对路径： " + f3.getAbsolutePath());
    }

    /**
     * 创建的文件对象，如果给构造函数赋了初始值，
     * 那么这个文件路径就是确定了的，但它只是个路径，不能代表文件
     * 即，这是个映射关系，不是取出文件本身
     * <p>
     * 例子：
     * f 创建了一个文件路径，原来存在，
     * 后 有 f2 文件路径和名字，
     * 对 f 映射的文件修改了名字
     * 此时 f 路径不改变，但是原路径下的文件名被修改，f也就不存在了
     *
     * @Author: xzx
     * @Date: 2020/8/11 5:10 下午
     **/
    public static void FileMethod1() {
        System.out.println("====================  FileMethod1  ===================");
        File f = new File("/Users/bjsl/Documents/ideaTest/lol.txt");
        System.out.println("当前设置的文件为：" + f);
        System.out.println("存在？" + f.exists());
        System.out.println("文件夹？" + f.isFile());
        System.out.println("文件长度：" + f.length());

        Long time = f.lastModified();
        Date lastTime = new Date(time);
        System.out.println("文件最后的修改时间： " + lastTime);
//        修改最后修改时间
        Date now = new Date();
        System.out.println(now.getTime());
        f.setLastModified(now.getTime());
        System.out.println("文件最后的修改时间： " + f.lastModified());


        File f2 = new File("lolo.txt");
        System.out.println("文件的名字： " + f2);
        boolean b = f.renameTo(f2.getAbsoluteFile());
        System.out.println(b);
        System.out.println("把lol改成了lolo");
        System.out.println(f2.exists());

        System.out.println(f.exists());
    }


    /**
     * @Author: xzx
     * @Date: 2020/8/11 5:31 下午
     **/
    public static void FileMethod2() {
        System.out.println("================  FileMethod2  ===========================");
        File f = new File("/Users/bjsl/Documents/ideaTest/garen/position");
//        mkdir 此方法，如果要创建的文件 父文件夹不存在，就false，存在 就会创建目标文件夹
        System.out.println(f.mkdir());
//        mkdirs 此方法 会创建此路径，包括父文件夹
        boolean mkdirs = f.mkdirs();
        System.out.println(mkdirs);
//        返回文件夹下所有文件
        System.out.println(Arrays.toString(f.list()));

//        以下两种方法都会返回父文件夹路径，但一个是以字符串形式，一个是以文件形式
        String parent = f.getParent();
        File parentFile = f.getParentFile();
        System.out.println("getParent： " + parent);
        System.out.println("getParentFile： " + parentFile);
        System.out.println();
        System.out.println("此时f的父文件夹下包含的文件为：" + Arrays.toString(f.getParentFile().listFiles()));

        System.out.println();

//        此方法执行时，会创建一个空文件，没有父文件夹就会抛出异常，所以需要捕捉
//        所以可以在创建空文件之前，先对其父文件夹创建一遍
        boolean mkdirs1 = f.getParentFile().mkdirs();
        System.out.println("f.getParentFile().mkdirs() : " + mkdirs1);
        try {
            f = new File("/Users/bjsl/Documents/ideaTest/garen/equipments");
            boolean newFile = f.createNewFile();
            System.out.println("创建文件：  createNewFile: " + newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("列出所有盘符号： f.listRoots: " + Arrays.toString(f.listRoots()));
        System.out.println("f此时所表示的文件为 :  " + f);
        System.out.println();
        System.out.println("此时f的父文件夹下包含的文件为：" + Arrays.toString(f.getParentFile().listFiles()));

        System.out.println("删除文件： f.delete(): " + f.delete());
        System.out.println();
        System.out.println("此时f的父文件夹下包含的文件为：" + Arrays.toString(f.getParentFile().listFiles()));

//        JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();

    }


    /**
     * 遍历一个文件夹，找出文件夹下长度最大和最小的文件名
     *
     * @Author: xzx
     * @Date: 2020/8/11 5:51 下午
     **/
    public static void exercise1() {
        System.out.println("===============  exercise1  =================");
        File user = new File("/Users/bjsl");
        System.out.println("选择的文件夹为：" + user);
        File[] files = user.listFiles();
        long minLen = 5;
        File minFile = null;
        long maxLen = 10;
        File maxFile = null;
        for (File a : files) {
            if (a.length() < minLen) {
                minLen = a.length();
                minFile = a;
            }
            if (a.length() > maxLen) {
                maxLen = a.length();
                maxFile = a;
            }
        }

        System.out.println("长度最短文件为：" + minFile);
        System.out.println("长度为：" + minLen);
        System.out.println("长度最长文件为：" + maxFile);
        System.out.println("长度为：" + maxLen);


    }

    private static long minlen = 5;
    private static long maxlen = 10;
    private static File minFile;
    private static File maxFile;


    /**
     * 遍历一个文件下所有文件夹，包括子文件夹
     *
     * @Author: xzx
     * @Date: 2020/8/11 6:54 下午
     **/
    public static void exercise2() {
        System.out.println("================ exercise2 ==================");
        File choose = new File("/Users/bjsl/IdeaProjects");
        System.out.println(choose.exists());
        traverse(choose);
        System.out.println("长度最短文件为：" + minFile);
        System.out.println("长度为：" + minlen);
        System.out.println("长度最长文件为：" + maxFile);
        System.out.println("长度为：" + maxlen);
    }

    private static void traverse(File file) {
        if (file != null && file.exists() && file.length() > 0) {
            File[] files = file.listFiles();
            for (File a : files) {
                if (a.exists() && !a.isFile()) {
                    traverse(a);
                }
                if (a.length() > maxlen) {
                    maxFile = a;
                    maxlen = a.length();
                }
                if (a.length() < minlen) {
                    minFile = a;
                    minlen = a.length();
                }
            }
        }
    }
}
