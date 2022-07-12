/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.galeriaedd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import modelo.Album;
import modelo.Fotografia;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class CargarFotoController implements Initializable {


    @FXML
    private Label lbnombreAlbum;
    @FXML
    private TextField etnombre;
    @FXML
    private TextField etdescripcion;
    @FXML
    private TextField etlugar;
    @FXML
    private TextField etpersonas;
    @FXML
    private Button btguardarFoto;
    
    
    @FXML
    private ImageView ivfoto;
    
    private FileChooser fc= new FileChooser();
    
    public final String rutaAbsolutaAlbunmes = "C:.\\Albumes\\"; 
    
    public Path rutaFotoCopiada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void guardarFotografia(ActionEvent event) {
        String etNombre = etnombre.getText();
        String etDescripcion = etdescripcion.getText();
        String etLugar = etlugar.getText();
        String etPersoans = etpersonas.getText();
        Image ivFoto = ivfoto.getImage();
        if(!etNombre.isEmpty() && !etDescripcion.isEmpty() && !etLugar.isEmpty() && ivFoto != null){
            
            //public Fotografia(String nombre, String descripcion, String lugar, Image imagen)
            Fotografia fotoNueva = new Fotografia(etNombre, etDescripcion, etLugar, ivFoto);  
            
            //Cargar el nombre del album en que estas para acceder a su ruta, SE NECESITA TENER EL NOMBRE DEL ALBUM
            File creaAlbum = new File(rutaAbsolutaAlbunmes + lbnombreAlbum);
            agregarfoto(creaAlbum, rutaFotoCopiada);
            
        }
    }

    @FXML
    private void subirFoto(MouseEvent event) {
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        File seledFile= fc.showOpenDialog(null);
        
        if (seledFile!= null){
            Image img = new Image(seledFile.toURI().toString());
            rutaFotoCopiada = seledFile.toPath();
            ivfoto.setImage(img);
        }
    }
    
    
    public static void agregarfoto(File nombreAlbum, Path rutaOrigen){
        try {
            Path rutaFueraAlbum = Paths.get(nombreAlbum.getAbsolutePath());
            String stringDentroAlbum = rutaFueraAlbum.toString() + "/portadaDefault.png";
            Path rutaDentroAlbum = Paths.get(stringDentroAlbum);
            Files.copy(rutaOrigen, rutaDentroAlbum, REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
