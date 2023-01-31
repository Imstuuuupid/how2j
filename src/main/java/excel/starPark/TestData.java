package excel.starPark;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author 谢子轩
 * @date 2021/10/26 11/43
 */
@Data
public class TestData {
    @ExcelProperty(value = "测试1")
    private String name;

    @ExcelProperty(value = "测试2")
    private String age;
}
