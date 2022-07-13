/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import TDAs.LinkedList;
import javafx.scene.image.Image;

/**
 *
 * @author USER
 */
public class Album {
    String nombre;
    String descripcion;
    String portada;
    LinkedList<Image> fotos;


    
    public Album(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = "C:.\\Portada\\Portada.png";
    }
    public Album(String nombre, String descripcion,String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public LinkedList<Image> getFotos() {
        return fotos;
    }
    
    
    public Image getPortadaF(){
        return fotos.get(0);
        
    }
    
    public void addImage(String path){
        Image i = new Image(path);
        fotos.addLast(i);
    }

}