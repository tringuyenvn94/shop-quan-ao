/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import dao.util.Utility;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import pojo.binhluanpojo;

/**
 *
 * @author luctanbinh
 */
public class ThongKeDao {
    public static float layGiaTriDDH(int dm, Date from, Date to){
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        float gt = 0;
        try {
            helper.open();
            String sql = String.format("select sum(GiaTri) as GiaTri from DonDatHang "
                    + "where MaDonDatHang in "
                    + "(select ct.MaDonHang from ChiTietDonDatHang ct, SP sp where sp.MaDanhMuc = %d and sp.MaSP = ct.MaSP) "
                    + "and NgayDatHang >= '%s' and NgayDatHang <= '%s'", dm, Utility.getShortDate(from), Utility.getShortDate(to));
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                gt = rs.getFloat("GiaTri");
            }
        } catch (Exception e) {
            return 0;
        }
        helper.close();
        return gt;
    }
}
