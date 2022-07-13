package ec.edu.espol.galeriaedd;

import TDAs.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Album;

public class PrimaryController implements Initializable{

    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnAnt;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnNext;
    @FXML
    private ScrollPane panePhoto;
    
    private HBox images;
    private Button albumSelected;
    private LinkedList<Album> albumes;
    public final String rutaAbsolutaAlbunmes = "C:.\\Albumes\\";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         panePhoto.setContent(cargarAlbumes());
    }
    
    
    public PrimaryController( ) {
       
     //   cargarAlbumes();
    }
    
     public HBox cargarAlbumes(){        
        File carpeta = new File("albumes");
        images = new HBox();
        File[] listFiles = carpeta.listFiles();
        //LinkedList<Album> albunes = new LinkedList<>();
        for(File f: listFiles){
       
            if(f.isDirectory()){
                File album = new File(f.getPath());
                File[] fotos = album.listFiles();
                for(File a: fotos){
                   
                   if(a.getName().contains(".png")){  
                     ImageView img = new ImageView();
                     img.scaleXProperty().add(10);        
                     img.setImage(new Image(a.toURI().toString()));
                     img.setFitWidth(200);
                     img.setFitHeight(230);
                     Button b= new Button();  
                     b.setGraphic(img);
                     b.autosize();
                     b.setText(a.getName());
                     b.setContentDisplay(ContentDisplay.TOP);
                     b.setWrapText(true);
                     images.getChildren().add(b);
                     b.setOnMouseClicked((MouseEvent e)->{
                        try {
                            FXMLLoader loader = App.loadFXML("vistaDentroAlbum");
                            Parent root= loader.load();
                            App.scene.setRoot(root);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
//                     b.setOnAction(e -> { albumSelected=b;});
                   }
                }      
            }
           
        }
        //crearLinkedAlbum();
        return images; 
    }
     
     
    @FXML
    public void clickElimnar(ActionEvent e) {
        images.getChildren().remove(albumSelected);
    }
    
    
    @FXML
    private void crearAlbum(ActionEvent event) throws IOException {
        FXMLLoader loader = App.loadFXML("crearAlbum");
        Parent root= loader.load();
        App.scene.setRoot(root); 
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
