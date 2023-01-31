package excel.starPark;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * @author 谢子轩
 * @date 2021/10/26 11/43
 */


public class TestListener extends AnalysisEventListener<TestListener> {
    @Override
    public void invoke(TestListener data, AnalysisContext context) {
        System.out.println(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println(context);
        System.out.println(context.readSheetList());
    }
}
