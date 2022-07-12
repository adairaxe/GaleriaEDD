/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author USER
 */
public class AlbumPrivado extends Album{
    private String clave;

    public AlbumPrivado(String nombre, String descripcion/* Image portada*/, String clave) {
        super(nombre, descripcion/*, portada*/);
        this.clave = clave;
    }
    
    
    
    
    
}
