/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocar.java.dao;

import alocar.java.models.Perfil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.leite
 */
public class PerfilDAO {
    public List<Perfil> Buscar(String arg) throws SQLException{
        ResultSet rs;
        List perfis;
        Connection con = DriverManager.getConnection(""
                + "jdbc:mysql://localhost:3306/alocar_java?useSSL=false", "root", "");
        try (Statement stmt = con.createStatement()) {
            if (!(arg.isEmpty()) && !" ".equals(arg)) {
                rs = stmt.executeQuery("SELECT * FROM alocar_java.perfil "
                        + "WHERE (CONVERT(id_perfil USING utf8) "
                        + "LIKE " + arg + " OR CONVERT(nome_perfil USING utf8) "
                        + "LIKE " + arg);

            } else {
                rs = stmt.executeQuery("SELECT * FROM alocar_java.perfil");
            }
            perfis = new ArrayList();
            while (rs.next()) {
                perfis.add(popularPerfis(rs));
            }
            rs.close();
        }
        return perfis;
    }
    
    
    private Perfil popularPerfis(ResultSet rs) throws SQLException {
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(rs.getInt("id_perfil"));
        perfil.setNomePerfil(rs.getString("nome_perfil"));
        return perfil;
    }
    
    
    public void Inserir(Perfil perfil) throws SQLException {
        PreparedStatement stmt;
        try (Connection con = DriverManager.getConnection(""
                + "jdbc:mysql://localhost:3306/alocar_java?useSSL=false", "root", "")) {
            String sql = "INSERT INTO alocar_java.perfil ("
                    + "nome_perfil "
                    + "VALUES (?);";
            //11 campos (Matricula é auto_increment)
            stmt = con.prepareStatement(sql);
            stmt.setString(1, perfil.getNomePerfil());
           
            stmt.execute();
        }
        stmt.close();
    }
    
}
