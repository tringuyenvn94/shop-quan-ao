/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luctanbinh
 */
public class DonDatHangPojo {

    private int maDonDatHang;
    private String ngayDatHang;
    private String ngayGiaoHang;
    private String maKhachHang;
    private float giaTri;
    private int maTinhTrang;

    public DonDatHangPojo() {
        //Lay gio he thong
        Date todayD = new Date(System.currentTimeMillis());

        //Khai bao dinh dang ngay thang
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");

        //parse ngay thang sang dinh dang va chuyen thanh string.
        ngayDatHang = dayFormat.format(todayD.getTime());
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
    public String getNgayDatHang() {
        return ngayDatHang;
    }

    /**
     * @param ngayDatHang the ngayDatHang to set
     */
    public void setNgayDatHang(String ngayDatHang) {
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
    public String getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    /**
     * @param ngayGiaoHang the ngayGiaoHang to set
     */
    public void setNgayGiaoHang(String ngayGiaoHang) {
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
}
