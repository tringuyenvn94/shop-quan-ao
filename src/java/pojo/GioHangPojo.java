/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import dao.dondathangdao;
import dao.giohangdao;
import java.util.ArrayList;

/**
 *
 * @author luctanbinh
 */
public class GioHangPojo {
    private DonDatHangPojo donDatHang;
    private ArrayList<ChiTietDonDatHangPojo> dsChiTiet;
    private float tongTien;

    public GioHangPojo(){
        donDatHang = new DonDatHangPojo();
        dsChiTiet = new ArrayList<ChiTietDonDatHangPojo>();
        tongTien = 0;
    }
    public GioHangPojo(KhachHangPojo user){
        donDatHang = new DonDatHangPojo();
        if(user != null){
         donDatHang.setMaKhachHang(user.getTenDangNhap());
         donDatHang.setMaDonDatHang(dondathangdao.layMa());
        }
        dsChiTiet = new ArrayList<ChiTietDonDatHangPojo>();
        tongTien = 0;
    }
    /**
     * @return the donDatHang
     */
    public DonDatHangPojo getDonDatHang() {
        return donDatHang;
    }

    /**
     * @param donDatHang the donDatHang to set
     */
    public void setDonDatHang(DonDatHangPojo donDatHang) {
        this.donDatHang = donDatHang;
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
        return tongTien;
    }

    /**
     * @param tongTien the tongTien to set
     */
    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
}
