package excel.starPark;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 谢子轩
 * @date 2021/10/25 14/18
 */
public class CardListener extends AnalysisEventListener<CardInfo> {

    //每隔5条数据存储数据库，实际使用中可以使用3000条，然后清理list，方便内存回收
    private static final int BATCH_COUNT = 5;

    List<CardInfo> list = new ArrayList<>();

    @Override
    public void invoke(CardInfo data, AnalysisContext context) {
        list.add(data);
        //达到BATCH_COUNT之后，需要去存储一次数据库，防止数据几万条数据在内容，容易OOM
        if(list.size() >= BATCH_COUNT){
            saveData();
            //存储完成之后清理list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //这里也要保存一下数据，确保最后遗留的数据也存储到数据库
        saveData();
    }

    private void saveData(){
        /*
        打印读取到的excel内容
         */
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

}
