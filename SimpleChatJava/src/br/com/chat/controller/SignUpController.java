/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

import br.com.chat.models.DAO.DataSource;
import br.com.chat.models.DAO.UserDAO;
import br.com.chat.models.User;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * Classe responsável pela regra de negócio da página de cadastro de usuário.
 * 
 * @author Marcos
 */
public class SignUpController extends UserAccount {
    private String confirmPassword;
    
    DataSource dataSource = new DataSource();
    
    /**
     * Construtor da classe SignUpController.
     *
     * @param username
     * @param password
     * @param confirmPassword
     */
    public SignUpController(String username, String password, String confirmPassword){
        
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        
    }
    
    /**
     * Esse método passa as informações do usuário para o método create() da classe de acesso ao banco de dados, criando assim a conta do usuário no banco de dados.
     */
    public void createUser(){
        
        try {
            
            User user = new User();
            UserDAO userDao = new UserDAO(dataSource);

            user.setUsername(username);
            user.setPassword(password);
            userDao.create(user);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error in save data: "+ex.getMessage());
            
        }
        
        
    }

    /**
     * Esse método verifica se os campos digitados pelo usuáio são ou não válidos.
     */
    @Override
    public void validateFields(){
        if (checkEmptyField(username) == false 
                &&  checkEmptyField(password) == false 
                &&  checkEqualsPassword(password, confirmPassword)
            ){
            
            createUser();
            
        }
    }
    
    /**
     * Esse método checa se os campos dados como parâmetros estâo ou não vazios.
     * 
     * @param field
     * @return valor boleano
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
     * Esse método checa se a senha e a senha de confirmação dadas pelo usário são iguais.
     * 
     * @param password
     * @param confirmPassword
     * @return valor boleano
     */
    public boolean checkEqualsPassword(String password, String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Password must be the same!");
            return false;
        }
    }
    
}
