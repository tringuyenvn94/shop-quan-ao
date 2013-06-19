/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.ChiTietDonDatHangPojo;
import pojo.DonDatHangPojo;
import pojo.KhachHangPojo;

/**
 *
 * @author luctanbinh
 */
public class chitietdondathangdao {

    public static ArrayList<ChiTietDonDatHangPojo> layChiTietDonHang(int ma) {
        ArrayList<ChiTietDonDatHangPojo> lst = new ArrayList<ChiTietDonDatHangPojo>();
        try {
            String sql = String.format("select * from ChiTietDonDatHang where Xoa = 0 and MaChiTiet = %d", ma);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                ChiTietDonDatHangPojo don = new ChiTietDonDatHangPojo();
                don.setMaChiTiet(rs.getInt("MaChiTiet"));
                don.setMaDonDatHang(rs.getInt("MaDonHang"));
                don.setMaSP(rs.getInt("MaSP"));
                don.setSoLuong(rs.getInt("SoLuong"));
                lst.add(don);
            }
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return lst;
    }

    public static ChiTietDonDatHangPojo themChiTietDonDatHang(ChiTietDonDatHangPojo ctDon) {
        try {
            String sql = String.format("INSERT INTO `shopquanao`.`chitietdondathang` (`MaDonHang`, `MaSP`, `SoLuong`, `Xoa`) VALUES (%d, %d, %d, 0)",
                    ctDon.getMaDonDatHang(), ctDon.getMaSP(), ctDon.getSoLuong());
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            ctDon.setMaChiTiet(layMax(helper));
            helper.close();
        } catch (Exception e) {
            return null;
        }
        return ctDon;
    }

    public static void themDSChiTietDonDatHang(ArrayList<ChiTietDonDatHangPojo> ctDon, KhachHangPojo User) {
        try {

            String sql = "";
            if (User != null) {
                for (int i = 0; i < ctDon.size(); i++) {
                    sql += String.format("INSERT INTO `shopquanao`.`chitietdondathang` (`MaDonHang`, `MaSP`, `SoLuong`, `Xoa`) VALUES (%d, %d, %d, 0)",
                            ctDon.get(i).getMaDonDatHang(), ctDon.get(i).getMaSP(), ctDon.get(i).getSoLuong()) + ";";
                }
            } else {
                for (int i = 0; i < ctDon.size(); i++) {
                    sql += String.format("INSERT INTO `shopquanao`.`chitietdondathang` (`MaDonHang`, `MaSP`, `SoLuong`, `Xoa`) VALUES (1, %d, %d, 0)",
                            ctDon.get(i).getMaSP(), ctDon.get(i).getSoLuong()) + ";";
                }
            }

            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
        }
    }

    public static boolean capNhat(int maCT, int soLuong) {
        try {
            String sql = String.format("UPDATE `shopquanao`.`chitietdondathang` SET `SoLuong`=%d WHERE `MaChiTiet`=%d;",
                    soLuong, maCT);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean xoa(int maCT) {
        try {
            String sql = String.format("UPDATE `shopquanao`.`chitietdondathang` SET `Xoa`=1 WHERE `MaChiTiet`=%d", maCT);
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int layMax(MySqlDataAccessHelper helper) {
        int max = 0;
        try {
            String sql = "select max(MaChiTiet) as Max from ChiTietDonDatHang";
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                max = rs.getInt("Max");
            }
        } catch (Exception e) {
            return 0;
        }
        return max;
    }
}
