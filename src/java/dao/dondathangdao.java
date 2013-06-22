/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import dao.util.Utility;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.DonDatHangPojo;
import pojo.GioHangPojo;

/**
 *
 * @author luctanbinh
 */
public class dondathangdao {
    public static DonDatHangPojo layDonHang(int ma){
        DonDatHangPojo don = new DonDatHangPojo();
        try {
            String sql = String.format("select * from DonDatHang where MaDonDatHang=%d",ma);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                don.setMaDonDatHang(rs.getInt("MaDonDatHang"));
                don.setMaKhachHang(rs.getString("MaKhachHang"));
                don.setMaTinhTrang(rs.getInt("MaTinhTrang"));
                don.setNgayDatHang(rs.getDate("NgayDatHang"));
                don.setNgayGiaoHang(rs.getDate("NgayGiao"));
                don.setGiaTri(rs.getFloat("GiaTri"));
                
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return don;
    }
    public static DonDatHangPojo layDonHang(String maKhachHang){
        DonDatHangPojo don = new DonDatHangPojo();
        try {
            String sql = String.format("select * from DonDatHang where MaKhachHang='%s'",maKhachHang);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                don.setMaDonDatHang(rs.getInt("MaDonDatHang"));
                don.setMaKhachHang(rs.getString("MaKhachHang"));
                don.setMaTinhTrang(rs.getInt("MaTinhTrang"));
                don.setNgayDatHang(rs.getDate("NgayDatHang"));
                don.setNgayGiaoHang(rs.getDate("NgayGiao"));
                don.setGiaTri(rs.getFloat("GiaTri"));
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return don;
    }
    public static int layMa(){
        int maDH = -1;
        try {
            String sql = "select max(madondathang) as ma from DonDatHang";
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if(rs.next()){
                maDH = rs.getInt("ma") + 1;
            }
            helper.close();
        } catch (Exception e) {
            return -1;
        }
        return maDH;
    }
    public static ArrayList<DonDatHangPojo> layDSDonHang(String maKhachHang){
        ArrayList<DonDatHangPojo> ds = new ArrayList<DonDatHangPojo>();
        try {
            String sql = String.format("select * from DonDatHang where MaKhachHang='%s'",maKhachHang);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                DonDatHangPojo don = new DonDatHangPojo();
                don.setMaDonDatHang(rs.getInt("MaDonDatHang"));
                don.setMaKhachHang(rs.getString("MaKhachHang"));
                don.setMaTinhTrang(rs.getInt("MaTinhTrang"));
                don.setNgayDatHang(rs.getDate("NgayDatHang"));
                don.setNgayGiaoHang(rs.getDate("NgayGiao"));
                don.setGiaTri(rs.getFloat("GiaTri"));
                ds.add(don);
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return ds;
    }
    public static int themDonDatHang(DonDatHangPojo don){
        try {
            String sql = String.format("INSERT INTO `shopquanao`.`dondathang` (`NgayDatHang`,`NgayGiao`, `GiaTri`, `MaKhachHang`, `MaTinhTrang`, `TenNguoiNhan`, `SoDTNguoiNhan`, `DiaChiNguoiNhan`, `Xoa`) VALUES ('%s','%s', %f, '%s', %d, '%s', '%s', '%s', 0)",
                                        Utility.getShortDate(don.getNgayDatHang()),Utility.getShortDate(don.getNgayDatHang()), don.getGiaTri(), don.getMaKhachHang(), don.getMaTinhTrang(), don.getTenNguoiNhan(), don.getSoDTNguoiNhan(), don.getDiaChiNguoiNhan());
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            sql = "select max(`MaDonDatHang`) as id from `shopquanao`.`dondathang`";
             ResultSet rs = helper.executeQuery(sql);
             rs.next();
             int id = rs.getInt("id");
            helper.close();
            return id;
        } catch (Exception e) {
            return -1;
        }
    }
    public static boolean thanhToan(int maDH){
        try {
            String sql = String.format("UPDATE `shopquanao`.`dondathang` SET `MaTinhTrang`=2 WHERE `MaDonDatHang`=%d", maDH);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
