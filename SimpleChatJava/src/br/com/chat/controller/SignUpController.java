/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

import javax.swing.JOptionPane;

/**
 * 
 * Classe responsável pela regra de negócio da página de cadastro de usuário.
 * 
 * @author Marcos
 */
public class SignUpController {
    private String username;
    private String password;
    
    public SignUpController(String username, String password, String confirmPassword){
        
        this.username = username;
        
        
        
    }
    
    /**
     * Esse método checa se os campos dados como parâmetros estâo ou não vazios.
     * 
     * @param field
     * @return boolean value
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
    
}
