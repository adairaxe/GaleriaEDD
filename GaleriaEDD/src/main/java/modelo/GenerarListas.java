/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.LinkedList;



/**
 *
 * @author USER
 */
public abstract class GenerarListas<E> {
    
    public abstract ArrayList<E> generarArrayList(String nombreArchivo);
    
    public abstract LinkedList<E> generarLinkedList(String nombreArchivo);
    
    

    
}
