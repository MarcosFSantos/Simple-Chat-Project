/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.models.DAO;

import br.com.chat.models.User;
import com.mysql.cj.protocol.Resultset;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Classe responsável por manipular os dados dos objetos no banco de dados.
 * 
 * @author Marcos
 */
public class UserDAO {
    
    private DataSource dataSource;
    
    /**
     *
     * Construtor da classe UserDAO.
     * 
     * @param dataSource
     */
    public UserDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    /**
     * Retorna todos os usuários do banco de dados no formato de uma lista de objetos.
     * 
     * @return data
     */
    public List<User> read(){
        List<User> data = new ArrayList<>();
        
        try{
            
            String SQL = "SELECT * FROM chat.user;";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            
            return data;
            
        }
        catch(SQLException e){
            System.out.println("Error in retrieve data: "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;
        
    }
}
