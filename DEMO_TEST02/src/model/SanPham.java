package model;

public class SanPham {

    private String id;
    private String maSP;
    private String tenSP;
    private boolean trangThai;
    private int soLuong;
    private double giaBan;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, boolean trangThai, int soLuong, double giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public SanPham(String id, String maSP, String tenSP, boolean trangThai, int soLuong, double giaBan) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.id,
            this.maSP,
            this.tenSP,
            this.trangThai,
            this.soLuong,
            this.giaBan
        };
    }
}
