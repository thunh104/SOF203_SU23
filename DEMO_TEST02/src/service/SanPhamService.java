package service;

import interface_sp.Inf_SP;
import model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamService implements Inf_SP {

    String sql = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<SanPham> getAll() {
        sql = "SELECT Id, Ma, Ten, TrangThai, SoLuong, GiaBan FROM SanPham";
        List<SanPham> listSP = new ArrayList<SanPham>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5), rs.getDouble(6));
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SanPham getSP(String ma){
        sql = "SELECT Id, Ma, Ten, TrangThai, SoLuong, GiaBan FROM SanPham WHERE Ma = ?";
        SanPham sp = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while(rs.next()){
                sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5), rs.getDouble(6));
            }
            return sp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public int insert_SP(SanPham sp) {
        sql = "INSERT INTO SanPham(Ma, Ten, TrangThai, SoLuong, GiaBan) VALUES (?, ?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.isTrangThai());
            ps.setObject(4, sp.getSoLuong());
            ps.setObject(5, sp.getGiaBan());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update_SP(SanPham sp, String id) {
        sql = "UPDATE SanPham SET GiaBan = ? WHERE Id = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getGiaBan());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete_SP(String id) {
        sql = "DELETE FROM SanPham WHERE Id = ?";
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
