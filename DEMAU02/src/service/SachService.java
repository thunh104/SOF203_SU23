package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Sach;

public class SachService {

    String sql = null;
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement ps = null;

    public List<Sach> getAll() {
        sql = "SELECT ID, MaSach, TenSach, TheLoai, DonGia FROM SACH";
        List<Sach> lists = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                lists.add(s);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Sach getSach(String maSach) {
        sql = "SELECT ID, MaSach, TenSach, TheLoai, DonGia FROM SACH WHERE MaSach = ?";
        Sach s = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSach);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Sach(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addSach(Sach s) {
        sql = "INSERT INTO SACH(MaSach, TenSach, TheLoai, DonGia) VALUES(?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, s.getMaSach());
            ps.setObject(2, s.getTenSach());
            ps.setObject(3, s.getTheLoai());
            ps.setObject(4, s.getDonGia());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int removeSach(int ID) {
        sql = "DELETE FROM SACH WHERE ID = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ID);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateSach(Sach s, int ID) {
        sql = "UPDATE SACH SET DonGia = ? WHERE ID = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, s.getDonGia());
            ps.setObject(2, ID);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
