import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Archivos {

    public static Scanner leer = new Scanner(System.in);
    public static void main(String[] args){
        newArchivoJSON("Archivos", "Hola");
    }
    public static void CrearCarpeta(String Nombre){
        File Carpeta = new File(Nombre);
        Carpeta.mkdirs();
    }

    public static Boolean archivoExists(String carpeta, String archivo){
        File Archivo = new File(carpeta + "/" + archivo);
        return Archivo.exists();
    }

    public static Boolean isArchivoNull(String carpeta, String archivo){
        BufferedReader Lector;

        try {
            Lector = new BufferedReader(new FileReader( carpeta + "/" + archivo));
            return (Lector.readLine() == null);

        } catch (IOException error) {
            error.printStackTrace();
        }
        return true;
    }

    public static File[] ListaArchivos(String carpeta){
        CrearCarpeta(carpeta);
        File Carpeta = new File(carpeta);
        return Carpeta.listFiles();
    }


    //Archivos Json

    public static void newArchivoJSON(String carpeta, String Nombre){
        CrearCarpeta(carpeta);
        JSONObject JSON = new JSONObject();

        try (FileWriter file = new FileWriter(carpeta + "/" + Nombre + ".json")) {

            if (isArchivoNull(carpeta, Nombre + ".json")){
                file.write(JSON.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject leerArchivoJson(String carpeta, String Nombre){
        BufferedReader Lector;
        JSONObject Contenido = new JSONObject();

        try {
            Lector = new BufferedReader(new FileReader( carpeta + "/" + Nombre + ".json"));
            Contenido = new JSONObject(Lector.readLine());

        } catch (IOException error) {
            error.printStackTrace();
        }
        return Contenido;
    }


    public static ArrayList<JSONObject> leerJsonArray(JSONObject json){// Guarda los valores de un json dentro de un arraylist
        ArrayList<JSONObject> lisUsuarios = new ArrayList<>();

        for(String key : json.keySet()){
            lisUsuarios.add((JSONObject) json.get(key));
        }

        return lisUsuarios;
    }
}
