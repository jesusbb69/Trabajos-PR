/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;


import java.io.UnsupportedEncodingException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import pedro.ieslaencanta.com.falkensmaze.Size;

/**
 * Representa un laberinto.
 * Un laberinto formado por una matriz de bloques,  tamaño, tiempo y sonido
 * Permite iniciarlo, crearlo, poder guardarlo 
 * @author Tus Iniciales
 */

@XmlRootElement
public class Maze implements  Serializable{

    private Size size;
    private Block[][] blocks;
    private double time;
    private String sound;
    
    /**
     * Constructor por defecto de la clase Maze.
     * Crea un laberinto vacío sin tamaño, bloques, tiempo ni sonido.
     */

    public Maze() {
    }
    
    /**
     * Inicializa el laberinto creando una matriz de bloques con las dimensiones especificadas.
     * Cada bloque se inicializa como vacío.
     */

    public void init() {
        this.setBlocks(new Block[this.getSize().getHeight()][this.getSize().getWidth()]);
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = new Block();

            }
        }
    }
    
    

    public void reset() {
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = null;

            }
        }
        this.setBlocks(null);
    }
    
     /**
     * Reinicia el laberinto eliminando todos los bloques y estableciendo un nuevo tamaño.
     * @param newsize El nuevo tamaño del laberinto.
     */

    public void reset(Size newsize) {
        this.reset();;
        this.setSize(newsize);
        this.init();
    }
    
    /**
     * Establece el valor de un bloque en la posición dada.
     * @param value El valor a establecer en el bloque.
     * @param row La fila del bloque.
     * @param col La columna del bloque.
     */

    public void setBlockValue(String value, int row, int col) {
        this.getBlocks()[col][row].setValue(value);
    }
    
    /**
     * Obtiene el valor de un bloque en la posición especificada.
     * @param row La fila del bloque.
     * @param col La columna del bloque.
     * @return El valor del bloque en la posición especificada.
     */

    public String getBlockValue(int row, int col) {
        return this.getBlocks()[row][col].getValue();
    }
    
    // Getters y setters tipicos del programa

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }
    
    /**
     * Carga un laberinto desde un archivo en el formato determinado por la extensión del archivo.
     * Admite los formatos XML, JSON y binario.
     * @param file El archivo del cual se cargará el laberinto.
     * @return El laberinto cargado desde el archivo.
     * @throws JAXBException Si ocurre un error durante la serialización/deserialización XML.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     * @throws FileNotFoundException Si el archivo especificado no se encuentra.
     * @throws ClassNotFoundException Si no se encuentra la clase durante la deserialización binaria.
     * @throws Exception Si ocurre un error durante el proceso de carga del archivo.
     */

    public static Maze load(File file) throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException, Exception {
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Maze m = null;
        if (extension.equals("xml")) {
            m = Maze.loadXML(file);
        } else {
            if (extension.equals("json")) {
                m = Maze.loadJSON(file);

            } else {
                if (extension.equals("bin")) {
                    m = Maze.loadBin(file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
        return m;

    }
    
    /**
     * Guarda el laberinto en un archivo especificado en el formato determinado por la extensión del archivo.
     * Admite los formatos XML, JSON y binario.
     * @param maze El laberinto a guardar.
     * @param file El archivo donde se guardará el laberinto.
     * @throws JAXBException Si ocurre un error durante la serialización/deserialización XML.
     * @throws Exception Si ocurre un error durante el proceso de guardado del archivo.
     */

    public static void save(Maze maze, File file) throws JAXBException, Exception {
        if (maze.sound == null || maze.sound.equals("")) {
            throw new Exception("Es necesario indicar el sonido del laberinto");
        }
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (extension.equals("xml")) {
            Maze.saveXML(maze, file);
        } else {
            if (extension.equals("json")) {
                Maze.saveJSON(maze, file);

            } else {
                if (extension.equals("bin")) {
                    Maze.saveBin(maze, file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
    }
    
  

    private static Maze loadJSON(File file) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        Reader reader;
        reader = Files.newBufferedReader(file.toPath());
        Maze m = gson.fromJson(reader, Maze.class);
        reader.close();
        return m;
    }

    private static Maze loadXML(File file) throws JAXBException, IOException {

           JAXBContext context = JAXBContext.newInstance(Maze.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Maze maze = (Maze) unmarshaller.unmarshal(
                        file);
                return maze;
          
    }
    
      /**
     * Carga un laberinto desde un archivo binario.
     * @param file El archivo binario del cual se cargará el laberinto.
     * @return El laberinto cargado desde el archivo binario.
     * @throws FileNotFoundException Si el archivo especificado no se encuentra.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     * @throws ClassNotFoundException Si no se encuentra la clase durante la deserialización binaria.
     */

    public static Maze loadBin(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream os = new FileInputStream(file);
        
        ObjectInputStream oos = new ObjectInputStream(os);
        Maze m = (Maze) oos.readObject();
        oos.close();;
        os.close();
        return m;
    }

    private static void saveJSON(Maze maze, File file) throws FileNotFoundException, UnsupportedEncodingException {
        Gson gson = new Gson();
        String json = gson.toJson(maze);
        java.io.PrintWriter pw = new PrintWriter(file, "UTF-8");
        pw.print(json);
        pw.close();
    }

    private static void saveXML(Maze maze, File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(maze.getClass());
        // create an instance of `Marshaller`
        Marshaller marshaller = context.createMarshaller();
        // enable pretty-print XML output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // write XML to `StringWriter`
        FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);//(file, "UTF-8");
        marshaller.marshal(maze, fw);
        fw.close();

    }
    
     /**
     * Guarda un laberinto en un archivo binario.
     * @param maze El laberinto a guardar.
     * @param file El archivo binario donde se guardará el laberinto.
     * @throws FileNotFoundException Si el archivo especificado no se encuentra.
     * @throws IOException Si ocurre un error durante la escritura del archivo.
     */

    public static void saveBin(Maze maze, File file) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(maze);
        oos.close();;
        os.close();
    }

}
