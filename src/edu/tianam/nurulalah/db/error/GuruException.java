/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.error;

/**
 *
 * @author THOSHIBA
 */
public class GuruException extends Exception  {
    
    /**
     * Creates a new instance of <code>SnatriException</code> without detail
     * message.
     */
    public GuruException() {
    }

    /**
     * Constructs an instance of <code>SnatriException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GuruException(String msg) {
       super(msg);
    }
}
