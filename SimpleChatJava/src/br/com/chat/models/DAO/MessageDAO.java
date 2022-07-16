/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.models.DAO;

import br.com.chat.models.Message;
import br.com.chat.models.User;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * Classe responsável por manipular os dados dos objetos no banco de dados.
 * 
 * @author Marcos
 */
public class MessageDAO {
    
    private DataSource dataSource;
    
    /**
     * Construtor da classe MessageDAO.
     * 
     * @param dataSource
     */
    public MessageDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    /**
     * Retorna todos as mensagens do banco de dados no formato de uma lista de objetos.
     * 
     * @return data
     */
    public List<Message> read(){
        List<Message> data = new ArrayList<>();
        String SQL = "SELECT * FROM chat.message";
        
        try{
            
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Message message = new Message();
                
                message.setId(rs.getInt("id"));
                message.setText(rs.getString("text"));
                message.setTime(rs.getString("time"));
                message.setUserId(rs.getInt("user_id"));
                
                data.add(message);
            }
            
            ps.close();
            return data;
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in retrieve data: "+ex.getMessage());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        
        return null;
    }
    
    public void create(Message message, User user){
        String SQL = "insert into chat.message(text, time, user_id) values(?, ?, ?)";
        
        try{
            
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            
            ps.setString(1, message.getText());
            ps.setString(2, message.getTime());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in retrieve data: "+ex.getMessage());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        
    }
}
