/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * Classe que faz a conexão com o banco de dados MySQL.
 * 
 * @author Marcos
 */
public class DataSouce {
    
    private String username;
    private String password;
    
    private String hostname;
    private int port;
    private String database;
    
    private Connection connection;
    
    /**
     * Método resposável por estabelecer a conexão e retornar qualquer erro.error establishing database connection
     */
    private void createConnection(){
    /*
    Preencha as variáveis abaixo com os seguintes dados:

        username - nome do seu usuário MySQL.
        hostname - nome do host da conexão MySQL onde o banco de dados está.
        port - porta da conexão MySQL onde o banco de dados está.
        password - senha da conexão MySQL caso haja.
        database - nome do seu banco de dados.

    */
        try{
            
            
            username = "";
            hostname = "";
            port = 0000;
            password = "";
            database = "";
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error establishing database connection: "+e.getMessage());
        }
        
    }
    
    //String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
    
    
}
