/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocar.java;

import alocar.java.dao.PerfilDAO;
import alocar.java.models.Perfil;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Richarde
 */
public class testes {
    public static void main(String[] args) throws SQLException{
        Perfil perfil = new Perfil();
        PerfilDAO pdao = new PerfilDAO();
        perfil.setNomePerfil("ADMINISTRADOR");
       
        
        List <Perfil> perfis;
        perfis = pdao.Buscar("");
        
        perfis.stream().forEach((itens) -> {
            System.out.println(itens.getNomePerfil());
        });
        
    }
}
