/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

import br.com.chat.models.DAO.DataSource;
import br.com.chat.models.User;
import br.com.chat.models.DAO.UserDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * 
 * Classe responsável pela regra de negócio da página de login.
 * 
 * @author Marcos
 */
public class LoginController {
    
    private String username;
    private String password;
    
    /**
     * Construtor da classe LoginController
     * 
     * @param username
     * @param password
     */
    public LoginController(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    /**
     * Esse método checa se os campos dados como parâmetros estâo ou não vazios.
     * 
     * @param field
     * @return
     */
    public boolean checkEmptyField(String field){
        if (field.equals("")){
            JOptionPane.showMessageDialog(null, "Fields can not be empty!");
            return true;
        }
        else{
            return false;
        }
    }
    
    public User searchInDatabase(String username){
        DataSource dataSource = new DataSource();
        UserDAO userDao = new UserDAO(dataSource);
        List<User> list = userDao.read();
        
        User result = new User();
        
        for(User u : list){
            
            if (u.getUsername().equals(username)){
                
                result.setId(u.getId());
                result.setUsername(u.getUsername());
                result.setPassword(u.getPassword());
                
                return result;
                
            }
        }
        
        return null;
    }
    
}
