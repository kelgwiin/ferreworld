package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Kelwin Gamez
 */
public class Conexion {
	
	public static void main(String arhs[]){
		
	}
	//Declaracion de atributos
    private Connection conexion;
    private Statement statement;
    private String  servidor, puerto,usuario, clave, database, ruta_driver,distribuidor;
    //fin-declaraciones
    
    //--------------
    //CONSTRUCTORES
    //--------------
  
    public Conexion(String servidor, String puerto, String database,
    		String usuario, String clave){

        this.servidor = servidor;
        this.puerto = puerto;
        this.database = database;
        this.ruta_driver = "com.mysql.jdbc.Driver";
        this.distribuidor = "mysql";
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public Conexion(){
        this.servidor = "localhost";
        this.puerto = "3306";
        this.usuario = "admin";
        this.clave = "admin";
        this.database = "ferrew";
        this.distribuidor = "mysql";
        this.ruta_driver = "com.mysql.jdbc.Driver";
    } //fin-CONSTRUCTORES

    //--------------------------
    //METODOS OBSERVADORES
    //--------------------------
    /**
     * @return Retorna el url para la coneccion a la base de datos.
     */
    public String getUrl(){
        return "jdbc:" + distribuidor + ":"+puerto+ "//" + servidor + "/" + database;
    }
    
    /**
     * @return
     * Puerto de la BD.
     */
    public String getPuerto(){
        return puerto;
    }
    /**
     * @return Nombre del servidor.
     */
    public String getServidor(){
        return servidor;
    }
   
    public String getUsuario(){
        return usuario;
    }
    
    public String getDatabase(){
        return database;
    }
    
    
    public String getDistribuidor(){
        return distribuidor;
    }
    
    public String getRuta_driver(){
        return ruta_driver;
    }//Fin-Metodos OBSERVADORES
                                 //Metodos MODIFICADORES
    /**
     * @param puerto  Nombre del puerto de la BD.
     */
     public void setPuerto(String puerto){
        this.puerto = puerto;
    }
    /**
     * @param servidor Nombre del servidor de alojamiento de la BD.
     */
     public void setServidor(String servidor){
        this.servidor = servidor;
    }    
    /**
     * @param usuario  Nombre del usuario que iniciará sesión.
     */
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    /**
     * @param database Nombre de la base de datos.
     */
    public void setDatabase(String database){
        this.database = database;
    }
    
    /**
     * @param distribuidor Nombre del distribuidor de la BD
     */
    public void setDistribuidor(String distribuidor){
        this.distribuidor = distribuidor;
    }
    /**
     * @param ruta_driver Lugar donde se encuentra la BD.
     */
    public void setRuta_driver(String ruta_driver){
        this.ruta_driver = ruta_driver;
    }
    //fin-metodos MODIFICADORES
    
    //------------------------------
    //METODOS - ADICIONALES.
    //------------------------------
     public boolean conectar(){
    	boolean estado = true;       
    	 
        try{
            Class.forName(ruta_driver);         
             conexion = DriverManager.getConnection(getUrl() ,this.usuario,this.clave);
             conexion.setAutoCommit(false);
             statement = conexion.createStatement();   
        }catch (SQLException sqle){
              estado = false;
              System.out.println("Error de SQl: "+sqle.getMessage());
        }catch(ClassNotFoundException e){
            estado = false;
            System.out.println("No se encuentra el driver: "+e.getMessage());
        }catch (Exception eg ){
            estado = false;
            System.out.println("Error generico: "+eg.getMessage());
        }
        return estado;
    }
    /**
     * Reconecta con los valores que ya tiene la clase
     * y retorna el valor booleano que viene de conectar
     */
    public boolean Reconectar(){
        desconectar();
        return conectar();
    }

    /**
     * Este metodo es usado para desconectar la base de datos.
     */
    public void desconectar(){
        try{
            conexion.close();
        }catch (SQLException sqle){
            System.out.println("Error al cerrar conexion");
        }catch ( Exception e ){
            System.out.println("Error general");
        }
   }
    
    public ResultSet Consultar(String strConsulta){
        ResultSet resultado = null;
        boolean good = true;
        try{
            statement = conexion.createStatement();//se prepara la consulta
            resultado = statement.executeQuery(strConsulta);
        }catch(SQLException sqle){
            good = false;
          System.out.println("Error de SQL: en consulta de datos(266): "+sqle.getMessage());
        }
        catch(Exception e){
            good = false;
            System.out.println("Error generico: "+e.getMessage());
        }
        
        if(!good){
            Reconectar();
        }
        return resultado;
    }
    
     public boolean Actualizar(String strSQL){
         boolean ret = true;
        try{
            statement = conexion.createStatement();

            statement.execute("BEGIN");
            statement.execute(strSQL);
            statement.execute("END");
            statement.close();
           }catch(SQLException sqle){
             ret = false;
             System.out.println("Error de SQL, actualizar(297)\n"+sqle.getMessage());
           }catch(Exception e){
               ret = false;
              System.out.println("Error genérico, actualizar (300)\n"+e.getMessage());
           }
         return ret;
     }  
}
