/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;

/**
 *
 * @author luctanbinh
 */
public class tinhtrangdondathangdao {
    public static String layTenTinhTrang(int ma){
        String ten = "";
        try {
            String sql = "select * from TinhTrangDonDatHang where MaTinhTrang='" + ma + "'";
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                ten = rs.getString("TenTinhTrang") ;
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return ten;
    }
}
