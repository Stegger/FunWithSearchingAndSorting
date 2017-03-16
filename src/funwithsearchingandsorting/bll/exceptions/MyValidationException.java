/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsearchingandsorting.bll.exceptions;

/**
 *
 * @author Stegger
 */
public class MyValidationException extends RuntimeException
{

    public MyValidationException(String message)
    {
        super(message);
    }

    public MyValidationException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
}
