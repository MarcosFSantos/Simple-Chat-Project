/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

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
    
    
}
