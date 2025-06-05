/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Bodega; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class BodegaDAO {

    private static final String SQL_SELECT = "SELECT pkid, fkidTipobodega, nombre, direccion, estado FROM bodega";
    private static final String SQL_INSERT = "INSERT INTO bodega(pkid, fkidTipobodega, nombre, direccion, estado) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE bodega SET fkidTipobodega=?, nombre=?, direccion=?, estado=? WHERE pkid = ?";
    private static final String SQL_DELETE = "DELETE FROM bodega WHERE pkid=?";
    private static final String SQL_QUERY = "SELECT pkid, fkidTipobodega, nombre, direccion, estado FROM bodega WHERE pkid = ?";

    public List<Bodega> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bodega cine = null;
        List<Bodega> bodega = new ArrayList<Bodega>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int pkid = rs.getInt("pkid");
                String fkidTipobodega = rs.getString("fkidTipobodega");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estado = rs.getString("estado");
                
                cine = new Bodega();
                cine.setPkid(pkid);
                cine.setFkidTipobodega(fkidTipobodega);
                cine.setNombre(nombre);
                cine.setDireccion(direccion);
                cine.setEstado(estado);
                
                bodega.add(cine);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bodega;
    }

    public int insert(Bodega cine) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cine.getPkid());
            stmt.setString(2, cine.getFkidTipobodega());
            stmt.setString(3, cine.getNombre());
            stmt.setString(4, cine.getDireccion());
            stmt.setString(5, cine.getEstado());

            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Bodega cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, cine.getFkidTipobodega());
            stmt.setString(2, cine.getNombre());
            stmt.setString(3, cine.getDireccion());
            stmt.setString(4, cine.getEstado());
            stmt.setInt(5, cine.getPkid());
            
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Bodega cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cine.getPkid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Bodega query(Bodega cine) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Bodega> bodega = new ArrayList<Bodega>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cine.getPkid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int pkid = rs.getInt("pkid");
                String fkidTipobodega = rs.getString("fkidTipobodega");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estado = rs.getString("estado");
                
                cine = new Bodega();
                cine.setPkid(pkid);
                cine.setFkidTipobodega(fkidTipobodega);
                cine.setNombre(nombre);
                cine.setDireccion(direccion);
                cine.setEstado(estado);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cine; 
    }

        
}
