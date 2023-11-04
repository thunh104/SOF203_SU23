package service;

import interface_xm.Inf_XeMay;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.XeMay;

public class XeMayService implements Inf_XeMay {

    String sql = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<XeMay> getAll() {
        sql = "SELECT Id, Ma, Ten, TrangThai, GiaBan, GiaNhap, SoLuong FROM XeMay";
        List<XeMay> listXM = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XeMay xm = new XeMay(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
                listXM.add(xm);
            }
            return listXM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public XeMay getXM(String ma) {
        sql = "SELECT Id, Ma, Ten, TrangThai, GiaBan, GiaNhap, SoLuong FROM XeMay WHERE Ma = ?";
        XeMay xm = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                xm = new XeMay(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
            }
            return xm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insert_XM(XeMay xm) {
        sql = "INSERT INTO XeMay(Ma, Ten, TrangThai, GiaBan, GiaNhap, SoLuong) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xm.getMaXe());
            ps.setObject(2, xm.getTenXe());
            ps.setObject(3, xm.isTrangThai());
            ps.setObject(4, xm.getGiaBan());
            ps.setObject(5, xm.getGiaNhap());
            ps.setObject(6, xm.getSoLuong());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update_XM(XeMay xm, String id) {
        sql = "UPDATE XeMay SET GiaBan = ? WHERE Id = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xm.getGiaBan());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete_XM(String id) {
        sql = "DELETE FROM XeMay WHERE Id = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
