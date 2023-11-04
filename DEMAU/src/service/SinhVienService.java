package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

public class SinhVienService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<SinhVien> getAll() {
        sql = "SELECT ID, MaSinhVien, TenSinhVien, Tuoi, Kyhoc, NganhHoc, DiemTB, GioiTinh FROM SinhVien";
        List<SinhVien> listSV = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(7),/*sửa chỗ này*/ rs.getBoolean(8));
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addSinhVien(SinhVien sv){
        sql = "INSERT INTO SinhVien(MaSinhVien, TenSinhVien, Tuoi, KyHoc, NganhHoc, DiemTB, GioiTinh) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getMaSV());
            ps.setObject(2, sv.getTenSV());
            ps.setObject(3, sv.getTuoi());
            ps.setObject(4, sv.getKiHoc());
            ps.setObject(5, sv.getNganhHoc());
            ps.setObject(6, sv.getDiemTB());
            ps.setObject(7, sv.getGioiTinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public SinhVien getSV(String maSV){
        sql = "SELECT ID, MaSinhVien, TenSinhVien, Tuoi, KyHoc, NganhHoc, DiemTB, GioiTinh FROM SinhVien WHERE MaSinhVien = ?";
        SinhVien sv = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSV);
            rs = ps.executeQuery();
            while(rs.next()){
                sv = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(7), /*sửa chỗ này*/rs.getBoolean(8));
            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int removeSV(int id){
        sql = "DELETE FROM SinhVien WHERE ID = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updateSV(SinhVien sv, int id){
        sql = "UPDATE SinhVien SET DiemTB = ? WHERE ID = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getDiemTB());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
