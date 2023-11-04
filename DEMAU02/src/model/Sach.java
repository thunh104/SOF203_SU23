package model;

public class Sach {

    public int ID;
    public String maSach;
    public String tenSach;
    public String theLoai;
    public double donGia;

    public Sach(String maSach, String tenSach, String theLoai, double donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.donGia = donGia;
    }

    public Sach() {
    }

    public Sach(int ID, String maSach, String tenSach, String theLoai, double donGia) {
        this.ID = ID;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.donGia = donGia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.ID,
            this.maSach,
            this.tenSach,
            this.theLoai,
            this.donGia
        };
    }
}
