/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetpoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Client {
    // create a fonction to add a client
    // create a fonction to edit the selected client
    // create a fonction to remove the selected client
    // create a fonction to return a list of all clients

    MYCONNECTION myconnection =new MYCONNECTION();
    /**
     * @param fname
     * @param lname
     * @param phone
     * @param email
     * @return
     */
    public boolean Addclient(String fname, String lname , String phone  , String email )
    {
       PreparedStatement st;
       
       String addQuery="INSERT INTO client (firstname, lastname, phone, email) VALUES (?,?,?,?)" ;
       try {
        st=myconnection.createConnection().prepareStatement(addQuery);
           st.setString(1, fname);
           st.setString(2,  lname);
           st.setString(3, phone);
           st.setString(4, email);

          return st.executeUpdate()>0;

         } catch (SQLException e) {
        // TODO Auto-generated catch block
        Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
        return false;
            }

    }
    public boolean editclient(int idclient,String fname, String lname , String phone  , String email) {
        PreparedStatement st;
       
        String editQuery="UPDATE 'client' SET phone = ?, email = ?,fname=? , lname=? WHERE idclient = ?;" ;
        try {
         st=myconnection.createConnection().prepareStatement(editQuery);
            st.setString(1, fname);
            st.setString(2,  lname);
            st.setString(3, phone);
            st.setString(4, email);
            st.setInt(5, idclient);
 
            return st.executeUpdate()>0 ;
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
         return false;
     }
    }

    public boolean Removeclient (int idclient){
        PreparedStatement st;
       
        String deleteQuery="DELETE FROM 'client' WHERE 'idclient'=?" ;
        try {
         st=myconnection.createConnection().prepareStatement(deleteQuery);
           
            st.setInt(1, idclient);
 
            return st.executeUpdate()>0 ;
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
         return false;
     } 

    }
   
    
    public void FilltableJTable (JTable table){
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery= "SELECT * FROM client ";
        try {
            ps=myconnection.createConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            DefaultTableModel tableModel =(DefaultTableModel)table.getModel();
            Object[] row;
            while(rs.next()){
                row=new Object[5];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                tableModel.addRow(row);


            }
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
