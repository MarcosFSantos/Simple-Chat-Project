/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

import br.com.chat.models.DAO.DataSource;
import br.com.chat.models.DAO.MessageDAO;
import br.com.chat.models.Message;
import br.com.chat.models.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * 
 * Classe responsável pela regra de negócio da página de principal.
 * 
 * @author Marcos
 */
public class PageController {
    
    DataSource dataSource = new DataSource();
    
    /**
     * Esse método retorna as menssagens do banco de dados no formato de uma tabela.
     * 
     * @param dataModel
     * @return model
     */
    public TableModel showMessages(TableModel dataModel){
        MessageDAO messageDao = new MessageDAO(dataSource);
        List<Message> list = messageDao.read();
        DefaultTableModel model = (DefaultTableModel) dataModel;
        
        if (list != null){
            model.setNumRows(0);
            
            for (Message m : list) {
                model.addRow(
                        
                        new Object[]{
                            m.getId(), 
                            m.getText(), 
                            m.getTime(), 
                            m.getUserId()
                        }
                        
                );
            }
            
        }
        
        return model;
    }
    
    /**
     * Esse método registra uma nova mensagem no banco de dados.
     * 
     * @param text
     * @param user
     */
    public void sendMessage(String text, User user){
        Message message = new Message();
        String time = currentDateTime();
        
        message.setText(text);
        message.setTime(time);
        
        try{
            
            MessageDAO messageDao = new MessageDAO(dataSource);
            messageDao.create(message, user);
            
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error in save data: "+e.getMessage());
            
        }
        
    }
    
    /**
     * Esse método retorna a data e o horário atual.
     * 
     * @return
     */
    public String currentDateTime(){
        String currentDateTime;
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        currentDateTime = dtf.format(LocalDateTime.now());
        
        return currentDateTime;
    }
}