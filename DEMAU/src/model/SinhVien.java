package model;

public class SinhVien {

    public int id;
    public String maSV;
    public String tenSV;
    public int tuoi;
    public int kiHoc;
    public String nganhHoc;
    public float diemTB;
    public boolean gioiTinh;

    public SinhVien() {
    }

    public SinhVien(int id, String maSV, String tenSV, int tuoi, int kiHoc, String nganhHoc, float diemTB, boolean gioiTinh) {
        this.id = id;
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.tuoi = tuoi;
        this.kiHoc = kiHoc;
        this.nganhHoc = nganhHoc;
        this.diemTB = diemTB;
        this.gioiTinh = gioiTinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(int kiHoc) {
        this.kiHoc = kiHoc;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.id,
            this.maSV,
            this.tenSV,
            this.tuoi,
            this.kiHoc,
            this.nganhHoc,
            this.diemTB,
            this.gioiTinh
        };
    }
}
