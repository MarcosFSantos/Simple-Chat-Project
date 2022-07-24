/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.chat.controller;

import br.com.chat.models.DAO.DataSource;
import br.com.chat.models.DAO.MessageDAO;
import br.com.chat.models.DAO.UserDAO;
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
        UserDAO userDao = new UserDAO(dataSource);
        List<Message> listMessages = messageDao.read();
        List<User> listUsers = userDao.read();
        DefaultTableModel model = (DefaultTableModel) dataModel;
        
        if (listMessages != null){
            model.setNumRows(0);
            
            for (Message m : listMessages) {
                String username;
                
                /*
                
                Vai procurar na lista de usuários existentes o usuario que mandou a mensagem e então mandar as informações
                da mensagem para a tabela, contendo tabém  o username do usuário.
                
                */
                for (User u : listUsers) {
                    if (m.getUserId() == u.getId()){
                        username = u.getUsername();
                        
                        model.addRow(
                            new Object[]{
                                m.getId(),
                                m.getUserId(),
                                username,
                                m.getTime(), 
                                m.getText()
                            }
                        );
                        
                    }
                }
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
            JOptionPane.showMessageDialog(null, "Message send.");
            
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
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        currentDateTime = dtf.format(LocalDateTime.now());
        
        return currentDateTime;
    }
    
    /**
     * Esse método exclui uma mensagem do banco de dados.
     * 
     * @param dataModel
     * @param selectedRow
     */
    public void deleteMessage(TableModel dataModel, int selectedRow){
        
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(null, "First, select the message you want to delete.");
        }
        else{
            
            int id = (int) dataModel.getValueAt(selectedRow, 0);
            
            try{
                
                MessageDAO messageDao = new MessageDAO(dataSource);
                Message message = new Message();
                
                message.setId(id);
                
                messageDao.delete(message);
                
                JOptionPane.showMessageDialog(null, "Message deleted sulcefully.");
                
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "error in exclude data: "+e.getMessage());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "error: "+e.getMessage());
            }
            
        }
        
    }
}
