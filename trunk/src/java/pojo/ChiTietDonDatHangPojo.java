/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import dao.util.Utility;

/**
 *
 * @author luctanbinh
 */
public class ChiTietDonDatHangPojo {
    private int maChiTiet;
    private int maDonDatHang;
    private int maSP;
    private int soLuong;
    private float donGia;

    /**
     * @return the maChiTiet
     */
    public int getMaChiTiet() {
        return maChiTiet;
    }

    /**
     * @param maChiTiet the maChiTiet to set
     */
    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
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
    
    public String getGiaTien(){
        return Utility.toVND(donGia);
    }

    /**
     * @return the donGia
     */
    public float getDonGia() {
        return donGia;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
}
