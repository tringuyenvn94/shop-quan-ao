/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import dao.dondathangdao;
import dao.giohangdao;
import dao.util.Utility;
import java.util.ArrayList;

/**
 *
 * @author luctanbinh
 */
public class GioHangPojo {
    private ArrayList<ChiTietDonDatHangPojo> dsChiTiet;
    private float tongTien;

    public GioHangPojo(){
        dsChiTiet = new ArrayList<ChiTietDonDatHangPojo>();
        tongTien = 0;
    }
    

    /**
     * @return the dsChiTiet
     */
    public ArrayList<ChiTietDonDatHangPojo> getDsChiTiet() {
        return dsChiTiet;
    }

    /**
     * @param dsChiTiet the dsChiTiet to set
     */
    public void setDsChiTiet(ArrayList<ChiTietDonDatHangPojo> dsChiTiet) {
        this.dsChiTiet = dsChiTiet;
    }

    /**
     * @return the tongTien
     */
    public float getTongTien() {
        tongTien = 0;
        for(ChiTietDonDatHangPojo ct: dsChiTiet){
            tongTien += ct.getDonGia();
        }
        return tongTien;
    }
    
    public String getGiaTien(){
        return Utility.toVND(getTongTien());
    }

    /**
     * @param tongTien the tongTien to set
     */
    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
}
