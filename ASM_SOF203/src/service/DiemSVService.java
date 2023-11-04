package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DiemSV;

public class DiemSVService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<DiemSV> getAll() {
        sql = "SELECT id, students.masinhvien, hoten, tienganh, tinhoc, giaoducthechat, ROUND((tienganh + tinhoc + giaoducthechat)/3,2) AS N'Ði?m TB' FROM grade, students WHERE grade.masinhvien = students.masinhvien";
        List<DiemSV> listDiem = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DiemSV dsv = new DiemSV(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getDouble(7));
                listDiem.add(dsv);
            }
            return listDiem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DiemSV getDiemSV(String maSV) {
        sql = "SELECT hoten, students.masinhvien, tienganh, tinhoc, giaoducthechat, ROUND((tienganh + tinhoc + giaoducthechat)/3,2) AS N'Điểm TB' FROM grade JOIN students ON grade.masinhvien = students.masinhvien WHERE grade.masinhvien = ?";
        DiemSV d = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSV);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new DiemSV(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getDouble(6));
            }
            return d;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DiemSV> findMa(String maSV) {
        sql = "SELECT hoten, students.masinhvien, tienganh, tinhoc, giaoducthechat, ROUND((tienganh + tinhoc + giaoducthechat)/3,2) AS N'Điểm TB' FROM grade JOIN students ON grade.masinhvien = students.masinhvien WHERE grade.masinhvien = ?";
        List<DiemSV> listDiem = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSV);
            rs = ps.executeQuery();
            while (rs.next()) {
                DiemSV dsv = new DiemSV(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getDouble(6));
                listDiem.add(dsv);
            }
            return listDiem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addDSV(DiemSV dsv) {
        sql = "INSERT INTO grade(masinhvien, tienganh, tinhoc, giaoducthechat) VALUES (?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            System.out.println("Ma sv " + dsv.getMaSV());
            ps.setObject(1, dsv.getMaSV());
            ps.setObject(2, dsv.getTiengAnh());
            ps.setObject(3, dsv.getTinHoc());
            ps.setObject(4, dsv.getGDTC());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteDSV(String maSV) {
        sql = "DELETE FROM grade WHERE masinhvien = ?";
//        System.out.println("delete sv " + maSV);
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSV);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateSV(DiemSV dsv, String maSV) {
        sql = "UPDATE grade SET tienganh = ? WHERE masinhvien = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, dsv.getTiengAnh());
            ps.setObject(2, dsv.maSV);
            return ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("update error");
            e.printStackTrace();
            return 0;
        }
    }
}
