/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

import br.com.chat.models.DAO.DataSource;
import br.com.chat.models.User;
import br.com.chat.models.DAO.UserDAO;
import br.com.chat.view.Page;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * 
 * Classe responsável pela regra de negócio da página de login.
 * 
 * @author Marcos
 */
public class LoginController extends UserAccount {
    
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
     * @return boolean value
     */
    @Override
    public boolean checkEmptyField(String field){
        if (field.equals("")){
            JOptionPane.showMessageDialog(null, "Fields can not be empty!");
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Retorna o usuário do banco de dados que contém o username passado como parâmetro.
     * 
     * @param username
     * @return result
     */
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
                
                dataSource.closeConnection();
                return result;
                
            }
        }
        
        return null;
    }
    
    /**
     * Esse método verifica se os campos digitados pelo usuáio são ou não válidos, se for, 
     * ele irá chamar o método que verifica a conta e abre a página principal e retornar se a pagina foi aberta.
     * 
     * @return isOpen
     */
    @Override
    public boolean validateFields(){
        boolean isOpen = false;
        if (checkEmptyField(username) == false 
                &&  checkEmptyField(password) == false
            ){
            
            User user;
            
            if (searchInDatabase(username) != null){
                user = searchInDatabase(username);
                isOpen = validateUser(user);
            }
            else{
                JOptionPane.showMessageDialog(null, "Account does not exist!");
                isOpen = false;
            }
            
        }
        return isOpen;
    }
    
    /**
     * Esse método vai validar se a senha digita pelo o usuário é a mesma presente no banco de dados daquela conta.
     * @param user
     * @return boolean value
     */
    public boolean validateUser(User user){
        if (user.getPassword().equals(password)){
            Page page = new Page();
            page.setUser(user);
            page.setVisible(true);
            System.out.println("password correct");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "The username or password you entered is incorrect!", "Error", 3);
            return false;
        }
    }
}
