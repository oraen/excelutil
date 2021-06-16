package entity;

import com.oraen.oxygen.common.design.workstation.node.Check;
import com.oraen.oxygen.excelutil.SheetEntity;
import com.oraen.oxygen.excelutil.SheetField;





@SheetEntity
public class Cell {


    private Integer id;

    @SheetField("工单号")
    @Check(necessity = true)
    private String workOrder;

    @SheetField("物料编码")
    @Check(necessity = true)
    private String materialCode;

    @SheetField("电池条码")
    @Check(unique=true, necessity = true)
    private String barCode;

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

    @SheetField("状态")
    private String status;

    private String rkTime;

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

    private String zcTime;

    private String vendor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Float getFdrl() {
        return fdrl;
    }

    public void setFdrl(Float fdrl) {
        this.fdrl = fdrl;
    }

    public String getHlb() {
        return hlb;
    }

    public void setHlb(String hlb) {
        this.hlb = hlb;
    }

    public Float getZhcdl() {
        return zhcdl;
    }

    public void setZhcdl(Float zhcdl) {
        this.zhcdl = zhcdl;
    }

    public Float getKldy() {
        return kldy;
    }

    public void setKldy(Float kldy) {
        this.kldy = kldy;
    }

    public Float getNz() {
        return nz;
    }

    public void setNz(Float nz) {
        this.nz = nz;
    }

    public Float getZfd() {
        return zfd;
    }

    public void setZfd(Float zfd) {
        this.zfd = zfd;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRkTime() {
        return rkTime;
    }

    public void setRkTime(String rkTime) {
        this.rkTime = rkTime;
    }

    public Float getHcrl() {
        return hcrl;
    }

    public void setHcrl(Float hcrl) {
        this.hcrl = hcrl;
    }

    public Float getFrrl() {
        return frrl;
    }

    public void setFrrl(Float frrl) {
        this.frrl = frrl;
    }

    public Float getFrhlb() {
        return frhlb;
    }

    public void setFrhlb(Float frhlb) {
        this.frhlb = frhlb;
    }

    public Float getFrptb() {
        return frptb;
    }

    public void setFrptb(Float frptb) {
        this.frptb = frptb;
    }

    public String getOcv1_sj() {
        return ocv1_sj;
    }

    public void setOcv1_sj(String ocv1_sj) {
        this.ocv1_sj = ocv1_sj;
    }

    public Float getOcv1_dy() {
        return ocv1_dy;
    }

    public void setOcv1_dy(Float ocv1_dy) {
        this.ocv1_dy = ocv1_dy;
    }

    public Float getOcv1_nz() {
        return ocv1_nz;
    }

    public void setOcv1_nz(Float ocv1_nz) {
        this.ocv1_nz = ocv1_nz;
    }

    public String getOcv2_sj() {
        return ocv2_sj;
    }

    public void setOcv2_sj(String ocv2_sj) {
        this.ocv2_sj = ocv2_sj;
    }

    public Float getOcv2_dy() {
        return ocv2_dy;
    }

    public void setOcv2_dy(Float ocv2_dy) {
        this.ocv2_dy = ocv2_dy;
    }

    public Float getOcv2_nz() {
        return ocv2_nz;
    }

    public void setOcv2_nz(Float ocv2_nz) {
        this.ocv2_nz = ocv2_nz;
    }

    public Float getFjyzjkd() {
        return fjyzjkd;
    }

    public void setFjyzjkd(Float fjyzjkd) {
        this.fjyzjkd = fjyzjkd;
    }

    public String getZcTime() {
        return zcTime;
    }

    public void setZcTime(String zcTime) {
        this.zcTime = zcTime;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}