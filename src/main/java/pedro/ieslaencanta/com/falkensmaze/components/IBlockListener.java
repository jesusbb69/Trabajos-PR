/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.components;

/**
 * Interfaz para escuchar eventos de clic en un bloque.
 * Implementa esta interfaz para manejar eventos de clic y doble clic en un bloque.
 * @author JBB
 */
public interface IBlockListener {
    
    /**
     * Método al cual se accede cuando se hace clic en un bloque.
     * @param b El bloque en el que se hizo clic.
     */
    public void onClicked(Block b);
    
    /**
     * Método al cual se accede cuando se hace doble clic en un bloque.
     * @param b El bloque en el que se hizo doble clic.
     */
    public void onDoubleClicked(Block b);
}
