/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.DonDatHangPojo;

/**
 *
 * @author luctanbinh
 */
public class dondathangdao {
    public static DonDatHangPojo layDonHang(int ma){
        DonDatHangPojo don = new DonDatHangPojo();
        try {
            String sql = String.format("select * from DonDatHang where Xoa = 0 and MaDonDatHang=%d",ma);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                don.setMaDonDatHang(rs.getInt("MaDonDatHang"));
                don.setMaKhachHang(rs.getString("MaKhachHang"));
                don.setMaTinhTrang(rs.getInt("MaTinhTrang"));
                don.setNgayDatHang(rs.getString("NgayDatHang"));
                don.setNgayGiaoHang(rs.getString("NgayGiao"));
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
            String sql = String.format("select * from DonDatHang where Xoa = 0 and MaKhachHang='%s'",maKhachHang);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                don.setMaDonDatHang(rs.getInt("MaDonDatHang"));
                don.setMaKhachHang(rs.getString("MaKhachHang"));
                don.setMaTinhTrang(rs.getInt("MaTinhTrang"));
                don.setNgayDatHang(rs.getString("NgayDatHang"));
                don.setNgayGiaoHang(rs.getString("NgayGiao"));
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
            String sql = String.format("select * from DonDatHang where Xoa = 0 and MaKhachHang='%s'",maKhachHang);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                DonDatHangPojo don = new DonDatHangPojo();
                don.setMaDonDatHang(rs.getInt("MaDonDatHang"));
                don.setMaKhachHang(rs.getString("MaKhachHang"));
                don.setMaTinhTrang(rs.getInt("MaTinhTrang"));
                don.setNgayDatHang(rs.getString("NgayDatHang"));
                don.setNgayGiaoHang(rs.getString("NgayGiao"));
                don.setGiaTri(rs.getFloat("GiaTri"));
                ds.add(don);
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return ds;
    }
    public static boolean themDonDatHang(DonDatHangPojo don){
        try {
            String sql = String.format("INSERT INTO `shopquanao`.`dondathang` (`MaDonDatHang`, `NgayDatHang`, `NgayGiao`, `GiaTri` `MaKhachHang`, `MaTinhTrang`, `Xoa`) VALUES (%d, '%s', '%s', '%s', 0)",
                                        don.getMaDonDatHang(), don.getNgayDatHang(),don.getNgayGiaoHang(), don.getGiaTri(), don.getMaKhachHang(), don.getMaTinhTrang());
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            return false;
        }
        return true;
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
