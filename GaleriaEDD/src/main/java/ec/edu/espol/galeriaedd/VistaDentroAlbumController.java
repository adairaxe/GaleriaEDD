/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.galeriaedd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.Album;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class VistaDentroAlbumController implements Initializable {


    @FXML
    private Label lbnombreAlbum;
    @FXML
    private Button btanterior;
    @FXML
    private Button btsiguiente;
    @FXML
    private Button btsubirFoto;
    private Album carga;
    public final String rutaAbsolutaAlbunmes = "C:.\\Albumes\\";
    public Album fotos;
    /**
    
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void regresarImagen(ActionEvent event) {
        
    }

    @FXML
    private void avanzarImagen(ActionEvent event) {
        
    }

    @FXML
    private void abrirVentanaCargarFoto(ActionEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("cargarFoto");
        Parent root= loader.load();
        App.scene.setRoot(root); 
    }
    
    
    // PARA SACAR EL TITULO DEl album persentado en la PRIMARYCONTROLLER Y SETEARLO EN EL LABEL lbnombreAlbum
    public void recibeNombreAlbum(PrimaryController ventanaPrincipal, String nombreAlbum){
        lbnombreAlbum.setText(nombreAlbum);
    }
    public void cargarAlbum(String path){
    
    } 
    @FXML
     public void regresarPrincipal (ActionEvent event) throws IOException {
    FXMLLoader loader = App.loadFXML("primary");
        Parent root= loader.load();
        App.scene.setRoot(root);
    }
    
    /*private void crearLinkedAlbum(){
        //LinkedList <Album> album = new LinkedList<>();
        try {
            Scanner input = new Scanner(new File(rutaAbsolutaAlbunmes));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                //ArrayList<String> parametros= new ArrayList<>();
                if (!line.equals("\n")){
                    String[] linea = line.split(",");
                    Album nuevoAlbum = new Album(linea[0],linea[1]) {};
                    fotos.getFotos().addLast(nuevoAlbum);
                }
            }
            input.close();
        } catch (FileNotFoundException ex) {
        }
        //return album;
    }*/
 }
    

