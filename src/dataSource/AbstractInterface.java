/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import java.sql.Connection;
import java.util.ArrayList;
 
/**
 * 
 * @author Boyko
 * @param <T>
 */
public interface AbstractInterface<T> {

    //implements AbstractInterface
    //Saving information
    boolean overpoweredAbstractMethod(Class<T> tClass, ArrayList<T> listOfRequests, Connection connect) throws IllegalArgumentException, IllegalAccessException;
    
}
