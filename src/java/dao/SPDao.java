/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.util.MySqlDataAccessHelper;
import dao.util.Utility;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import pojo.*;

/**
 *
 * @author luctanbinh
 */
public class SPDao {

    public static SPPojo laySP(int ma) {
        SPPojo tv = new SPPojo();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            String sql = String.format("select * from SP where maSP = %d", ma);
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));           
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
            }
        } catch (Exception e) {
        }
        helper.close();
        return tv;
    }
    
    public static int laySoLuongTon() {
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        int slt = 0;
        try {
            helper.open();
            String sql = String.format("select sum(SoLuongTon)as slt from SP");
            ResultSet rs = helper.executeQuery(sql);
            
            if (rs.next()) {
                slt = rs.getInt("slt");
            }
        } catch (Exception e) {
            return 0;
        }
        helper.close();
        return slt;
    }
    
    public static float layDonGia(int ma) {
        float gia = 0;
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            String sql = String.format("select DonGia from SP where maSP = %d", ma);
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                gia = rs.getFloat("DonGia");
            }
            helper.close();
        } catch (Exception e) {
            helper.close();
        }
        return gia;
    }
    public static boolean xoa(int ma) {
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            String sql = String.format("Update SP set xoa = 1 where maSP = %d", ma);
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            helper.close();
            return false;
        }
        return true;
    }
    public static boolean them(SPPojo sp) {
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            String sql = String.format("insert into sp(tenSP, madanhmuc, soluongton, soluong, mota, dongia, hinhanh, ngaynhap, xoa) values('%s', %d, %d,%d, '%s', %f, '%s', '%s', 0)", 
                                       sp.getTenSP(), sp.getMaDM(), sp.getSoLuong(), sp.getSoLuong(), sp.getMoTa(), sp.getGiaBan(), sp.getHinhAnh(), Utility.getShortDate(sp.getNgayNhap())) ;
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            helper.close();
            return false;
        }
        return true;
    }
    public static ArrayList<SPPojo> layDanhSachSP() {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            String sql = "select * from SP";
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));          
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }

    public static ArrayList<SPPojo> layDanhSachSP(int maDM, int trang, int soLuongTrenTrang) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            int n = (trang - 1) * soLuongTrenTrang;
            String sql;
            if (soLuongTrenTrang != -1) {
                sql = String.format("select * from SP where MaDanhMuc = %d limit %d, %d", maDM, n, soLuongTrenTrang);
            } else {
                sql = String.format("select * from SP where MaDanhMuc = %d", maDM);
            }
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));       
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    public static ArrayList<SPPojo> layDanhSachSP(int trang, int soLuongTrenTrang) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            int n = (trang - 1) * soLuongTrenTrang;
            String sql;
            if (soLuongTrenTrang != -1) {
                sql = String.format("select * from SP limit %d, %d", n, soLuongTrenTrang);
            } else {
                sql = String.format("select * from SP");
            }
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));       
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }

    public static ArrayList<SPPojo> timKiem(String tuKhoa, int trang, int soLuongTrenTrang) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            int n = (trang - 1) * soLuongTrenTrang;
            String sql;
            if (soLuongTrenTrang != -1) {
                sql = "select * from  SP where Xoa=0 and TenSP like '" + tuKhoa + "%' limit " + n + "," + soLuongTrenTrang;
            } else {
                sql = "select * from SP where Xoa=0 and TenSP like '" + tuKhoa + "%'" ;
            }
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));         
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    public static ArrayList<SPPojo> timKiemNangCao(String tuKhoa, int maDM, float giaTu, float giaDen, int trang, int soLuongTrenTrang) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            int n = (trang - 1) * soLuongTrenTrang;
            String sql = "select * from SP where TenSP like '" + tuKhoa + "%'";
            if(maDM != -1){
                sql += " and MaDanhMuc = " + maDM ;
            }
            if(giaTu >= 0){
                sql += " and DonGia >= " + giaTu ;
            }
            if(giaDen >= 0){
                sql += " and DonGia <= " + giaDen ;
            }
            if (soLuongTrenTrang != -1) {
                sql += " limit " + n + "," + soLuongTrenTrang;
            }
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    
    public static ArrayList<SPPojo> layDanhSachSP(int maDM) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            String sql = String.format("select * from SP where MaDanhMuc = %d", maDM);
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));           
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    
    public static List<SPPojo> layDSSP(List<Integer> IDs) {
        if(IDs == null || IDs.isEmpty()){
            return new ArrayList<SPPojo>();
        }
        String temp = "(";
        for(int i = 0; i<IDs.size(); i++){
            temp += IDs.get(i) + ",";
        }
        temp += ")";
        temp = temp.replace(",)", ")");
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            String sql = String.format("select * from SP where MaSP IN %s", temp);
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));               
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    
    public static boolean capNhatDSSP(List<SPPojo> lstSP) {
        try {
            String sql = "";
            for(int i =0; i < lstSP.size(); i++){
                String temp = String.format("UPDATE `shopquanao`.`sp` SET `SoLuongTon`=%d WHERE `MaSP`=%d;",
                    lstSP.get(i).getSoLuongTon(), lstSP.get(i).getMaSP());
                sql += temp;
            }
            MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
            helper.open();
            helper.executeUpdate(sql);
            helper.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int tinhSoTrang(int maDanhMuc, int soLuongSPTrenTrang) {
        int soTrang = 0;
        int soLuong = 0;
        String sql;
        if(maDanhMuc != -1){
            sql = String.format("select Count(*) as soluong from SP where MaDanhMuc = %d", maDanhMuc);
        } else {
            sql = "select Count(*) as soluong from SP";
        }

        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                soLuong = rs.getInt("soluong");
            }
            helper.close();
        } catch (Exception e) {
            soTrang = -1;
        }
        if (soLuongSPTrenTrang == -1) {
            soTrang = 1;
        } else {
            soTrang = soLuong / soLuongSPTrenTrang;
            if (soLuong % soLuongSPTrenTrang != 0) {
                soTrang++;
            }
        }
        return soTrang;
    }

    public static int tinhSoTrangTimKiem(String tuKhoa, int maDanhMuc, int soLuongSPTrenTrang) {
        int soTrang = 0;
        int soLuong = 0;
        String sql;
        if(maDanhMuc != -1){
            sql = "select Count(*) as soluong from  SP where Xoa=0 and TenSP like '" + tuKhoa + "%'" ;
        } else {
            sql = "select Count(*) as soluong from SP where Xoa=0 and TenSP like '" + tuKhoa + "%'" ;
        }

        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                soLuong = rs.getInt("soluong");
            }
            helper.close();
        } catch (Exception e) {
            soTrang = -1;
        }
        if (soLuongSPTrenTrang == -1) {
            soTrang = 1;
        } else {
            soTrang = soLuong / soLuongSPTrenTrang;
            if (soLuong % soLuongSPTrenTrang != 0) {
                soTrang++;
            }
        }
        return soTrang;
    }
    public static int tinhSoTrangTimKiemNangCao(String tuKhoa, float giaTu, float giaDen, int maDanhMuc, int soLuongSPTrenTrang) {
        int soTrang = 0;
        int soLuong = 0;

        String sql = "select Count(*) as soluong from SP where TenSP like '" + tuKhoa + "%'";
            if(maDanhMuc != -1){
                sql += " and MaDanhMuc = " + maDanhMuc ;
            }
            if(giaTu >= 0){
                sql += " and DonGia >= " + giaTu ;
            }
            if(giaDen >= 0){
                sql += " and DonGia <= " + giaDen ;
            }
            
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                soLuong = rs.getInt("soluong");
            }
            helper.close();
        } catch (Exception e) {
            soTrang = -1;
        }
        if (soLuongSPTrenTrang == -1) {
            soTrang = 1;
        } else {
            soTrang = soLuong / soLuongSPTrenTrang;
            if (soLuong % soLuongSPTrenTrang != 0) {
                soTrang++;
            }
        }
        return soTrang;
    }
    
    public static String layTenNhaSanXuat(int maDM) {
        return danhmucdao.layTenDanhMuc(maDM);
    }

    public static String toVND(float tien) {
        String giaTien = String.valueOf(((long) tien));
        String temp = " VNĐ";
        String t = "";
        if (giaTien.length() > 3) {
            for (int c = giaTien.length() - 1; c >= 0; c -= 3) {
                if (c - 3 >= 0) {
                    t = giaTien.substring(c - 2, c + 1);

                } else {
                    t = giaTien.substring(0, c + 1);
                }
                temp = t.concat(".") + temp;
            }
        } else {
            temp = giaTien + temp;
        }
        return temp;
    }
    public static ArrayList<SPPojo> layDSSPBanChay(int trang, int soLuongTrenTrang) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            int n = (trang - 1) * soLuongTrenTrang;
            String sql;
            if (soLuongTrenTrang != -1) {
                sql = String.format("select * from sp where masp in (select ct.masp from dondathang d, chitietdondathang ct where d.madondathang = ct.madonhang and d.matinhtrang=2) limit %d, %d", n, soLuongTrenTrang);
            } else {
                sql = "select * from sp where masp in (select ct.masp from dondathang d, chitietdondathang ct where d.madondathang = ct.madonhang and d.matinhtrang=2)" ;
            }
            
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));     
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    public static int tinhSoTrangDSSPBanChay(int soLuongSPTrenTrang) {
        int soTrang = 0;
        int soLuong = 0;
        String sql = "select count(*) as soluong from tv where matv in (select ct.matv from dondathang d, chitietdondathang ct where d.madondathang = ct.madonhang and d.matinhtrang=2)" ;

        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                soLuong = rs.getInt("soluong");
            }
            helper.close();
        } catch (Exception e) {
            soTrang = -1;
        }
        if (soLuongSPTrenTrang == -1) {
            soTrang = 1;
        } else {
            soTrang = soLuong / soLuongSPTrenTrang;
            if (soLuong % soLuongSPTrenTrang != 0) {
                soTrang++;
            }
        }
        return soTrang;
    }
    
    public static ArrayList<SPPojo> layDSSPKhuyenMai(int trang, int soLuongTrenTrang) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            int n = (trang - 1) * soLuongTrenTrang;
            String sql;
            if (soLuongTrenTrang != -1) {
                sql = String.format("select * from sp where MaKhuyenMai>=0 limit %d, %d", n, soLuongTrenTrang);
            } else {
                sql = "select * from sp where MaKhuyenMai>=0)" ;
            }
            
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    public static int tinhSoTrangDSSPKhuyenMai(int soLuongSPTrenTrang) {
        int soTrang = 0;
        int soLuong = 0;
        String sql = "select count(*) as soluong from sp where MaKhuyenMai>=1" ;

        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                soLuong = rs.getInt("soluong");
            }
            helper.close();
        } catch (Exception e) {
            soTrang = -1;
        }
        if (soLuongSPTrenTrang == -1) {
            soTrang = 1;
        } else {
            soTrang = soLuong / soLuongSPTrenTrang;
            if (soLuong % soLuongSPTrenTrang != 0) {
                soTrang++;
            }
        }
        return soTrang;
    }
    
    public static ArrayList<SPPojo> layDSSPMoi(int trang, int soLuongTrenTrang) {
        ArrayList<SPPojo> ds = new ArrayList<SPPojo>();
        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            int n = (trang - 1) * soLuongTrenTrang;
            String sql;
            Calendar c = Calendar.getInstance();
            int m = c.get(Calendar.MONTH)+1;
            int temp = 2-m;
            if(temp >= 0){
                m = 12 - temp;
            }else{
                m -= 2;
            }
            c.set(Calendar.MONTH, m-1);
            if (soLuongTrenTrang != -1) {
                sql = String.format("select * from sp where NgayNhap >= '%s' limit %d, %d",Utility.getShortDate(c.getTime()),  n, soLuongTrenTrang);
            } else {
                sql = String.format("select * from sp where NgayNhap >= '%s'", Utility.getShortDate(c.getTime())) ;
            }
            
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            while (rs.next()) {
                SPPojo tv = new SPPojo();
                tv.setMaSP(rs.getInt("MaSP"));
                tv.setTenSP(rs.getString("TenSP"));
                tv.setMaDM(rs.getInt("MaDanhMuc"));
                tv.setSoLuongTon(rs.getInt("SoLuongTon"));
                tv.setSoLuong(rs.getInt("SoLuong"));
                tv.setMoTa(rs.getString("MoTa"));
                tv.setGiaBan(rs.getFloat("DonGia"));
                tv.setHinhAnh(rs.getString("HinhAnh"));   
                tv.setMaKhuyenMai(rs.getInt("MaKhuyenMai"));
                ds.add(tv);
            }
        } catch (Exception e) {
        }
        helper.close();
        return ds;
    }
    public static int tinhSoTrangDSSPMoi(int soLuongSPTrenTrang) {
        int soTrang = 0;
        int soLuong = 0;
        Calendar c = Calendar.getInstance();
            int m = c.get(Calendar.MONTH)+1;
            int temp = 2-m;
            if(temp >= 0){
                m = 12 - temp;
            }else{
                m -= 2;
            }
            c.set(Calendar.MONTH, m-1);
            
        String sql = String.format("select count(*) as soluong from sp where NgayNhap >= '%s'", Utility.getShortDate(c.getTime())) ;

        MySqlDataAccessHelper helper = new MySqlDataAccessHelper();
        try {
            helper.open();
            ResultSet rs = helper.executeQuery(sql);
            if (rs.next()) {
                soLuong = rs.getInt("soluong");
            }
            helper.close();
        } catch (Exception e) {
            soTrang = -1;
        }
        if (soLuongSPTrenTrang == -1) {
            soTrang = 1;
        } else {
            soTrang = soLuong / soLuongSPTrenTrang;
            if (soLuong % soLuongSPTrenTrang != 0) {
                soTrang++;
            }
        }
        return soTrang;
    }
}
