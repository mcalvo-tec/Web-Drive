/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Ace
 */
public class User {
    // Instance Variables
    String id;
    String name; 
    String lastname;
    String username;
    String password;
  
    // Constructor Declaration of Class 
    public User(String name, String lastname, String id, 
                String username, String password) 
    { 
        this.name = name; 
        this.lastname = lastname; 
        this.id = id; 
        this.username = username;
        this.password = password;
    } 
}
