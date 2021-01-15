/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class ejercicio_01_tema04_ed 
{
    private static byte[] amortiguar = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream amortiguarEntrada = null;

    public static void inicializarArchivo() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(nombreArchivo);
        amortiguarEntrada = new BufferedInputStream(flujoEntrada);
    }
    
    public static int mostrarTextoArchivo() throws IOException
    {
        int Resultado = 0;
        int nLeer = 0;
        while((nLeer = flujoEntrada.read(amortiguar)) != -1) 
        {
            System.out.println(new String(amortiguar));
            Resultado += nLeer;
        }
        
        return Resultado;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivo();
            
            int resultado = mostrarTextoArchivo();           

            System.out.println("\nLeídos " + resultado + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( amortiguarEntrada != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    amortiguarEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
