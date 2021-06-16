package entity;

import com.oraen.oxygen.excelutil.SheetEntity;
import com.oraen.oxygen.excelutil.SheetField;

@SheetEntity
public class WUliao {

    @SheetField("工单号")
    private String gdh;

    @SheetField("工厂")
    private Integer gc;

    @SheetField("线体")
    private String xt;

    @SheetField("物料名称")
    private String wlmc;

    @SheetField("价格")
    private Float jg;
}
