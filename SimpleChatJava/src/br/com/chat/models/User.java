/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.models;

/**
 *
 * Classe que representa a conta de um usuário no sistema.
 * 
 * @author Marcos
 */
public class User {
    
    private int id;
    private String username;
    private String password;

    /**
     * Retorna o atributo id da instância.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Atribui um valor ao atributo id da instância.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o atributo username da instância.
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Atribui um valor ao atributo username da instância.
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retorna o atributo password da instância.
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Atribui um valor ao atributo password da instância.
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
}
