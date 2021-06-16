package entity;




import com.oraen.oxygen.excelutil.SheetEntity;
import com.oraen.oxygen.excelutil.SheetField;


@SheetEntity
public class StockData {

    @SheetField("工单号")
    private String gdh;

    @SheetField("物料编码")
    private String wlbm;

    @SheetField("电池条码")
    private String dctm;

    @SheetField("放电容量Ah")
    private Float fdrl;

    @SheetField("恒流比")
    private String hlb;

    @SheetField("最后充电量Ah")
    private Float zhcdl;

    @SheetField("开路电压②V")
    private Float kldy;

    @SheetField("内阻②mΩ")
    private Float nz;

    @SheetField("自放电KmV/Day")
    private Float zfd;

    @SheetField("档位")
    private String dw;

    @SheetField("箱号")
    private String xh;

    private String status;

    private String write_time;

    private String rzm;

}
