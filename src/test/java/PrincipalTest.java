/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.relevos.Equipo;
import com.mycompany.relevos.Utilitarios;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alejo02
 */
public class PrincipalTest {
    
    public PrincipalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("iniciando testing");
        
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("finalizando testing");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void randomTest(){
        int numero = Utilitarios.random();
        if(numero == 1){
            assertEquals(1, numero);
        }else if(numero == 2){
            assertEquals(2, numero);
        }else if(numero == 3){
            assertEquals(3, numero);
        }else if(numero > 3){
            assertFalse("No cumple", false);
        }
        
    }
    
    @Test
    public void imprimirTest(){
        Equipo equi = new Equipo("Amarillo", "A");
        boolean si = equi.concatenarImpresion().contains("Equipo : ");
        assertTrue(si);
    }
    
}
