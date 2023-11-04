package model;

public class XeMay {

    private String id;
    private String maXe;
    private String tenXe;
    private boolean trangThai;
    private double giaBan;
    private double giaNhap;
    private int soLuong;

    public XeMay() {
    }

    public XeMay(String maXe, String tenXe, boolean trangThai, double giaBan, double giaNhap, int soLuong) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.trangThai = trangThai;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
    }

    public XeMay(String id, String maXe, String tenXe, boolean trangThai, double giaBan, double giaNhap, int soLuong) {
        this.id = id;
        this.maXe = maXe;
        this.tenXe = tenXe;
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

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
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
            this.maXe,
            this.tenXe,
            this.trangThai,
            this.giaBan,
            this.giaNhap,
            this.soLuong
        };
    }
}
