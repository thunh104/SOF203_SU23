package model;

public class XeMay {

    private String id;
    private String ma;
    private String ten;
    private boolean trangThai;
    private double giaBan;
    private double giaNhap;
    private int soLuong;

    public XeMay() {
    }

    public XeMay(String id, String ma, String ten, boolean trangThai, double giaBan, double giaNhap, int soLuong) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
    }

    public XeMay(String ma, String ten, boolean trangThai, double giaBan, double giaNhap, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
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

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.id,
            this.ma,
            this.ten,
            this.trangThai,
            this.giaBan,
            this.giaNhap,
            this.soLuong
        };
    }
}
