/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;
import dao.SPDao;
import dao.util.Utility;
import java.util.*;
/**
 *
 * @author luctanbinh
 */
public class SPPojo {
    private int maSP;
    private String tenSP;
    private int maDM;
    private String moTa;
    private int soLuongTon;
    private float giaBan;
    private String hinhAnh;
    private String giaTien;
    private int soLuong;
    private Date ngayNhap;
    private int maKhuyenMai;

    public String getShortMoTa(){
        int l = 100;
        if(moTa.length() < l){
            l = moTa.length();
        }
        return moTa.substring(0, l);
    }

    public SPPojo(){
    
    }
    public SPPojo(int maDM, String tenSP, String moTa, float giaBan, String hinhAnh, int soLuong) {
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.giaBan = giaBan;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.maDM = maDM;
        this.ngayNhap = Calendar.getInstance().getTime();
    }
    /**
     * @return the maSP
     */
    public int getMaSP() {
        return maSP;
    }

    /**
     * @param maSP the maSP to set
     */
    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    /**
     * @return the tenSP
     */
    public String getTenSP() {
        return tenSP;
    }

    /**
     * @param tenSP the tenSP to set
     */
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    /**
     * @return the nhaSX
     */
    public int getMaDM() {
        return maDM;
    }

    /**
     * @param nhaSX the nhaSX to set
     */
    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the soLuongTon
     */
    public int getSoLuongTon() {
        return soLuongTon;
    }

    /**
     * @param soLuongTon the soLuongTon to set
     */
    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    /**
     * @return the giaBan
     */
    public float getGiaBan() {
        return giaBan;
    }

    /**
     * @param giaBan the giaBan to set
     */
    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    /**
     * @return the hinhAnh
     */
    public String getHinhAnh() {
        return hinhAnh;
    }

    /**
     * @param hinhAnh the hinhAnh to set
     */
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    /**
     * @return the giaTien
     */
    public String getGiaTien() {
        return Utility.toVND(this.giaBan);
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the ngayNhap
     */
    public Date getNgayNhap() {
        return ngayNhap;
    }

    /**
     * @param ngayNhap the ngayNhap to set
     */
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    /**
     * @return the maKhuyenMai
     */
    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    /**
     * @param maKhuyenMai the maKhuyenMai to set
     */
    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

}
