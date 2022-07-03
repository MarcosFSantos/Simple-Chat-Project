/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.models;

/**
 *
 * Classe que representa uma mensagem enviada por um usuário no sistema.
 * 
 * @author Marcos
 */
public class Message {
    
    private String time;
    private String text;

    /**
     * Retorna o atributo time da instância.
     * 
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * Atribui um valor ao atributo time da instância.
     * 
     * @param time 
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Retorna o atributo text da instância.
     * 
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Atribui um valor ao atributo text da instância.
     * 
     * @param text 
     */
    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
