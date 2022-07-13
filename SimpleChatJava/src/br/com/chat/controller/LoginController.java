/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

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
    
}
