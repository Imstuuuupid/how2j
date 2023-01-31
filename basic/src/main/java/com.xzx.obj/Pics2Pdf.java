package com.xzx.obj;

import java.io.File;
import java.util.Scanner;

/**
 * 文件图片批量转换pdf
 *
 * @author 谢子轩
 * @date 2023/01/31 15/37
 */

public class Pics2Pdf {
    public static void main(String[] args) {

        String rootPath = "/Users/xzx/IdeaProjects/学习demo/基础学习/picTest";

        String outPath = "/Users/xzx/IdeaProjects/学习demo/基础学习/traget";

        interaction(rootPath, outPath);
        deal(rootPath, outPath);

    }

    public static void interaction(String r, String t) {
        System.out.println("请输入父文件夹绝对路径：（文件结构如：父文件夹--子文件夹--图片）");
        Scanner scanner = new Scanner(System.in);
        String rootPath = scanner.next();
        System.out.println();
        System.out.println("请输入输出文件夹绝对路径：（输出结构如：输出文件夹--pdf文件）");
        String targetPath = scanner.next();
        r = rootPath;
        t = targetPath;
    }

    public static void deal(String rootPath, String outPath) {
//        获取父文件夹
        File rootFile = new File(rootPath);
//        遍历父文件夹内容
        boolean exists = rootFile.exists();
        if (!exists) {
            System.exit(1);
        }
//        遍历子文件夹
        File[] rootFiles = rootFile.listFiles();
        System.out.println("待处理子文件夹数量：" + rootFiles.length);
        int count = 0;
        for (File sonFile : rootFiles) {
            System.out.println("当前正在处理：" + count++);
            if (!sonFile.exists() || !sonFile.isDirectory()) {
                continue;
            }
            File[] files = sonFile.listFiles();
//            子文件处理
            String target = outPath + "/" + sonFile.getName();
            try {
                ImgPdf.ImgChangePDF(sonFile, target);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("处理失败文件： " + sonFile.getAbsolutePath() + "，序列：" + count);

            }
        }
        System.out.println("finish");
    }

}
