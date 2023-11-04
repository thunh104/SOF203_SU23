package model;
public class SanPham {
    private String id;
    private String ma;
    private String ten;
    private boolean trangThai;
    private int soLuong;
    private double giaBan;

    public SanPham() {
    }

    public SanPham(String ma, String ten, boolean trangThai, int soLuong, double giaBan) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public SanPham(String id, String ma, String ten, boolean trangThai, int soLuong, double giaBan) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
    public Object[] toDataRow(){
        return new Object[]{
            this.id,
            this.ma,
            this.ten,
            this.trangThai,
            this.soLuong,
            this.giaBan
        };
    }
}
