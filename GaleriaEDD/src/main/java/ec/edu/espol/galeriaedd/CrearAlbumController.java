/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.galeriaedd;

import TDAs.LinkedList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    
    public LinkedList<Album>albumes;
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
            crearArchivo(etNombre, etDescripcion);
            if(creaAlbum.exists())               
                System.out.println("El nombre está ocupado");         
            else{  
                //guardarRegistro(etNombre, etDescripcion);
                creaAlbum.mkdir();
                agregarPortadaAlbum(creaAlbum, rutaPortadaDefecto);      
                //cargarFotos.agregarPortadaAlbum(creaAlbum, rutaPortada);       
            }
                
        FXMLLoader loader = App.loadFXML("primary");
        Parent root= loader.load();
        App.scene.setRoot(root);

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
    public void crearArchivo (String nombre, String descripcion){
                try {
            
           File file= new File(rutaAbsolutaAlbunmes  + "Albumes.txt");
           //String path =rutaAbsolutaAlbunmes  + "Albumes.txt";
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            //bw.newLine();
            bw.write(nombre+","+descripcion);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
        }
    
    }
        private void crearLinkedAlbum(){
        albumes = new LinkedList<>();
        try {
            Scanner input = new Scanner(new File(rutaAbsolutaAlbunmes+ "Albumes.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (!line.equals("\n")){
                    String[] linea = line.split(",");
                    Album nuevoAlbum = new Album(linea[0],linea[1]) {};
                    albumes.addLast(nuevoAlbum);
                }
            }
            input.close();
        } catch (FileNotFoundException ex) {
        }
        //return album;
    }

}
