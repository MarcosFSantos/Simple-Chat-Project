/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.models.DAO;

/**
 *
 * Classe responsável por manipular os dados dos objetos no banco de dados.
 * 
 * @author Marcos
 */
public class UserDAO {
    
    private DataSource dataSource;
    
    /**
     *
     * Construtor da classe UserDAO.
     * 
     * @param dataSource
     */
    public UserDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
}
