
package com.emergentes.dao;

import com.emergentes.modelo.Seminarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDAOimpl extends ConexionDB implements SeminarioDAO {

    @Override
    public void insert(Seminarios seminarios) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO seminarios (titulo, expositor, fecha, hora, cupo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminarios.getTitulo());
            ps.setString(2, seminarios.getExpositor());
            ps.setString(3, seminarios.getFecha());
            ps.setString(4, seminarios.getHora());
            ps.setInt(5, seminarios.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seminarios seminarios) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE seminarios SET titulo=?, expositor=?, fecha=?, hora=?, cupo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminarios.getTitulo());
            ps.setString(2, seminarios.getExpositor());
            ps.setString(3, seminarios.getFecha());
            ps.setString(4, seminarios.getHora());
            ps.setInt(5, seminarios.getCupo());
            ps.setInt(6, seminarios.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE from seminarios where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Seminarios getById(int id) throws Exception {
        Seminarios sem = new Seminarios();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seminarios where id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setExpositor(rs.getString("expositor"));
                sem.setFecha(rs.getString("fecha"));
                sem.setHora(rs.getString("hora"));
                sem.setCupo(rs.getInt("cupo"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return sem;
    }

    @Override
    public List<Seminarios> getAll() throws Exception {
        List<Seminarios> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seminarios>();

            while (rs.next()) {
                Seminarios sem = new Seminarios();
                
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setExpositor(rs.getString("expositor"));
                sem.setFecha(rs.getString("fecha"));
                sem.setHora(rs.getString("hora"));
                sem.setCupo(rs.getInt("cupo"));

                lista.add(sem);
            }
            rs.close();;
            ps.close();;

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
