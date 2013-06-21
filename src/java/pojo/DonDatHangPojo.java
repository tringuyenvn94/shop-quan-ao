/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luctanbinh
 */
public class DonDatHangPojo {

    private int maDonDatHang;
    private Date ngayDatHang;
    private Date ngayGiaoHang;
    private String maKhachHang;
    private float giaTri;
    private int maTinhTrang;
    private String tenNguoiNhan;
    private String soDTNguoiNhan;
    private String diaChiNguoiNhan;
    
    public DonDatHangPojo() {
        //Lay gio he thong
//        Date todayD = new Date(System.currentTimeMillis());
//
//        //Khai bao dinh dang ngay thang
//        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//        //parse ngay thang sang dinh dang va chuyen thanh string.
//        ngayDatHang = dayFormat.format(todayD.getTime());
        Calendar c = Calendar.getInstance();
        ngayDatHang = c.getTime();
        maTinhTrang = 1;
    }

    public DonDatHangPojo(String maKhachHang, float giaTri, String tenNguoiNhan, String soDTNguoiNhan, String diaChiNguoiNhan) {
        this.maKhachHang = maKhachHang;
        this.giaTri = giaTri;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDTNguoiNhan = soDTNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        Calendar c = Calendar.getInstance();
        ngayDatHang = c.getTime();
        maTinhTrang = 1;
    }

    /**
     * @return the maDonDatHang
     */
    public int getMaDonDatHang() {
        return maDonDatHang;
    }

    /**
     * @param maDonDatHang the maDonDatHang to set
     */
    public void setMaDonDatHang(int maDonDatHang) {
        this.maDonDatHang = maDonDatHang;
    }

    /**
     * @return the ngayDatHang
     */
    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    /**
     * @param ngayDatHang the ngayDatHang to set
     */
    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    /**
     * @return the maKhachHang
     */
    public String getMaKhachHang() {
        return maKhachHang;
    }

    /**
     * @param maKhachHang the maKhachHang to set
     */
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    /**
     * @return the maTinhTrang
     */
    public int getMaTinhTrang() {
        return maTinhTrang;
    }

    /**
     * @param maTinhTrang the maTinhTrang to set
     */
    public void setMaTinhTrang(int maTinhTrang) {
        this.maTinhTrang = maTinhTrang;
    }

    /**
     * @return the ngayGiaoHang
     */
    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    /**
     * @param ngayGiaoHang the ngayGiaoHang to set
     */
    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    /**
     * @return the donGia
     */
    public float getGiaTri() {
        return giaTri;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setGiaTri(float donGia) {
        this.giaTri = donGia;
    }

    /**
     * @return the tenNguoiNhan
     */
    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    /**
     * @param tenNguoiNhan the tenNguoiNhan to set
     */
    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    /**
     * @return the soDTNguoiNhan
     */
    public String getSoDTNguoiNhan() {
        return soDTNguoiNhan;
    }

    /**
     * @param soDTNguoiNhan the soDTNguoiNhan to set
     */
    public void setSoDTNguoiNhan(String soDTNguoiNhan) {
        this.soDTNguoiNhan = soDTNguoiNhan;
    }

    /**
     * @return the diaChiNguoiNhan
     */
    public String getDiaChiNguoiNhan() {
        return diaChiNguoiNhan;
    }

    /**
     * @param diaChiNguoiNhan the diaChiNguoiNhan to set
     */
    public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
        this.diaChiNguoiNhan = diaChiNguoiNhan;
    }
}
