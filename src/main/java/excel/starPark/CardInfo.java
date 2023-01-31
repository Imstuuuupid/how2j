package excel.starPark;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 卡片信息
 *
 * @author 谢子轩
 * @date 2021/10/25 14/15
 */
@Data
public class CardInfo {

    @ExcelProperty(value = "卡片id")
    private Integer id;

    @ExcelProperty(value = "卡片名称")
    private String name;

    @ExcelProperty(value = "卡片等级")
    private String grade;

    @ExcelProperty(value = "攻击魔王血量")
    private Integer price;

    @ExcelProperty(value = "收集次数")
    private Integer collectTimes;

    @ExcelProperty(value = "卡片对应知识点")
    private String knowledge;
}
