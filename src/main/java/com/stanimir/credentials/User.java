/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.credentials;

/**
 *
 * @author Stanimir Donchev
 */
public class User 
{
    private String username;
    private String password;

    public User(String username, String password) 
    {
        this.setUsername(username);
        this.setPassword(password);
    }
    
    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
    
    
}
