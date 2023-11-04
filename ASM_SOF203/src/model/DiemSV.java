package model;

import java.text.DecimalFormat;

public class DiemSV {

    public int id;
    public String maSV;
    public String hoTen;
    public float tiengAnh;
    public float tinHoc;
    public float GDTC;
    public double diemTB;
    DecimalFormat df = new DecimalFormat("0.00");

    public DiemSV() {
    }

    public DiemSV(String maSV, String hoTen, float tiengAnh, float tinHoc, float GDTC, double diemTB) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
        this.diemTB = diemTB;
    }

    public DiemSV(int id, String maSV, String hoTen, float tiengAnh, float tinHoc, float GDTC, double diemTB) {
        this.id = id;
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
        this.diemTB = diemTB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public float getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(float tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public float getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(float tinHoc) {
        this.tinHoc = tinHoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }

    public String getDiemTB() {
        return df.format((this.tiengAnh + this.tinHoc + this.GDTC) / 3.0);
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.maSV,
            this.hoTen,
            this.tiengAnh,
            this.tinHoc,
            this.GDTC,
            this.diemTB
        };
    }
}
