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

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ROOMS {
    // CREATE A FONCTION TO DISPLAY ALL ROOMS TYPE IN JTABLE 
    // CREATE A FONCTION TO FILL A COMBOBOX WITH THE ROOMS ID
    MYCONNECTION myconnection=new MYCONNECTION();
    public void FillRoomsTYPEJTable (JTable table){
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery= "SELECT * FROM 'type'";
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
                tableModel.addRow(row);


            }
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public void FillRoomsTYPEJCombobox (JComboBox comboBox){
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery= "SELECT * FROM 'type'";
        try {
            ps=myconnection.createConnection().prepareStatement(selectQuery);
            rs=ps.executeQuery();
            
            while(rs.next()){
               
                comboBox.addItem(rs.getInt(1));


            }
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
        }
    }
      

    public boolean Addroom(int roomnumber, String type  , String phone)
    {
       PreparedStatement st;
       
       String addQuery="INSERT INTO rooms('roomnumber', 'type', 'phone', 'reserved') VALUES (?,?,?,?)" ;
       try {
        st=myconnection.createConnection().prepareStatement(addQuery);
           st.setInt(1, roomnumber);
           st.setString(2, type);
           st.setString(3, phone);
           st.setString(4, "no");
           

          return st.executeUpdate()>0;

         } catch (SQLException e) {
        // TODO Auto-generated catch block
        Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
        return false;
            }

    }
    public boolean editclient(int roomnumber, String type  , String phone, String isReserved) {
        PreparedStatement st;
       
        String editQuery="UPDATE 'rooms' SET 'type'=? ,'phone' = ?, 'isReserved' = ?  WHERE 'roomnumber' = ?" ;
        try {
         st=myconnection.createConnection().prepareStatement(editQuery);
            st.setInt(1, roomnumber);
            st.setString(2,  type);
            st.setString(3, phone);
            st.setString(4,isReserved);

 
            return st.executeUpdate()>0 ;
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
         return false;
     }
    }

 public boolean Removeroom (int roomnumber){
        PreparedStatement st;
       
        String deleteQuery="DELETE FROM 'rooms' WHERE 'roomnumber'=?" ;
        try {
         st=myconnection.createConnection().prepareStatement(deleteQuery);
           
            st.setInt(1, roomnumber);
 
            return st.executeUpdate()>0 ;
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
         return false;
     } 

    }

}
