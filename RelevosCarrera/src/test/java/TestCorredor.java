/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.udec.relevoscarrera.Carril;
import com.udec.relevoscarrera.Corredor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angie Manrique. Alisson Celeita
 */
public class TestCorredor {
    Corredor corredor=new Corredor();
    public TestCorredor() {
    }
    
    /**
     * Testeo del metodo que genera numeros random
     */
    @Test
    public void testRandom(){
        int resultado=corredor.cantidadPasos();
        assertTrue(resultado>=1&&resultado<=3); 
    }
    
    
}
