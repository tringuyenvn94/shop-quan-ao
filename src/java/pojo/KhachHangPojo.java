/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author luctanbinh
 */
public class KhachHangPojo {
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private String email;
    private String dienThoai;
    private String diaChi;
    private boolean admin;

    public KhachHangPojo(String id, String MatKhau, String HoTen, String Email, String DienThoai, String DiaChi, boolean isAdmin) {
        tenDangNhap = id;
        matKhau = MatKhau;
        hoTen = HoTen;
        email = Email;
        dienThoai = DienThoai;
        diaChi = DiaChi;
        admin = isAdmin;
    }
    public KhachHangPojo(){
        admin = false;
    }
            

    /**
     * @return the matKhau
     */
    public String getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dienThoai
     */
    public String getDienThoai() {
        return dienThoai;
    }

    /**
     * @param dienThoai the dienThoai to set
     */
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the laAdmin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param laAdmin the laAdmin to set
     */
    public void setAdmin(boolean laAdmin) {
        this.admin = laAdmin;
    }

    /**
     * @return the tenDangNhap
     */
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    /**
     * @param tenDangNhap the tenDangNhap to set
     */
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
}
