/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import pojo.*;

/**
 *
 * @author luctanbinh
 */
public class giohangdao {

    public static GioHangPojo layGioHang(int maDonHang) {
        GioHangPojo gh = new GioHangPojo();
        gh.setDsChiTiet(chitietdondathangdao.layChiTietDonHang(maDonHang));
        return gh;
    }

    /*
    public static GioHangPojo layGioHang(String maKH) {
        GioHangPojo gh = new GioHangPojo();
        DonDatHangPojo don = dondathangdao.layDonHang(maKH);
        if (don != null) {
            gh.setDsChiTiet(chitietdondathangdao.layChiTietDonHang(gh.getDonDatHang().getMaDonDatHang()));
        }
        return gh;
    }
    */
    public static GioHangPojo ThemSP(SPPojo tv, int soLuong, GioHangPojo gh, KhachHangPojo user){
        int index = -1;
        for(int i = 0; i < gh.getDsChiTiet().size(); i++){
            ChiTietDonDatHangPojo ct = gh.getDsChiTiet().get(i);
            if(tv.getMaSP() == ct.getMaSP()){
                index = i;
                break;
            }
        }
            //chitietdondathangdao.themChiTietDonDatHang(gh.getDonDatHang().getMaDonDatHang(), tv.getMaSP(), soLuong, donGia);
            
        ChiTietDonDatHangPojo ct = new ChiTietDonDatHangPojo();
        if(index == -1){
            
            ct.setMaSP(tv.getMaSP());
            ct.setSoLuong(soLuong);
            float donGia = tv.getGiaBan()*soLuong;
            ct.setDonGia(donGia);
            gh.getDsChiTiet().add(ct);
            index = gh.getDsChiTiet().size() - 1;
        } else {
            ct = gh.getDsChiTiet().get(index);
            soLuong += ct.getSoLuong();
            ct.setSoLuong(soLuong);
            float donGia = tv.getGiaBan()*soLuong;
            ct.setDonGia(donGia);
            gh.getDsChiTiet().set(index, ct);
        }
        /*if(user != null){
            if(gh.getDsChiTiet().size() <=1){
                dondathangdao.themDonDatHang(gh.getDonDatHang());
            }
            ct = chitietdondathangdao.themChiTietDonDatHang(ct);
            gh.getDsChiTiet().set(index, ct);
        }*/
        return gh;
    }
    /*public static GioHangPojo capNhatDonDatHang(GioHangPojo gh, String maKH){
        gh.getDonDatHang().setMaDonDatHang(dondathangdao.layMa());
        gh.getDonDatHang().setMaKhachHang(maKH);
        if(gh.getDsChiTiet().size() <=1){
                dondathangdao.themDonDatHang(gh.getDonDatHang());
            }
        return gh ;
    }*/
    public static void capNhat(GioHangPojo gh){
        for(int i = 0; i < gh.getDsChiTiet().size(); i++){
            
        }
    }   
    public static void thanhToan(GioHangPojo gh, KhachHangPojo user, String hoTen, String dienThoai, String diaChi){
        DonDatHangPojo don = new DonDatHangPojo(user.getTenDangNhap(), gh.getTongTien(),  hoTen, dienThoai, diaChi);
        int id = dondathangdao.themDonDatHang(don);
        for(int i = 0; i < gh.getDsChiTiet().size(); i++){
            gh.getDsChiTiet().get(i).setMaDonDatHang(id);
        }        
        chitietdondathangdao.themDSChiTietDonDatHang(gh.getDsChiTiet());
        
        List<Integer> lstID = layDSSanPham(gh);
        List<SPPojo> lstSP = SPDao.layDSSP(lstID);
        for(int i = 0; i < gh.getDsChiTiet().size(); i++){
            int soLuongTon = lstSP.get(i).getSoLuongTon() - gh.getDsChiTiet().get(i).getSoLuong();
            lstSP.get(i).setSoLuongTon(soLuongTon);
        }
        SPDao.capNhatDSSP(lstSP);
    }
    private static List<Integer> layDSSanPham(GioHangPojo gh){
        List<Integer> rs = new ArrayList<Integer>();
        for(int i = 0; i < gh.getDsChiTiet().size(); i++){
            rs.add(gh.getDsChiTiet().get(i).getMaSP());
        }
        return rs;
    }
}
