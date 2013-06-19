/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;
import pojo.ThamSoPojo;

/**
 *
 * @author luctanbinh
 */
public class thamsodao {
    public static ThamSoPojo layThamSo(String ma){
        ThamSoPojo dm = new ThamSoPojo();
        try {
            String sql = "select * from ThamSo where MaThamSo='" + ma + "'";
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                dm.setMaThamSo(rs.getString("MaThamSo"));
                dm.setTenThamSo(rs.getString("TenThamSo"));
                dm.setGiaTri(rs.getString("GiaTri"));
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return dm;
    }
    public static boolean themThamSo(ThamSoPojo ts){
        try {
            String sql = String.format("INSERT INTO `shopquanao`.`thamso` (`MaThamSo`, `TenThamSo`, `GiaTri`, `Xoa`) VALUES ('%s', '%s', '%s', 0)",
                                       ts.getMaThamSo(), ts.getTenThamSo(), ts.getGiaTri());
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
