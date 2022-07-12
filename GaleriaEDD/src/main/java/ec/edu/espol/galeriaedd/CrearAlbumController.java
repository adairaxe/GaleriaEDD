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
import javafx.scene.control.TextField;
import modelo.Album;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CrearAlbumController implements Initializable {

    @FXML
    private Button btcrear;
    @FXML
    private TextField tfnombre;
    @FXML
    private TextField tfdescripcion;
    
    
    public final String rutaAbsolutaAlbunmes = "C:.\\Albumes\\"; 
    
    public final File carpeta = new File("albumes\\portadaDefault.png");
    
    public final Path rutaPortadaDefecto = carpeta.toPath();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crearAlbum(ActionEvent event) throws IOException {
        String etNombre = tfnombre.getText();
        String etDescripcion = tfdescripcion.getText();        
        if(!etNombre.isEmpty() && !etDescripcion.isEmpty()){
            Album nuevoAlbum = new Album(etNombre, etDescripcion);             
            File creaAlbum = new File(rutaAbsolutaAlbunmes + nuevoAlbum.getNombre());

            if(creaAlbum.exists())               
                System.out.println("El nombre está ocupado");         
            else{  
                //guardarRegistro(etNombre, etDescripcion);
                creaAlbum.mkdir();
                agregarPortadaAlbum(creaAlbum, rutaPortadaDefecto);      
                //cargarFotos.agregarPortadaAlbum(creaAlbum, rutaPortada);       
            }
        }
    }
    
    
    public static void agregarPortadaAlbum(File nombreAlbum, Path rutaOrigen){
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
