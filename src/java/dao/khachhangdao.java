/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.*;
import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;

/**
 *
 * @author luctanbinh
 */
public class khachhangdao {
    public static KhachHangPojo layKhachHang(String id, String matKhau){
        KhachHangPojo kh = new KhachHangPojo();
        try {
            String sql = String.format("select * from KhachHang where TenTruyCap = '%s' and MatKhau = '%s'", id, matKhau);
            
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if(rs.next()){
                kh.setTenDangNhap(rs.getString("TenTruyCap"));
                kh.setMatKhau(rs.getString("MatKhau"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setEmail(rs.getString("Email"));
                kh.setDienThoai(rs.getString("DienThoai"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setAdmin(rs.getBoolean("Admin"));
            } else {
                kh = null;
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return kh;
    }
    public static boolean themKhachHang(KhachHangPojo kh){
        try {
            String sql = String.format("INSERT INTO `khachhang` VALUES ('%s','%s','%s','%s','%s','%s',0,0)",
                                        kh.getTenDangNhap(), kh.getMatKhau(), kh.getHoTen(), kh.getEmail(), kh.getDienThoai(), kh.getDiaChi());
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean kiemTraId(String id){
        boolean kq = false;
        try {
            String sql = String.format("select count(*) as soLuong from KhachHang where TenTruyCap = '%s'", id);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if(rs.next()){
                int soLuong = rs.getInt("soLuong");
                if(soLuong > 0){
                    kq = true;
                }
            }
            helper.close();
        } catch (Exception e) {
            return false;
        }
        return kq;
    }
}
