package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

public class SinhVienService {

    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<SinhVien> getAll() {
        sql = "SELECT masinhvien, hoten, email, sodienthoai, gioitinh, diachi, hinh FROM students";
        List<SinhVien> listsv = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7));
                listsv.add(sv);
            }
            return listsv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addSV(SinhVien sv) {
        sql = "INSERT INTO students(masinhvien, hoten, email, sodienthoai, gioitinh, diachi, hinh) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getMaSV());
            ps.setObject(2, sv.getHoTen());
            ps.setObject(3, sv.getEmail());
            ps.setObject(4, sv.getSoDT());
            ps.setObject(5, sv.isGioiTinh());
            ps.setObject(6, sv.getDiaChi());
            ps.setObject(7, sv.getHinhAnh());
            ps.setObject(1, sv.getMaSV());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public SinhVien getSV(String maSV) {
        sql = "SELECT masinhvien, hoten, email, sodienthoai, gioitinh, diachi, hinh FROM students WHERE masinhvien = ?";
        SinhVien sv = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSV);
            rs = ps.executeQuery();
            while (rs.next()) {
                sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7));
            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int deleteSV(String maSV) {
        // Cách 1 :
        String sqlDeleteGrade = "DELETE FROM grade WHERE masinhvien = ?";
        sql = "DELETE FROM students WHERE masinhvien = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSV);
            PreparedStatement psGrade = con.prepareStatement(sqlDeleteGrade);
            psGrade.setObject(1, maSV);
            psGrade.executeUpdate();
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        // Cách 2 :
//        try {
//            con = DBconnect.getConnection();
//            sql = "DELETE FROM grade WHERE masinhvien = ?";
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, maSV);
//            ps.executeUpdate();
//            sql = "DELETE FROM students WHERE masinhvien = ?";
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, maSV);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
    }

    public int updateDSV(SinhVien sv, String maSV) {
        sql = "UPDATE students SET sodienthoai = ? WHERE masinhvien = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getSoDT());
            ps.setObject(2, maSV);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
