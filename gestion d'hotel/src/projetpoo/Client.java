/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetpoo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
}
