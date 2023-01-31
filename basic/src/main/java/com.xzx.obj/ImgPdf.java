package com.xzx.obj;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 图片转换PDF类
 */
public class ImgPdf {
    /**
     * 将图片转换成PDF
     *
     * @param sonFile 文件夹路径
     * @param target  PDF的名字和位置
     */
    public static void ImgChangePDF(File sonFile, String target) throws Exception {
        //创建一个文档对象
        Document doc = new Document();
        //定义输出文件的位置
        PdfWriter.getInstance(doc, new FileOutputStream(target));
        //开启文档
        doc.open();
        // 循环获取图片文件夹内的图片
        File[] files = sonFile.listFiles();
        for (File file : files) {
            if (file == null || isNotPic(file.getName())) {
                break;
            }
            //路径
            Image img = Image.getInstance(file.getAbsolutePath());
            //获得宽高
            Float h = img.getHeight();
            Float w = img.getWidth();
            //统一压缩
            Integer percent = getPercent(h, w);
            //图片居中
            img.setAlignment(Image.MIDDLE);
            //百分比显示图
            img.scalePercent(percent);
            //设置高和宽的比例
            doc.add(img);
        }
        // 关闭文档
        if (doc != null) {
            doc.close();
        }
    }

    private static boolean isNotPic(String fileName) {
        return !(fileName.contains("jpg") || fileName.contains("png"));
    }

    /**
     * 压缩
     *
     * @param
     */
    public static Integer getPercent(Float h, Float w) {
        Integer g = 0;
        Float g2 = 0.0f;
        g2 = 480 / w * 100;
        g = Math.round(g2);
        return g;
    }
}

