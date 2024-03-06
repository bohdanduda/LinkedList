package cz.upce.fei.boop.kolekce;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karel@simerda.cz
 */
public class SpojovySeznamTest {

    /**
     * Testovací třída pro ověření implementace třídy SpojovySeznam
     */
    private static class TestClass {

        int a;

        public TestClass(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return "T" + a;
        }

    }
    /***
     * Sada instancí testovací třídy pro ověření implementace třídy SpojovySeznam
     */
    private final TestClass T1 = new TestClass(1);
    private final TestClass T2 = new TestClass(2);
    private final TestClass T3 = new TestClass(3);
    private final TestClass T4 = new TestClass(4);
    private final TestClass T5 = new TestClass(5);
    private final TestClass T6 = new TestClass(6);
    private final TestClass T7 = new TestClass(7);
    private final TestClass T8 = new TestClass(8);
    private final TestClass T9 = new TestClass(9);
  

    public SpojovySeznamTest() {
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

// TODO Každou veřejnou metodu třídy SpojovySeznam ověřte alespoň jedním testem  
// TODO Dosáhněte 100% pokrytí třídy SpojovySeznam tímto testem    
    
// Ukázka jednoduchého testu    
//    @Test
//    public void test_01_01_VlozPrvni() {
//        try {
//            LinkSeznam<TestClass> instance = new LinkSeznam<>();
//            instance.vlozPrvni(T1);
//            TestClass[] expected = T1;
//            TestClass[] result = instance.dejPrvni();//            
//            assertEquals(expected, result);
//        } catch (Exception ex) {
//            fail();
//        }
//    }
// Ukázka testu s vícenásobnou kontrolou stavu testované instance
//    @Test
//    public void test_01_02_VlozPrvni() {
//        try {
//            LinkSeznam<TestClass> instance = new LinkSeznam<>();
//            instance.vlozPrvni(T1);
//            instance.vlozPrvni(T2);
//            TestClass[] result = {instance.dejPrvni(), instance.dejPosledni()};
//            TestClass[] expected = {T2, T1};
//            assertArrayEquals(expected, result);
//        } catch (Exception ex) {
//            fail();
//        }
//    }
//
//  Ukázka testu s vyvoláním výjimky   
//    @Test(expected = NullPointerException.class)
//    public void test_01_04_VlozPrvni() throws KolekceException {
//        LinkSeznam<TestClass> instance = new LinkSeznam<>();
//        instance.vlozPrvni(null);
//        fail();
//    }
}
