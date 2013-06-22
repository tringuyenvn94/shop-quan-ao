/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojo.DanhMucPojo;
import pojo.KhuyenMaiPojo;
import pojo.SPPojo;
import pojo.binhluanpojo;

/**
 *
 * @author luctanbinh
 */
public class KhuyenMaiDao {
    public static ArrayList<KhuyenMaiPojo> layDSKhuyenMai(List<Integer> IDs) {
        if(IDs == null || IDs.isEmpty()){
            return new ArrayList<KhuyenMaiPojo>();
        }
        String temp = "(";
        for(int i = 0; i<IDs.size(); i++){
            temp += IDs.get(i) + ",";
        }
        temp += ")";
        temp = temp.replace(",)", ")");
        ArrayList<KhuyenMaiPojo> ds = new ArrayList<KhuyenMaiPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            String sql = String.format("select * from KhuyenMai where ma IN %s", temp);
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                KhuyenMaiPojo km = new KhuyenMaiPojo();
                km.setMa(rs.getInt("ma"));
                km.setNoiDung(rs.getString("noidung"));
                ds.add(km);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    public static KhuyenMaiPojo layKhuyenMai(int ma){
        KhuyenMaiPojo km = new KhuyenMaiPojo();
        try {
            String sql = "select * from KhuyenMai where id=" + ma;
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if(rs.next()){
                km.setMa(rs.getInt("id"));
                km.setNoiDung(rs.getString("noidung"));
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return km;
    }
}
