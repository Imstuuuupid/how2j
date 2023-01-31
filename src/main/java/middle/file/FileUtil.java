package middle.file;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图片尺寸裁剪工具
 *
 * @author 谢子轩
 * @date 2021/10/09 10/12
 */
@Slf4j
public class FileUtil {
//    切图参考
//    https://blog.csdn.net/u010355502/article/details/77197616

    private static String File_DIC = "/Users/xzx/Desktop";

    public static void main(String[] args) throws Exception {
        File file = new File("temp.jpg");
        String fileName = file.getName();
//        转byte 转bufferedImage
        byte[] bytes = fileToByte(file);
        BufferedImage bufferedImage = bytesToBufferedImage(bytes);
//        切图
        BufferedImage bufferedImage1 = resizeImageOne(bufferedImage, 1024, 1024);
//        转byte 转file
        byte[] bytes1 = imageToBytes(bufferedImage1);
        File file1 = ByteToFile(bytes1, File_DIC, fileName);
//        返回图片位置
        System.out.println(file1.getAbsolutePath());
    }

    /**
     * 通过BufferedImage图片流调整图片大小
     */
    public static BufferedImage resizeImageOne(BufferedImage originalImage, int targetWidth, int targetHeight) throws Exception {

        int originWidth = originalImage.getWidth();
        int originHeight = originalImage.getHeight();
        System.out.println("原始图片大小：width:" + originWidth + "，height:" + originHeight);
        System.out.println(originWidth/originHeight);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(originalImage)
                .size(targetWidth, targetHeight)
                .outputFormat("JPEG")
                .toOutputStream(outputStream);
        byte[] data = outputStream.toByteArray();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        BufferedImage read = ImageIO.read(inputStream);
        System.out.println("切割后width:" + read.getWidth() + "，height:" + read.getHeight());
        System.out.println(read.getWidth()/read.getHeight());
        return read;
    }

    /**
     * BufferedImage图片流转byte[]数组
     */
    public static byte[] imageToBytes(BufferedImage bImage) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "jpg", out);
        } catch (IOException e) {
            log.error("错误信息: ", e);
        }
        return out.toByteArray();
    }

    /**
     * byte[]数组转BufferedImage图片流
     */
    private static BufferedImage bytesToBufferedImage(byte[] ImageByte) {
        ByteArrayInputStream in = new ByteArrayInputStream(ImageByte);
        BufferedImage image = null;
        try {
            image = ImageIO.read(in);
        } catch (IOException e) {
            log.error("错误信息: ", e);
        }
        return image;
    }

    public static byte[] fileToByte(File file) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static File ByteToFile(byte[] bytes, String filePath, String fileName) throws Exception {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            // 判断文件目录是否存在
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file = new File(filePath + "/" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

}
