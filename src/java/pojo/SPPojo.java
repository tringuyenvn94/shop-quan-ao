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
    private int nhaSX;
    private String moTa;
    private int soLuongTon;
    private float giaBan;
    private String hinhAnh;
    private String tenNhaSX;
    private String giaTien;
    private int soLuong;

    
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
    public int getNhaSX() {
        return nhaSX;
    }

    /**
     * @param nhaSX the nhaSX to set
     */
    public void setNhaSX(int nhaSX) {
        this.nhaSX = nhaSX;
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
     * @return the tenNhaSX
     */
    public String getTenNhaSX() {
        return SPDao.layTenNhaSanXuat(this.nhaSX);
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

}
