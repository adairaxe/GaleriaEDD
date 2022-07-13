/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import TDAs.LinkedList;
import javafx.scene.image.Image;

public class Fotografia {
    
    private String nombre, descripcion, lugar;
    private Image imagen;
    private LinkedList <String> personas;

    public Fotografia(String nombre, String descripcion, String lugar, Image imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.imagen = imagen;
    }
    
    
     
}
