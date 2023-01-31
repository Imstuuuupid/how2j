package excel.starPark;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

/**
 * @author 谢子轩
 * @date 2021/10/25 14/25
 */

public class ReadExcel {

    public static void main(String[] args) throws Exception {

    }

    @Test
    public void filePath(){
        String a = "temp.txt";
        File file = new File(a);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void read(){
        String fileName = "/Users/xzx/Desktop/test.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        TestListener cardListener = new TestListener();
        EasyExcel.read(fileName, TestData.class, cardListener).sheet().doRead();
    }




    @Test
    public void simpleRead() {
//        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
//        // 写法1：
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
//
//        // 写法2：
//        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        ExcelReader excelReader = null;
//        try {
//            excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            excelReader.read(readSheet);
//        } finally {
//            if (excelReader != null) {
//                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//                excelReader.finish();
//            }
//        }
    }

}
