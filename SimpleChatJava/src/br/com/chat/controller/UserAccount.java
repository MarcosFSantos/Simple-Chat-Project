/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

/**
 * 
 * Classe abstrata com contéudo comum as classes LoginController e SignUpController.
 * 
 * @author Marcos
 */
public abstract class UserAccount {
    
    protected String username;
    protected String password;
    
    abstract protected boolean checkEmptyField(String field);
    
    abstract protected void validateFields();
    
}
