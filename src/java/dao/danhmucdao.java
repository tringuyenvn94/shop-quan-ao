/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.*;
/**
 *
 * @author luctanbinh
 */
public class danhmucdao {
    public static ArrayList<DanhMucPojo> layDanhMuc(){
        ArrayList<DanhMucPojo> ds = new ArrayList<DanhMucPojo>();
        try {
            String sql = "select * from DanhMuc";
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                DanhMucPojo dm = new DanhMucPojo();
                dm.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                dm.setTenDanhMuc(rs.getString("TenDanhMuc"));
                dm.setXuatXu(rs.getString("XuatXu"));
                ds.add(dm);
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return ds;
    }
    public static DanhMucPojo layDanhMuc(int ma){
        DanhMucPojo dm = new DanhMucPojo();
        try {
            String sql = "select * from DanhMuc where MaDanhMuc=" + ma;
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                dm.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                dm.setTenDanhMuc(rs.getString("TenDanhMuc"));
                dm.setXuatXu(rs.getString("XuatXu"));
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return dm;
    }
    public static String layTenDanhMuc(int ma){
        String tenDM="";
        try {
            String sql = "select TenDanhMuc from DanhMuc where MaDanhMuc=" + ma;
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while(rs.next()){
                tenDM = rs.getString("TenDanhMuc");
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return tenDM;
    }
}
