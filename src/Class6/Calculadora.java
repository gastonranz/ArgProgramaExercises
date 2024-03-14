package Class6;

public class Calculadora {
    public double sumar(double num, double num2) {
        return num + num2;
    }

    public double restar(double num, double num2) {
        return num + num2;
    }

    public double multiplicar(double num, double num2) {
        return num * num2;
    }

    public double dividir(double num, double num2) {
        return num / num2;
    }

    /* NETBEANS:
    import org.junit.After;
    import org.junit.AfterClass;
    import org.junit.Before;
    import org.junit.BeforeClass;
    import org.junit.Test;
    import static org.junit.Assert.*;

    public class CalculadoraTest {

        public CalculadoraTest() {
        }

        @BeforeClass
        public static void setUpClass() {
        }

        @AfterClass
        public static void tearDownClass() {
        }

        @Before
        public void setUp() {
        }

        @After
        public void tearDown() {
        }


        @Test
        public void testSumar() {
            System.out.println("sumar");
            double num = 70.0;
            double num2 = 40.0;
            Calculadora instance = new Calculadora();
            double expResult = 2700.0;
            double result = instance.sumar(num, num2) * 25;
            assertEquals(expResult, result, 0);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is not reviewed yet.");
        }

        @Test
        public void testMultiplicar() {
            System.out.println("multiplicar");
            double num = 80.0;
            double num2 = 3.0;
            Calculadora instance = new Calculadora();
            double expResult = 240.0;
            double result = instance.multiplicar(num, num2);
            assertEquals(expResult, result, 0);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        }

        @Test
        public void testRestar() {
            System.out.println("restar");
            double num = 90.0;
            double num2 = 50.0;
            Calculadora instance = new Calculadora();
            double expResult = 605.0;
            double result = instance.restar(num, num2) * 15;
            assertEquals(expResult, result, 0);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        }

        @Test
        public void testDividir() {
            System.out.println("dividir");
            double num = 1.0;
            double num2 = 1.0;
            Calculadora instance = new Calculadora();
            double expResult = 1.0;
            double result = instance.dividir(num, num2);
            assertEquals(expResult, result, 0);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        }

    }
    */
}
