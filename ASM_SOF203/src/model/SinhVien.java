package model;

public class SinhVien {

    public String maSV;
    public String hoTen;
    public String email;
    public String soDT;
    public boolean gioiTinh;
    public String diaChi;
    public String hinhAnh;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, String email, String soDT, boolean gioiTinh, String diaChi, String hinhAnh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.maSV,
            this.hoTen,
            this.email,
            this.soDT,
            this.gioiTinh,
            this.diaChi,
            this.hinhAnh
        };
    }
}
