package entity;


import com.oraen.oxygen.excelutil.annotation.SheetEntity;
import com.oraen.oxygen.excelutil.annotation.SheetField;




@SheetEntity
public class ProcessData {

    @SheetField("工单号")
    private String gdh;

    @SheetField("物料编码")
    private String wlbm;

    @SheetField("电池条码")
    private String dctm;

    @SheetField("化成容量Ah")
    private Float hcrl;

    @SheetField("分容容量Ah")
    private Float frrl;

    @SheetField("分容恒流比")
    private Float frhlb;

    @SheetField("分容平台比")
    private Float frptb;

    @SheetField("OCV1-时间")
    private String ocv1_sj;

    @SheetField("OCV1-电压V")
    private Float ocv1_dy;

    @SheetField("OCV1-内阻mΩ")
    private Float ocv1_nz;

    @SheetField("OCV2-时间")
    private String ocv2_sj;

    @SheetField("OCV2-电压V")
    private Float ocv2_dy;

    @SheetField("OCV2-内阻mΩ")
    private Float ocv2_nz;

    @SheetField("负极与正极壳电V")
    private Float fjyzjkd;

    @SheetField("自放电KmV/Day")
    private Float zfd;

    private String write_time;

    private String rzm;



}
