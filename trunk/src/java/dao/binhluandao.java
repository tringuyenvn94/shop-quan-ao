/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.binhluanpojo;

/**
 *
 * @author luctanbinh
 */
public class binhluandao {
    public static ArrayList<binhluanpojo> laySP(int maSP) {
        ArrayList<binhluanpojo> ds = new ArrayList<binhluanpojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            String sql = String.format("select * from binhluan where maSP = %d", maSP);
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                binhluanpojo bl = new binhluanpojo();
                bl.setMaBinhLuan(rs.getInt("mabinhluan"));
                bl.setMaNguoiDung(rs.getString("manguoidung"));
                bl.setMaSP(maSP);
                bl.setNoiDung(rs.getString("noidung"));
                ds.add(bl);
            }
        } catch (Exception e) {
            return new ArrayList<binhluanpojo>();
        }
        helper.close();
        return ds;
    }
    public static boolean themBinhLuan(String nd, int maSP, String maNguoiDung){
        try {
            String sql = String.format("INSERT INTO `tivionline`.`binhluan` (`NoiDung`, `MaNguoiDung`, `MaSP`, `Xoa`) VALUES ('%s', '%s', %d, 0)",
                                       nd, maNguoiDung, maSP);
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
