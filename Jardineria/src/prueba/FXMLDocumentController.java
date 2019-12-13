/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Historial.HistorialFotografia;
import Producto.Producto;
import RegistroRiego.RegistroRiego;
import TipoProducto.TipoProducto;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;


/**
 *
 * @author SAINZ
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private AnchorPane ventana_inicio,ventana_menu,ventana_agregarTipo,ventana_agregarProducto,ventana_registroRiego,ventana_registroHistorial,ventana_presentacion;
    
    @FXML
    private Label label;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnPresentacion;
               
    @FXML
    private ComboBox combo=new ComboBox();
   //------------------------------------------------------------------------------------
   
   @FXML
    private Tab btnTP; //Tipo de Productos
    
    @FXML
    private TableView<TipoProducto> tablaTipoProducto; //Tabla general
    
    @FXML
    private TableColumn<TipoProducto, String> txtIdCTP; // Columna 1
     
    @FXML
    private TableColumn<TipoProducto, String> txtCTP; // Columna 2
    
    ObservableList<TipoProducto> dataTP = FXCollections.observableArrayList();
    
    // Elementos * * * 
    @FXML
    private TextField textTipo;
    
    private int posicionTipo;
    
    @FXML
    private Button btnlistT; //Agregando Tipo de Producto
    
    @FXML
    private Button btnActualizarTP;
   
    //--------------------------------------------------------------- Producto ---------------------------------
    @FXML
    private Tab btnP; //Producto
     
    @FXML
    private TableView<Producto> tablaProducto; //Lista de Producto
    
    @FXML
    private TableColumn<Producto, String> txtIdCP; // Columna 1
 
    @FXML
    private TableColumn<Producto, String> txtCNombreP; // Columna 2
    
    @FXML
    private TableColumn<Producto, String> txtCTipoProducto; // Columna 3
    
    @FXML
    private TableColumn<Producto, String> txtCCondicionActual; // Columna 4
    
    @FXML
    private TableColumn<Producto, String> txtCFechaIngreso; // Columna 5 
    
    @FXML
    private TableColumn<Producto, String> txtCId_Tipo; // Columna 6
    
    ObservableList<Producto> dataP = FXCollections.observableArrayList();
    
    // Elementos * * *
    @FXML
    private ComboBox combo1 = new ComboBox();
    
    @FXML
    private TextField textNombreP;
    
    @FXML
    private TextField textTipoProducto;
    
    @FXML
    private TextField textCondicionP;
    
    @FXML
    private DatePicker textFechaP;
    @FXML
    private Button btnActualizarP;
    
    int posicionProducto;
    
    @FXML
    private Button btnlistP; //Agregando Producto
   
    //------------------------------------------------------Registro Riego--------------------------------------
    @FXML
    private Tab btnRR; //Registro de Riego
    
    @FXML
    private TableView<RegistroRiego> tablaRegistroRiego; //Tabla General
    
    @FXML
    private TableColumn<RegistroRiego, String> txtIdCRiego; // Columna 1
    
    @FXML
    private TableColumn<RegistroRiego, String> txtCFechaRegistro; // Columna 2
    @FXML
    private TableColumn<RegistroRiego, String> txtCProductoRiego; // Columna 3
    
    @FXML
    private TableColumn<RegistroRiego, String> txtCId_ProductoR; // Columna 4
        
        
    ObservableList<RegistroRiego> dataRR = FXCollections.observableArrayList();
    
    //----- Elementos * * * 
    @FXML
    private DatePicker textDataRiego;
    
    @FXML
    private ComboBox combo2 = new ComboBox();
    
    @FXML
    private TextField txtIdRegistroRiego;
    @FXML
    private Button btnActualizarRR;
            
    @FXML
    private Button btnlistRR; //Agregando Registro de Riego
    @FXML
    private Button btnEditarRiego,btnEliminarRiego,btnEditarRiegoContinuar,btnEliminarRiegoContinuar,btnEditarContinuarRiego,btnAgregarR; 
    //--------------------------------------------------- Historial ---------------------------------
    
    @FXML
    private Tab btnHF; //Historial de Fotografia
    
    @FXML
    private TableView<HistorialFotografia> tablaHistorial; //Lista de Historial de Fotografia
    
    @FXML
    private TableColumn<HistorialFotografia, String> txtIdCHistorial; // Columna 1
    
    @FXML
    private TableColumn<HistorialFotografia, String> txtCFechaHistorial; // Columna 2
       
    @FXML
    private TableColumn<HistorialFotografia, String> txtCUrlHistorial; // Columna 3
    
    @FXML
    private TableColumn<HistorialFotografia, String> txtCId_ProductoH; // Columna 4
    
    @FXML
    private TableColumn<HistorialFotografia, String> txtCProductoHistorial; // Columna 5
     
    ObservableList<HistorialFotografia> dataHF = FXCollections.observableArrayList();
    
    //---- Elemento * * * 
    @FXML
    private DatePicker textDateHistorial;
    @FXML
    private TextField urlHistorial; 
    @FXML
    private ImageView imagen;
    @FXML
    private Button btnSeleccionarImagen;
    
    @FXML
    private ComboBox combo3 = new ComboBox();
    
    @FXML 
    private Button btnEditarH,btnEditarHistorial,btnEditarHistorialContinuar,btnEliminarH,btnEliminarHistorial;
    @FXML
    private TextField txtIdHistorialFoto;
    @FXML
    private Button btnActualizarH;
    @FXML
    private Button btnlistH; //Agregando Historial de Fotografia
    //------------------------------------------------------------------------------------
    @FXML
    private Tab btnCerrarSesion; //Cerrar Session
    
    //Elementos * * *
     @FXML
    private TextField textuser;
    
    @FXML
    private PasswordField textpassword;
   
    //------------------------------------------------------------------------------------
    @FXML
    private Tab btnReportes; //Reportes de Grafica
    
    @FXML
    private LineChart<String, Integer> grafSentencia; 
    
    @FXML 
    private ObservableList<String> leyenda1;
    private ObservableList<String> leyenda2;
    private ObservableList<String> leyenda3;
    private ObservableList<String> leyenda4;
    private ObservableList<String> leyenda5;
    private ObservableList<String> leyenda6;
    private ObservableList<String> leyenda7;
    private ObservableList<String> leyenda8;
    private ObservableList<String> leyenda9;
    @FXML
    private CategoryAxis Eje;
    
    @FXML
    private Button btnreporteTP; //Reporte de Producto
    
    @FXML
    private Button btnReporteP; //Reporte de Producto
    
    @FXML
    private Button btnReporteRR; //Reporte de Registro de Riego
       
    @FXML
    private Button btnReporteHF; //Reporte de Historial de Fotografia
  
    
    //------------------------------------- Elementos de crear ------------------------------------- 
    
    @FXML
    private Button btnAgregarTipoProducto;
    @FXML
    private Button btnEliminarCon;
    @FXML
    private TextField txtIdEliminar;
    @FXML
    private Button btnEditarTipo;
    @FXML
    private TextField txtIdEditar;
    @FXML
    private Button btnEditarContinuar;
    @FXML
    private Button btnEditarProducto;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private TextField txtIdProducto;
    @FXML
    private Button btnEditarProductoContinuar;
    @FXML
    private Button btnAgregarTipo;
    @FXML
    private Button btnAgregarProducto;
    @FXML
    private Button btnAgregarP;
    @FXML
    private Button btnAgregarHistorial;
    @FXML
    private Button btnAgregarRiego;
    @FXML
    private Button btnCerrar;
    @FXML
    private ImageView imgReportes; //imagen de Reportes
    
    @FXML
    private Button limpiarTabla;
    //---------------------------------Video------------------------------------------------------------
    Media me;
    MediaPlayer mp;
    @FXML
    private MediaView video;
    @FXML
    private Button btnReproducirAction;
    @FXML
    private Button btnDetener;
    @FXML
    private Button btnPausar;
    @FXML
    private Button btnRegresarInicio;
    
    
    //--------------------------------- Conexiones de Manejadores ---------------------------------------
    Connection conexionBDMysql = null;
    Connection conexionBDSQL;
    Connection verificar = null; // Parte de Login
    Connection conexion = null;
    Connection conexion1=null;
    Connection connection = null;
    PreparedStatement preparedStatement = null; // Parte de Login
    ResultSet resultSet = null;
    //private String urlMysql="jdbc:mysql://localhost/jardineria",username="root",password="slmca";
   // private String urlSqlServer="jdbc:sqlserver:1433",databaseName="jardineria",user="moisesdario",pass="171148";
    //----
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void btnIngresarAction(ActionEvent event) throws IOException{
        String usuarios = textuser.getText().toString();
        String password = textpassword.getText().toString();
        
        //Date picker
        String manejador= (String) combo.getSelectionModel().getSelectedItem();
        
        if(manejador.equals("MySQL")){
            verificar=null;
            verificar=statusConnectionMySQL();
            String mysql = "SELECT * FROM usuario WHERE usuario = ? and password = ?";
            try{
              preparedStatement = conexionBDMysql.prepareStatement(mysql);
              preparedStatement.setString(1, usuarios);
              preparedStatement.setString(2, password);
              mostrarTP();
              mostrarP();
              mostrarRR();
              mostrarHF();
              resultSet = preparedStatement.executeQuery();
              if(!resultSet.next()){
                  System.out.println("Por favor entrar correctamente con el Usuario and Password en MYSQL");
                }else{
                  this.ventana_menu.setVisible(true);
                  this.ventana_inicio.setVisible(false);
                  this.btnEliminarCon.setVisible(false);
                  this.txtIdEliminar.setVisible(false);
                  this.btnEditarTipo.setVisible(false);
                  this.btnActualizarP.setVisible(false);
                  this.btnActualizarH.setVisible(false);
                  this.btnActualizarRR.setVisible(false);
                  this.btnActualizarTP.setVisible(false);
//                  this.txtIdEditar.setVisible(false);
         
                }
            }
          catch(Exception e){
              e.printStackTrace();
            }
        }
        if(manejador.equals("SQL Server")){
            verificar=null;
            verificar=statusConnectionSQL();
            if(verificar!=null){
                String sqlserver = "SELECT * FROM usuario WHERE usuario = ? and password = ?";
                 try{
                  preparedStatement = statusConnectionSQL().prepareStatement(sqlserver);
                  preparedStatement.setString(1, usuarios);
                  preparedStatement.setString(2, password);
                  mostrarTP();
                  mostrarP();
                  mostrarRR();
                 mostrarHF();
                  resultSet = preparedStatement.executeQuery();
                  if(!resultSet.next()){
                      System.out.println("Por favor entrar correctamente con el Usuario and Password en SQL server");
                    }else{
                      this.ventana_menu.setVisible(true);
                      this.ventana_inicio.setVisible(false);
                    }
                }
              catch(SQLException e){
                  System.out.println("Existe un error en el login");
              }
            }
        }
        
        
    }
    //------------------------------------------------------------------- Video -------------------------------------------------------------------------------
    @FXML
    private void btnPresentacionAction(ActionEvent event){
        this.ventana_inicio.setVisible(false);
        this.ventana_presentacion.setVisible(true);
        File vide=new File("src/view/Presentación-video.mp4");
        me=new Media(vide.toURI().toString());
        mp=new MediaPlayer(me);
        video.setMediaPlayer(mp);
        mp.setAutoPlay(true);
    }
    @FXML
    private void btnRegresarInicio(ActionEvent event){
        this.ventana_presentacion.setVisible(false);
        this.ventana_inicio.setVisible(true);
    }
    
    @FXML
    private void btnReproducirAction(ActionEvent event){
        mp.play();
    }
    
    @FXML
    private void btnDetener(ActionEvent event){
        mp.seek(mp.getTotalDuration());
        mp.stop();
    }
    @FXML
    private void btnPausar(ActionEvent event){
        mp.pause();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lista();
    }
    
    @FXML
    private void handleClose(ActionEvent event){
        System.exit(0);
        //close();
    }
    
    
    private void lista(){
            combo.getItems().addAll("MySQL","SQL Server");
    }
    
    //------------------------------------------------------------- Conexion de My SQL -----------------------------------------------------------------------
    private Connection statusConnectionMySQL(){
        try{
            String urlMysql="jdbc:mysql://localhost:3306/jardineria";
            Class.forName("com.mysql.jdbc.Driver").newInstance();       
            conexionBDMysql=(Connection) DriverManager.getConnection(urlMysql,"root","slmca");
            if(conexionBDMysql != null){
                // System.out.print("Conectado a MySQL");
                return conexionBDMysql;
            } else {
            }
        }catch(Exception e){
            System.out.print(e);
            System.out.print("No esta conectado");
            this.ventana_menu.setVisible(false);
            this.ventana_inicio.setVisible(true);
            return conexionBDMysql;
        }
        return conexionBDMysql;
    }
    
    //---------------------------------------------------------------- Conexion de SQL SERVER -----------------------------------------------------------------
    private Connection statusConnectionSQL(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")/*.newInstance()*/;
            String urlSqlServer="jdbc:sqlserver://localhost:1433;databaseName=jardineria";
            conexionBDSQL=(Connection) DriverManager.getConnection(urlSqlServer,"SAINZ","12345");
            if(conexionBDSQL != null){
                System.out.print("Conectado a SQL Server");
                return conexionBDSQL;
            }
        }catch(Exception e){
            System.out.print("No esta conectado");
            System.out.print(e);
            return conexionBDSQL;
        }
        return conexionBDSQL;
    }
    
    //------------------------------------------------- Elementos para crear una tabla -----------------------------------------------------------------------
    
    @FXML
    private void btnlistTAction() throws IOException{
        this.ventana_agregarTipo.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarContinuar.setVisible(false);
    }
    
    @FXML
    private void btnlistPAction() throws IOException, SQLException{
        tablaProducto.getItems().clear();
        this.ventana_agregarProducto.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarProductoContinuar.setVisible(false);
       // listaTipo();
        //agregarProducto();
    }
    @FXML
    private void btnlistRRAction() throws IOException{
        this.ventana_registroRiego.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarContinuarRiego.setVisible(false);
        //agregarRegistroRiego();
    }
     @FXML
    private void btnlistHAction() throws IOException{
        
        this.ventana_registroHistorial.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarHistorialContinuar.setVisible(false);
        this.btnAgregarHistorial.setVisible(true);
        
        
    }
    
    //--------------------------------------------------------- Metodos de crear tipo producto --------------------------------------------------------------------   
    @FXML
    private void btnAgregarTipoProducto(){
        insertTP(); // Insertar
        mostrarTP(); //Mostrar
    }
    
    public void insertTP(){
        String nombreTipo=textTipo.getText(); 
        almacenarTipoProducto(nombreTipo);
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){
            String mysql="INSERT INTO tipoproducto (tipo) VALUES ('"+nombreTipo+"')";
            try{
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca"); 
                Statement st=conexionBDMysql.createStatement();
                posicionTipo++;
                System.out.println("Datos agregado"+mysql);
                st.executeUpdate(mysql);
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }
        }
        //---------------------------------------------------       SQL Server      ----------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){
            String sql1="INSERT INTO tipoproducto (tipo) VALUES ('"+nombreTipo+"')";
            try{
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                Statement st=conexionBDSQL.createStatement();
                posicionTipo++;
                st.executeUpdate(sql1);
                System.out.println("Datos agregado"+sql1);
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }
        }
        this.ventana_menu.setVisible(true);
        this.ventana_agregarTipo.setVisible(false);
        this.textTipo.setText(""); 
    }
    //-------------------------------------------------------------------Almacenamiento de Combo Box -------------------------------------------------------------------------------
        public void almacenarTipoProducto(String nombreTipo){
        String guardar = nombreTipo;
        combo1.getItems().addAll(guardar);
        String almacenar= (String) combo1.getSelectionModel().getSelectedItem();
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="Select tipo from tipoproducto where tipo" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato de tipo producto esta al macenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
        }
        //------------------------------------------------------    SQL Server  ----------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="Select tipo from tipoproducto" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato de tipo producto esta al macenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
        }
    }    
    //----------------------------------------------------------- Metodo de mostrar tipo producto -------------------------------------------------------------------------------
    private void mostrarTP(){
             //Date picker    
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        
        if(conexion.equals("MySQL"))
        {      
            try{   
                String mysql = "select id_tipo,tipo from tipoproducto ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");             
                txtIdCTP.setText("ID");
                txtCTP.setText("Tipo de producto");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                System.out.println("Entra aca");
                while(rs.next()){
                    dataTP.add(new TipoProducto(rs.getString("id_tipo"),rs.getString("tipo")));
                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdCTP.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));
            txtCTP.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            tablaTipoProducto.setItems(dataTP);     
        }
        //------------------------------------------------------------------    SQL Server-------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_tipo,tipo from tipoproducto ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdCTP.setText("ID");
                txtCTP.setText("Tipo de producto");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataTP.add(new TipoProducto(rs.getString("id_tipo"),rs.getString("tipo")));
                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL Server" + e);
            }
            txtIdCTP.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));
            txtCTP.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            tablaTipoProducto.setItems(dataTP);     
        }
        else{
            System.out.println("No conexion");
        }
         
    }
    //----------------------------------------------------------- Metodo de Editar tipo producto -------------------------------------------------------------
    @FXML
    void btnEditarTP(ActionEvent event) {
       this.btnEditarTipo.setVisible(true);
       this.txtIdEliminar.setVisible(true);
       this.btnActualizarTP.setVisible(true);
    }
    @FXML
    private void btnEditarTipo(ActionEvent event){
        int id=Integer.parseInt(txtIdEliminar.getText());
        this.btnEditarProductoContinuar.setVisible(true);
        this.ventana_agregarTipo.setVisible(true);
        this.btnEditarContinuar.setVisible(true);
        this.btnAgregarTipo.setVisible(false);
        this.ventana_menu.setVisible(false);
        System.out.println(""+id);
        //actualizarTipo(id);
    }
    @FXML
    private void btnActualizarTP(ActionEvent event){
        mostrarTP();
        tablaTipoProducto.getItems().removeAll(tablaTipoProducto.getSelectionModel().getSelectedItems());

    }
    
    @FXML
    private void btnEditarContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdEliminar.getText());
        actualizarTipo(id);
        this.btnEditarTipo.setVisible(false);
        this.txtIdEliminar.setVisible(false);
    }
    private void actualizarTipo(int id){
        int idEditar=id;
        String nombreTipo =textTipo.getText().toString();
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE tipoproducto Set tipo='"+nombreTipo+"' where id_tipo='"+idEditar+"'" ;
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);
            //this.textTipo.setText("");
            this.btnAgregarTipo.setVisible(true);
            this.btnEditarProductoContinuar.setVisible(false);
        }
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE tipoproducto Set tipo='"+nombreTipo+"' where id_tipo='"+idEditar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Entra: "+sql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.btnEditarProductoContinuar.setVisible(false);
        }
    }
    //---------------------------------------------------- Metodo de Eliminar tipo producto -------------------------------------------------------------------
    @FXML
    private void btnEliminarTPAction(ActionEvent event){
        this.txtIdEliminar.setText("");
        this.btnEliminarCon.setVisible(true);
        this.txtIdEliminar.setVisible(true);
        this.btnEditarTipo.setVisible(false);
    }
    @FXML
    private void btnEliminarConAction(ActionEvent event){
        int id=Integer.parseInt(txtIdEliminar.getText());
        System.out.println("Se elimino un elemento");
        deleteTP(id); //Eliminar
        tablaTipoProducto.getItems().removeAll(tablaTipoProducto.getSelectionModel().getSelectedItems());
        txtIdEliminar.setText("");
        this.txtIdEliminar.setVisible(false);
        this.btnEliminarCon.setVisible(false);
        
    }
  
    public void deleteTP(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM tipoproducto WHERE id_tipo='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            //this.textTipo.setText(""); 
        }
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="DELETE FROM tipoproducto WHERE id_tipo='"+idEliminar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            //this.textTipo.setText(""); 
        }
    }
    //-------------------------------------------------------- Metodos de crear Registro de Riego --------------------------------------------------------
    @FXML
    private void btnRR(){
        this.btnEliminarRiegoContinuar.setVisible(false);
        this.txtIdRegistroRiego.setVisible(false);
        this.btnEditarRiegoContinuar.setVisible(false);
    }
    @FXML
    private void btnAgregarRiego(ActionEvent event){
        insertRR(); // Insertar  
        mostrarRR(); //Mostrar
    }
    
    public void insertRR(){
        String dateregistroriego = textDataRiego.getValue().toString();
        String producto = (String) combo2.getSelectionModel().getSelectedItem();
        String conexion=(String) combo.getSelectionModel().getSelectedItem();
        int idProducto = posicionProducto;
        if(conexion.equals("MySQL")){
            String mysql="INSERT INTO registroriego (fechariego,producto,id_producto) VALUES ('"+dateregistroriego+"','"+producto+"','"+idProducto+"')";
            try{
                Statement st=conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Datos agregado de registro de riego ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    
          this.ventana_menu.setVisible(true);
          this.ventana_registroRiego.setVisible(false);

          this.textDataRiego.setValue(null); 
        }
        //------------------------------------------------------------- SQL Server-----------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){
            String sql="INSERT INTO registroriego (fechariego,producto,id_producto) VALUES ('"+dateregistroriego+"','"+producto+"','"+idProducto+"')";
            try{
                Statement st=conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Datos agregado de registro de riego ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    
          this.ventana_menu.setVisible(true);
          this.ventana_registroRiego.setVisible(false);

          this.textDataRiego.setValue(null); 
        }
    }
    //---------------------------------------------------------- Metodo de Mostrar Registro de  ---------------------------------------------------------------------
    private void mostrarRR(){
      
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        //  conexion=statusConnectionMySQL();
        if(conexion.equals("MySQL"))
        {      
            try{   
                String mysql = "select id_riego,fechariego,producto,id_producto from registroriego ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");             
                txtIdCRiego.setText("ID");
                txtCFechaRegistro.setText("Fecha de Registro");
                txtCProductoRiego.setText("Producto");
                txtCId_ProductoR.setText("Id_Producto");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                while(rs.next()){
                    dataRR.add(new RegistroRiego(rs.getString("id_riego"),rs.getString("fechariego"),rs.getString("producto"),rs.getString("id_producto")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdCRiego.setCellValueFactory(new PropertyValueFactory<>("id_riego"));
            txtCFechaRegistro.setCellValueFactory(new PropertyValueFactory<>("fechariego"));
            txtCProductoRiego.setCellValueFactory(new PropertyValueFactory<>("producto"));
            txtCId_ProductoR.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            tablaRegistroRiego.setItems(dataRR);        
        }
        else{
            System.out.println("No conexion");
        }
        //------------------------------------------------------------------- SQL Server -----------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_riego,fechariego,producto,id_producto from registroriego ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdCRiego.setText("ID");
                txtCFechaRegistro.setText("Fecha de Registro");
                txtCProductoRiego.setText("Producto");
                txtCId_ProductoR.setText("Id Producto");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataRR.add(new RegistroRiego(rs.getString("id_riego"),rs.getString("fechariego"),rs.getString("producto"),rs.getString("id_producto")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdCRiego.setCellValueFactory(new PropertyValueFactory<>("id_riego"));
            txtCFechaRegistro.setCellValueFactory(new PropertyValueFactory<>("fechariego"));
            txtCProductoRiego.setCellValueFactory(new PropertyValueFactory<>("producto"));
            txtCId_ProductoR.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            tablaRegistroRiego.setItems(dataRR);        
        }
        else{
            System.out.println("No conexion");
        }
        this.ventana_menu.setVisible(true);
        this.ventana_registroRiego.setVisible(false);
    }
    //------------------------------------------------------ Metodos para editar registro riego -----------------------------------------------------------------------
    @FXML
    private void btnEditarRiego(ActionEvent event){
        this.btnEditarRiegoContinuar.setVisible(true);
        this.txtIdRegistroRiego.setVisible(true);
        this.btnActualizarRR.setVisible(true);
    }
     @FXML
    private void btnActualizarRR(ActionEvent event){
        mostrarRR();
        tablaRegistroRiego.getItems().removeAll(tablaRegistroRiego.getSelectionModel().getSelectedItems());

    }
    @FXML
    private void btnEditarRiegoContinuar(ActionEvent event){
        this.btnEditarRiegoContinuar.setVisible(false);
        //this.txtIdRegistroRiego.setText("");
        this.txtIdRegistroRiego.setVisible(false);
        this.ventana_menu.setVisible(false);
        this.ventana_registroRiego.setVisible(true);
        this.btnAgregarR.setVisible(false);
        this.btnEditarContinuarRiego.setVisible(true);
    }
    @FXML
    private void btnEditarContinuarRiego(ActionEvent event){
        int id=Integer.parseInt(txtIdRegistroRiego.getText());
        actualizarRiego(id);
        this.ventana_registroRiego.setVisible(false);
        this.ventana_menu.setVisible(true);
    }
    private void actualizarRiego(int id){
         int idEditar=id;
        String producto = (String) combo2.getSelectionModel().getSelectedItem();
        String dateregistroriego = textDataRiego.getValue().toString();
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE registroriego Set fechariego='"+dateregistroriego+"',producto='"+producto+"' where id_riego='"+idEditar+"'" ;
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroRiego.setVisible(false);
            this.btnAgregarR.setVisible(true);
            txtIdRegistroRiego.setText("");
            this.txtIdRegistroRiego.setVisible(false);
            this.btnEditarContinuarRiego.setVisible(false);
            this.textDataRiego.setValue(null); 
        }
        //---------------------------------------------------------------- SQL Server ------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE registroriego Set fechariego='"+dateregistroriego+"',producto='"+producto+"' where id_riego='"+idEditar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeQuery(sql);
                System.out.println("Entra: "+sql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroRiego.setVisible(false);
            this.btnAgregarR.setVisible(true);
            txtIdRegistroRiego.setText("");
            this.txtIdRegistroRiego.setVisible(false);
            this.btnEditarContinuarRiego.setVisible(false);
            //this.txtId.setText(""); 
        }
    }
    //------------------------------------------------------ Metodo de eliminar registro de riego-------------------------------------------------------
    @FXML
    private void btnEliminarRiego(ActionEvent event){
        this.btnEliminarRiegoContinuar.setVisible(true);
        this.txtIdRegistroRiego.setVisible(true);
    }
    @FXML
    private void btnEliminarRiegoContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdRegistroRiego.getText());
        System.out.println("Se elimino un elemento");
        deleteRR(id); //Eliminar
        tablaRegistroRiego.getItems().removeAll(tablaRegistroRiego.getSelectionModel().getSelectedItems());
        txtIdRegistroRiego.setText("");
        this.txtIdRegistroRiego.setVisible(false);
        this.btnEliminarRiegoContinuar.setVisible(false);
    }
    private void deleteRR(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM registroriego WHERE id_riego='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtIdRegistroRiego.setText("");
            this.txtIdRegistroRiego.setVisible(false);
        }
        //------------------------------------------------------------------- SQL Server----------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="DELETE FROM registroriego WHERE id_riego='"+idEliminar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            //this.textTipo.setText(""); 
        }
    }
    //------------------------------------------------------ Metodos de crear producto ------------------------------------------------------------------
 
    @FXML 
    private void btnAgregarProducto(){
        
        insertP(); // Insertar
        mostrarP(); //Mostrar
    }
    
    private void insertP(){
       String nombreproducto = textNombreP.getText();
       almacenarProducto(nombreproducto); //Combo box de Tipo Producto
       almacenaProductoH(nombreproducto); //
       String tipoProducto = (String) combo1.getSelectionModel().getSelectedItem();
       String condicionProducto = textCondicionP.getText();  
       String fechaIngreso = textFechaP.getValue().toString();
       int idTipo = posicionTipo;
       String conexion=(String)combo.getSelectionModel().getSelectedItem();
       if(conexion.equals("MySQL")){
        String mysql="INSERT INTO producto (nombreproducto,tipoproducto,condicionactual,fechaingreso,id_tipo) VALUES ('"+nombreproducto+"','"+tipoProducto+"','"+condicionProducto+"','"+fechaIngreso+"','"+idTipo+"')";
        try{
            conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca"); 
            Statement st=conexionBDMysql.createStatement();
             posicionProducto++;
            st.executeUpdate(mysql);
            System.out.println("Datos agregado ");
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);                  
        }    
        this.ventana_menu.setVisible(true);
        this.ventana_agregarProducto.setVisible(false);

        this.textNombreP.setText(""); 
        this.textTipoProducto.setText("");
        this.textCondicionP.setText(""); 
        this.textFechaP.setValue(null); 
       }
       //------------------------------------------------------------- SQL Server-------------------------------------------------------------------------------
       if(conexion.equals("SQL Server")){
           String sql="INSERT INTO producto (nombreProducto,tipoProducto,condicionActual,fechaIngreso,id_tipo) VALUES ('"+nombreproducto+"','"+tipoProducto+"','"+condicionProducto+"','"+fechaIngreso+"','"+idTipo+"')";
        try{
            Statement st=conexionBDSQL.createStatement();
            st.executeUpdate(sql);
            System.out.println("Datos agregado ");
            posicionProducto++;
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);                  
        }    
        this.ventana_menu.setVisible(true);
        this.ventana_agregarProducto.setVisible(false);

        this.textNombreP.setText(""); 
        this.textTipoProducto.setText("");
        this.textCondicionP.setText(""); 
        this.textFechaP.setValue(null); 
       }
    }
    //------------------------------------------------------ Almacenamiento de Combo Box ---------------------------------------------------------------------------------------
    public void almacenarProducto(String nombreproducto){
        String guardar = nombreproducto;
        combo2.getItems().addAll(guardar);
        String almacenar= (String) combo2.getSelectionModel().getSelectedItem();
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="Select nombreproducto from producto Where nombreproducto" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato de producto esta almacenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);     
        }
        //-------------------------------------------------------------- SQL Server----------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="Select nombreproducto from producto" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato de producto esta almacenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);     
        }
    }
    //------------------------------------------------------- Metodo de Mostrar --------------------------------------------------------------------------
    private void mostrarP(){
          //Date picker    
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        //  conexion=statusConnectionMySQL();
        if("MySQL".equals(conexion))
        {      
            try{   
                String mysql = "select id_producto,nombreproducto,tipoproducto,condicionactual,fechaingreso,id_tipo from producto ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");             
                txtIdCP.setText("ID");
                txtCNombreP.setText("Nombre de Producto");
                txtCTipoProducto.setText("Tipo de Producto");
                txtCCondicionActual.setText("Condicion Actual");
                txtCFechaIngreso.setText("Fecha de Ingreso");
                txtCId_Tipo.setText("Id Tipo");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                while(rs.next()){
                    dataP.add(new Producto(rs.getString("id_producto"),rs.getString("nombreproducto"),rs.getString("tipoproducto"),rs.getString("condicionactual"),rs.getString("fechaingreso"),rs.getString("id_tipo")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdCP.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            txtCNombreP.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
            txtCTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoproducto"));
            txtCCondicionActual.setCellValueFactory(new PropertyValueFactory<>("condicionactual"));
            txtCFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaingreso"));
            txtCId_Tipo.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));
            tablaProducto.setItems(dataP);        
        }
        //------------------------------------------------------------- SQL Server----------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_producto,nombreproducto,tipoproducto,condicionactual,fechaingreso,id_tipo from producto ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDMysql = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdCP.setText("ID");
                txtCNombreP.setText("Nombre de Producto");
                txtCTipoProducto.setText("Tipo de Producto");
                txtCCondicionActual.setText("Condicion Actual");
                txtCFechaIngreso.setText("Fecha de Ingreso");
                txtCId_Tipo.setText("Id_tipo");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataP.add(new Producto(rs.getString("id_producto"),rs.getString("nombreproducto"),rs.getString("tipoproducto"),rs.getString("condicionactual"),rs.getString("fechaingreso"),rs.getString("id_tipo")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL Server" + e);
            }
            txtIdCP.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            txtCNombreP.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
            txtCTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoproducto"));
            txtCCondicionActual.setCellValueFactory(new PropertyValueFactory<>("condicionactual"));
            txtCFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaingreso"));
            txtCId_Tipo.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));
            tablaProducto.setItems(dataP);        
        }
        else{
            System.out.println("No conexion");
        } 
        this.ventana_menu.setVisible(true);
        this.ventana_agregarProducto.setVisible(false);
    }
    @FXML
    private void btnP(){
        this.txtIdProducto.setVisible(false);
                  this.btnEditarProducto.setVisible(false);
                  this.btnEliminarProducto.setVisible(false);
    }
    //-----------------------------------------------Metodos para editar producto----------------------------------------------------
    @FXML
    private void btnEditarP(ActionEvent event){
        this.btnEliminarProducto.setVisible(false);
        this.btnEditarProducto.setVisible(true);
        this.txtIdProducto.setVisible(true);
        this.btnActualizarP.setVisible(true);
    }
    @FXML
    private void btnActualizarP(ActionEvent event){
        mostrarP();
        tablaProducto.getItems().removeAll(tablaProducto.getSelectionModel().getSelectedItems());

    }
    @FXML
    private void btnEditarProducto(ActionEvent event){
        this.ventana_agregarProducto.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarProducto.setVisible(false);
        this.btnEliminarProducto.setVisible(false);
        this.txtIdProducto.setVisible(false);
        this.btnEditarProductoContinuar.setVisible(true);
        this.btnAgregarP.setVisible(false);
    }
    @FXML
    private void btnEditarProductoContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdProducto.getText());
        actualizarProducto(id);
        this.ventana_agregarProducto.setVisible(false);
        this.ventana_menu.setVisible(true);
    }
    private void actualizarProducto(int id){
        int idEditar=id;
        //String nombreTipo=txtTipo.getText();
        String nombreproducto = textNombreP.getText();
       String tipoProducto = (String) combo1.getSelectionModel().getSelectedItem();
       String condicionProducto = textCondicionP.getText();  
       String fechaIngreso = textFechaP.getValue().toString();
        //almacenarTipoProducto(nombreTipo.toString());
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE producto Set nombreProducto='"+nombreproducto+"',tipoProducto='"+tipoProducto+"',condicionActual='"+condicionProducto+"',fechaIngreso='"+fechaIngreso+"' where id_producto='"+ idEditar+"'";
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);
            this.txtIdProducto.setText("");
            this.txtIdProducto.setVisible(false);
            this.btnEditarProductoContinuar.setVisible(false);
            this.btnAgregarP.setVisible(true);
        }
        //---------------------------------------------------------------- SQL Server ----------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE producto Set nombreProducto='"+nombreproducto+"',tipoProducto='"+tipoProducto+"',condicionActual='"+condicionProducto+"',fechaIngreso='"+fechaIngreso+"' where id_producto='"+ idEditar+"'";
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Entra: "+sql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);
            this.txtIdProducto.setText("");
            this.txtIdProducto.setVisible(false);
            this.btnEditarProductoContinuar.setVisible(false);
            this.btnAgregarP.setVisible(true);
        }
    }
    //-------------------------------------------------Metodos para eliminar-----------------------------------------------------------------
    @FXML
    private void btnEliminarP(ActionEvent event){
        this.btnEditarProducto.setVisible(false);
        this.btnEliminarProducto.setVisible(true);
        this.txtIdProducto.setVisible(true);
    }
    @FXML
    private void btnEliminarProdu(ActionEvent event){
        int id=Integer.parseInt(txtIdProducto.getText());
        System.out.println("Se elimino un elemento");
        System.out.println(""+id);
        deleteP(id); //Eliminar
        tablaProducto.getItems().removeAll(tablaProducto.getSelectionModel().getSelectedItems());
        txtIdProducto.setText("");
        this.txtIdProducto.setVisible(false);
        this.btnEliminarProducto.setVisible(false);
        
    }
    private void deleteP(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM producto WHERE id_producto='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
           // this.textTipo.setText(""); 
        }
        //------------------------------------------------------------------- SQL Server -----------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="DELETE FROM producto WHERE id_producto='"+idEliminar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            //this.textTipo.setText(""); 
        }
    }
    
    //----------------------------------------------------------Historial Fotografia----------------------------------------------------------------------
    @FXML
    private void btnHF(){
        this.txtIdHistorialFoto.setVisible(false);
        this.btnEditarHistorial.setVisible(false);
        this.btnEliminarHistorial.setVisible(false);
    }
    public void almacenaProductoH(String nombreproducto){
        String guardar = nombreproducto;
        combo3.getItems().addAll(guardar);
        String almacenar= (String) combo3.getSelectionModel().getSelectedItem();
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="Select nombreproducto from producto " ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato de producto historial esta almacenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              
            }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
        }
    }
    @FXML
    private void btnSeleccionarImagen(ActionEvent event) throws IOException{
        FileChooser filechooser=new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG=new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
        FileChooser.ExtensionFilter extFilterPNG=new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
        filechooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        
        File file=filechooser.showOpenDialog(null);
        try{
            BufferedImage bufferedimage=ImageIO.read(file);
            Image image=SwingFXUtils.toFXImage(bufferedimage,null);
            imagen.setImage(image);
            urlHistorial.setText(file.toURL().toString());
        }catch(Exception e){
            System.out.println(""+e);
        }
    }
    @FXML
    private void btnAgregarHistorial(ActionEvent event){
        insertHF();  //Insertar
        mostrarHF(); //Mostrar
    }
    
    private void insertHF(){
        String fechaHistorial = textDateHistorial.getValue().toString();
        String fotografia = urlHistorial.getText().toString();
        int IdProducto = posicionProducto;
        String productoH = (String) combo3.getSelectionModel().getSelectedItem();
        String conexion=(String) combo.getSelectionModel().getSelectedItem();
        //System.out.println(""+fotografia);
        if(conexion.equals("MySQL")){
            String mysql="INSERT INTO historial (fechahistorial,fotografia,id_producto,producto) VALUES ('"+fechaHistorial+"','"+fotografia+"','"+IdProducto+"','"+productoH+"')";
            try{
                Statement st=conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Datos agregado ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    

          this.textFechaP.setValue(null); 
          this.urlHistorial.setText("");  
          this.ventana_registroHistorial.setVisible(false);
          this.ventana_menu.setVisible(true);
        }
        //------------------------------------------------------------- SQL Server --------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){
            String sql="INSERT INTO historial (fechahistorial,fotografia,id_producto,producto) VALUES ('"+fechaHistorial+"','"+fotografia+"','"+IdProducto+"','"+productoH+"')";
            try{
                Statement st=conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Datos agregado ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    

          this.textFechaP.setValue(null); 
          this.urlHistorial.setText("");  
          this.ventana_registroHistorial.setVisible(false);
          this.ventana_menu.setVisible(true);
        }
    }
    
    //--------------------------------------------- Metodo de Mostrar -------------------------------------------
    public void mostrarHF(){
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        //  conexion=statusConnectionMySQL();
        if("MySQL".equals(conexion))
        {      
            try{   
                String mysql = "select id_historial,fechahistorial,fotografia,id_producto,producto from historial ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");             
                txtIdCHistorial.setText("ID");
                txtCFechaHistorial.setText("Fecha de Historial");
                txtCUrlHistorial.setText("Fotografia");
                txtCId_ProductoH.setText("Id Producto");
                txtCProductoHistorial.setText("Producto");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                while(rs.next()){
                    dataHF.add(new HistorialFotografia(rs.getString("id_historial"),rs.getString("fechahistorial"),rs.getString("fotografia"),rs.getString("id_producto"),rs.getString("producto")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdCHistorial.setCellValueFactory(new PropertyValueFactory<>("id_historial"));
            txtCFechaHistorial.setCellValueFactory(new PropertyValueFactory<>("fechahistorial"));
            txtCUrlHistorial.setCellValueFactory(new PropertyValueFactory<>("fotografia"));
            txtCId_ProductoH.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            txtCProductoHistorial.setCellValueFactory(new PropertyValueFactory<>("producto"));
            tablaHistorial.setItems(dataHF);        
        }
        //---------------------------------------------------------- SQL Server ---------------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_historial,fechahistorial,fotografia,id_producto from historial ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdCHistorial.setText("ID");
                txtCFechaHistorial.setText("Fecha de Historial");
                txtCUrlHistorial.setText("Fotografia");
                txtCId_ProductoH.setText("Id_Producto");
                txtCProductoHistorial.setText("Producto");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataHF.add(new HistorialFotografia(rs.getString("id_historial"),rs.getString("fechahistorial"),rs.getString("fotografia"),rs.getString("id_producto"),rs.getString("producto")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdCHistorial.setCellValueFactory(new PropertyValueFactory<>("id_historial"));
            txtCFechaHistorial.setCellValueFactory(new PropertyValueFactory<>("fechahistorial"));
            txtCUrlHistorial.setCellValueFactory(new PropertyValueFactory<>("fotografia"));
            txtCId_ProductoH.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            txtCProductoHistorial.setCellValueFactory(new PropertyValueFactory<>("producto"));
            tablaHistorial.setItems(dataHF);        
        }
        else{
            System.out.println("No conexion");
        }
    
    }
    //----------------------------------------------------------------Metodos para editar Historial----------------------------------------------------------
    @FXML
    private void btnEditarH(ActionEvent event){
        this.txtIdHistorialFoto.setVisible(true);
        this.btnEditarHistorial.setVisible(true);
        this.btnEliminarHistorial.setVisible(false);
        this.btnActualizarH.setVisible(true);
    } 
    
    @FXML
    private void btnActualizarH(ActionEvent event){
        mostrarHF();
        tablaHistorial.getItems().removeAll(tablaHistorial.getSelectionModel().getSelectedItems());

    }
   
    @FXML
    private void btnEditarHistorial(ActionEvent event){
        this.ventana_menu.setVisible(false);
        this.btnAgregarHistorial.setVisible(false);
        this.ventana_registroHistorial.setVisible(true);
        this.txtIdHistorialFoto.setVisible(false);
        this.btnEditarHistorial.setVisible(false);
        this.btnEditarHistorialContinuar.setVisible(true);
    }
    @FXML
    private void btnEditarHistorialContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdHistorialFoto.getText());
        actualizarHistorial(id);
        this.ventana_registroHistorial.setVisible(false);
        this.ventana_menu.setVisible(true);
    }
    private void actualizarHistorial(int id){
        int idEditar=id;
        String fechaHistorial = textDateHistorial.getValue().toString();
        String fotografia = urlHistorial.getText().toString();
        String productoH = (String) combo3.getSelectionModel().getSelectedItem();
        int IdProducto = posicionProducto;
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE historial Set fechahistorial='"+fechaHistorial+"',fotografia='"+fotografia+"',id_producto='"+IdProducto+"',producto='"+productoH+"' where id_historial='"+idEditar+"'";
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);
            this.txtIdHistorialFoto.setText("");
            this.txtIdHistorialFoto.setVisible(false);
            this.btnAgregarHistorial.setVisible(false);
            this.btnEditarHistorial.setVisible(false);
        }
        //-------------------------------------------------------------------- SQL Server -------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE historial Set fechahistorial='"+fechaHistorial+"',fotografia='"+fotografia+"' where id_historial='"+idEditar+"'";
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Entra: "+sql);
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);
            this.txtIdHistorialFoto.setText("");
            this.txtIdHistorialFoto.setVisible(false);
            this.btnAgregarHistorial.setVisible(false);
            this.btnEditarHistorial.setVisible(false);
        }
    }
    //------------------------------------------------------Metodos para Eliminar Historial Fotografia------------------------------------------------------
    @FXML
    private void btnEliminarH(ActionEvent event){
        this.btnEliminarHistorial.setVisible(true);
        this.txtIdHistorialFoto.setVisible(true);
        this.btnEditarHistorial.setVisible(false);
    }
    @FXML
    private void btnEliminarHistorial(ActionEvent event){
        int id=Integer.parseInt(txtIdHistorialFoto.getText());
        System.out.println("Se elimino un elemento");
        System.out.println(""+id);
        deleteH(id); //Eliminar
        tablaHistorial.getItems().removeAll(tablaHistorial.getSelectionModel().getSelectedItems());
        txtIdHistorialFoto.setText("");
        this.txtIdHistorialFoto.setVisible(false);
        this.btnEliminarHistorial.setVisible(false);
    }
    private void deleteH(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM historial WHERE id_historial='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);     
            this.txtIdHistorialFoto.setText(""); 
        }
        //------------------------------------------------------------------ SQL Server -------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{
                String sql="DELETE FROM historial WHERE id_historial='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);     
            this.txtIdHistorialFoto.setText(""); 
        }
    }
        
    //--------------------------------------------- REPORTES DE GRAFICAS --------------------------------------
    @FXML
    private void btnReporteRR() throws SQLException{
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if("MySQL".equals(conexion)){          
            conexion1=statusConnectionMySQL();
            grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{   
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");           
                Statement st = conexionBDMysql.createStatement();
                String mysql2 = "select r.fechariego, count(*)Riego from registroriego r "
                        + " group by fechariego";
                System.out.println("Tabla de Registro de Riego " + mysql2);
                ResultSet rs2 = st.executeQuery(mysql2);
                  
                XYChart.Series<String, Integer> dataSeries2 = new XYChart.Series<>();
                
                // crea la variable para almacenar las leyendas
                leyenda2 =  FXCollections.observableArrayList();
                leyenda2.clear();
                while(rs2.next()){
                    leyenda2.add(""+rs2.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries2.getData().add(new XYChart.Data<>(""+rs2.getString(1), rs2.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda2);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries2); // se agrega la serie de datos
               
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }      
        //------------------------------------------ SQL SERVER ---------------------------------------------
        if("SQL Server".equals(conexion)){          
            conexion1=statusConnectionSQL();
             grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{   
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria");             
                Statement st = conexionBDSQL.createStatement();
                String mysql3 = "select r.fechariego, count(*)Riego from registroriego r "
                        + " group by fechariego";
                System.out.println("Tabla de Registro de Riego " + mysql3);
                ResultSet rs3 = st.executeQuery(mysql3);
                  
                XYChart.Series<String, Integer> dataSeries3 = new XYChart.Series<>();
               
                // crea la variable para almacenar las leyendas
                leyenda3 =  FXCollections.observableArrayList();

                while(rs3.next()){
                    leyenda3.add(""+rs3.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries3.getData().add(new XYChart.Data<>(""+rs3.getString(1), rs3.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda3);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries3); // se agrega la serie de datos
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL Server" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }      
    }    
    
    @FXML
    private void btnreporteTP() throws SQLException{
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if("MySQL".equals(conexion)){          
            conexion1=statusConnectionMySQL();
            grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{   
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");             
                Statement st = conexionBDMysql.createStatement();
                String mysql4 = "select t.tipo, count(*)Producto from tipoproducto t inner join producto p "
                        + " on t.id_tipo"
                        + " group by tipo";
                System.out.println("Tabla de Tipo Producto " + mysql4);
                ResultSet rs4 = st.executeQuery(mysql4);
                  
                XYChart.Series<String, Integer> dataSeries4 = new XYChart.Series<>();
                
                // crea la variable para almacenar las leyendas
                leyenda4 =  FXCollections.observableArrayList();

                while(rs4.next()){
                    leyenda4.add(""+rs4.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries4.getData().add(new XYChart.Data<>(""+rs4.getString(1), rs4.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda4);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries4); // se agrega la serie de datos
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }      
        
        //-------------------------------------- SQL SERVER --------------------------------------------------
          if("SQL Server".equals(conexion)){          
            conexion1=statusConnectionSQL();
            try{   
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria");                   
                Statement st = conexionBDSQL.createStatement();
                 String mysql5 = "select t.tipo, count(*)Producto from tipoproducto t inner join producto p "
                        + " on t.id_tipo"
                        + " group by tipo";
                System.out.println("Tabla de Tipo Producto " + mysql5);
                ResultSet rs5 = st.executeQuery(mysql5);
                  
                XYChart.Series<String, Integer> dataSeries5 = new XYChart.Series<>();
               
                // crea la variable para almacenar las leyendas
                leyenda5 =  FXCollections.observableArrayList();

                while(rs5.next()){
                    leyenda5.add(""+rs5.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries5.getData().add(new XYChart.Data<>(""+rs5.getString(1), rs5.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda5);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries5); // se agrega la serie de datos
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL SERVER" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }      
    }    
    
     @FXML
    private void btnReporteP() throws SQLException{
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{   
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");             
                txtIdCP.setText("ID");
                txtCCondicionActual.setText("Condicion Actual");
                Statement st = conexionBDMysql.createStatement();
                String mysql6 = "select p.condicionactual, count(*)Producto from producto p "
                        + " group by condicionactual";
                System.out.println("Tabla de Producto " + mysql6);
                ResultSet rs6 = st.executeQuery(mysql6);
                  
                XYChart.Series<String, Integer> dataSeries6 = new XYChart.Series<>();
                
                // crea la variable para almacenar las leyendas
                leyenda6 =  FXCollections.observableArrayList();

                while(rs6.next()){
                    leyenda6.add(""+rs6.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries6.getData().add(new XYChart.Data<>(""+rs6.getString(1), rs6.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda6);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries6); // se agrega la serie de datos
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }      
        
        //---------------------------------- SQL SERVER ------------------------------------------------------
         if("SQL Server".equals(conexion)){          
            conexion1=statusConnectionSQL();
            grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{   
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria");                     
                txtIdCP.setText("ID");
                txtCCondicionActual.setText("Condicion Actual");
                Statement st = conexionBDSQL.createStatement();
                String mysql7 = "select p.condicionactual, count(*)Producto from producto p "
                        + " group by condicionactual";
                System.out.println("Tabla de Producto " + mysql7);
                ResultSet rs7 = st.executeQuery(mysql7);
                  
                XYChart.Series<String, Integer> dataSeries7 = new XYChart.Series<>();
               
                // crea la variable para almacenar las leyendas
                leyenda7 =  FXCollections.observableArrayList();

                while(rs7.next()){
                    leyenda7.add(""+rs7.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries7.getData().add(new XYChart.Data<>(""+rs7.getString(1), rs7.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda7);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries7); // se agrega la serie de datos
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL SERVER" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }  
    }    
    
    @FXML
    private void btnReporteHF() throws SQLException{
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{ 
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","slmca");                                
                txtIdCTP.setText("ID");
                txtCTP.setText("Tipo de producto");
                Statement st = conexionBDMysql.createStatement();
                String mysql8 = "select distinct p.nombreproducto, count(*)Fotografia from producto p inner join historial h  "
                        + "on h.id_historial  "
                        + " group by id_historial,nombreproducto";
                System.out.println("Tabla Historial con Tipo de Producto " + mysql8);
                ResultSet rs8 = st.executeQuery(mysql8);
                  
                XYChart.Series<String, Integer> dataSeries8 = new XYChart.Series<>();
                
                // crea la variable para almacenar las leyendas
                leyenda8 =  FXCollections.observableArrayList();

                while(rs8.next()){
                    leyenda8.add(""+rs8.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries8.getData().add(new XYChart.Data<>(""+rs8.getString(1), rs8.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda8);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries8); // se agrega la serie de datos
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My SQL" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }      
        
        //----------------------------------------------SQL SERVER -------------------------------------------
         if("SQL Server".equals(conexion)){          
            conexion1=statusConnectionSQL();
            grafSentencia.getData().clear();
            grafSentencia.getData().removeAll();
            Eje.getCategories().clear();
            try{   
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria");          
                txtIdCTP.setText("ID");
                txtCTP.setText("Tipo de producto");
                Statement st1 = conexionBDSQL.createStatement();
                String mysql9 = "select distinct p.nombreproducto, count(*)Fotografia from producto p inner join historial h  "
                        + "on h.id_historial  "
                        + " group by id_historial,nombreproducto";
                System.out.println("Tabla Historial con Tipo de Producto " + mysql9);
                ResultSet rs9 = st1.executeQuery(mysql9);
                  
                XYChart.Series<String, Integer> dataSeries9 = new XYChart.Series<>();
               
                // crea la variable para almacenar las leyendas
                leyenda9 =  FXCollections.observableArrayList();

                while(rs9.next()){
                    leyenda9.add(""+rs9.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
                    dataSeries9.getData().add(new XYChart.Data<>(""+rs9.getString(1), rs9.getInt(2))); // posicion 1 es la leyenda    
                }
                Eje.setCategories(leyenda9);  // se asigna la leyenda a la grafica
                grafSentencia.getData().addAll(dataSeries9); // se agrega la serie de datos
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL SERVER" + e);
            }
        }
        else{
            System.out.println("No conexion");
        }      
    }    
    
    @FXML
    private void btnlistRR(){
        
    }
    
    @FXML
    private void btnAgregarHistorial(){
        this.ventana_menu.setVisible(true);
        this.ventana_registroHistorial.setVisible(false);
    }
    
    @FXML
    private void btnCerrar(){ 
        this.ventana_inicio.setVisible(true);
        this.ventana_menu.setVisible(false);
    }

    private Statement setString(int i, String conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
