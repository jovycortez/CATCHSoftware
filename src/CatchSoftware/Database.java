/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchSoftware;

import java.sql.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jovy
 */
public class Database {

    Connection dbconn = null;

    public static Connection ConnecttoDB() {
        try {
            System.out.println("Connected!");
            Class.forName("org.sqlite.JDBC");
            Connection dbconn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Jovy\\Documents\\GitHub\\posConsole\\POSConsoleDatabase.sqlite");
            //Connection dbconn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Flagg\\Documents\\GitHub\\posConsole\\POSConsoleDatabase.sqlite");
            return dbconn;
        } catch (Exception e) {
            System.out.println("Not Connected!");
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
//This method loads the database itemName and itemPrice to an arraylist

    public Object[][] LoadMenu() {
        // ConnecttoDB();
        //Coming from an array of elements
        Object[][] loadedMenu = null ;
        ResultSet rs = null;
        Statement dbStatement = null;

        System.out.println("outside try");
        String itemPrice = null;
        try {
            System.out.println(" try");
            dbStatement = ConnecttoDB().createStatement();
            rs = dbStatement.executeQuery("SELECT COUNT(*) FROM MenuDB; ");
            //Columns in sql starts from 1
            int numberOfRows = rs.getInt(1);
           
            loadedMenu = new Object[numberOfRows][2];

            rs = dbStatement.executeQuery("SELECT itemNameDB, itemPriceDB FROM MenuDB;");
            int i = 0;

            while (rs.next()) {
 
                loadedMenu[i][0] = rs.getString("itemNameDB");
                loadedMenu[i][1] = rs.getDouble("itemPriceDB");
               // System.out.println(i+" "+loadedMenu[i ][0]+" "+ loadedMenu[i][1]);
               i++;
            }
            return loadedMenu;
        } catch (Exception e) {

            System.out.println(e);
        }

       return loadedMenu;
    }

    //This Does Not Work
    public void Login() {
        // ConnecttoDB();
        ResultSet rs = null;
        Statement dbStatement = null;

        System.out.println("outside try");
        String itemPriceDB = "";
        try {
            System.out.println(" try");
            dbStatement = ConnecttoDB().createStatement();

            rs = dbStatement.executeQuery("SELECT * FROM myTest;");

            while (rs.next()) {

                itemPriceDB = rs.getString("Test");

            }

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    //This is just a few sentences
    public void TimeCard(Employee empId, String Clockin, String Clockout) {

    }

    public void InsertSales() {
        // ConnecttoDB();
        ResultSet rs = null;
        Statement dbStatement = null;

        System.out.println("outside try");
        String Test = "";
        try {
            System.out.println(" try");
            dbStatement = ConnecttoDB().createStatement();

            rs = dbStatement.executeQuery("SELECT * FROM myTest;");

            while (rs.next()) {

                Test = rs.getString("Test");

            }
            //  return itemPriceDB;
        } catch (Exception e) {

            System.out.println(e);
        }

        // return itemPriceDB;
    }

}
