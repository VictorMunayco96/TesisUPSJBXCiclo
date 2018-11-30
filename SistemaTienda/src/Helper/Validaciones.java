/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wendy
 */
public class Validaciones {
    public static Integer tryParse(Object obj) {
        Integer retVal;
        try {
            retVal = Integer.parseInt((String) obj);
        } catch (NumberFormatException nfe) {
            retVal = 0;
        }
        return retVal;
    }
    
    public static boolean ValidaEmail(String obj){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
        Matcher mather = pattern.matcher(obj);
        
        
           
 
       
 
       
        
        
        return mather.find();
    }
}
