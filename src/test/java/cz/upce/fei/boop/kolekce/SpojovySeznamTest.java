package cz.upce.fei.boop.kolekce;

import org.junit.*;

import static org.junit.Assert.*;

/**
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

    @Test
    public void test_01_VlozPrvni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);

            assertEquals(1, seznam.size());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_02_VlozPrvni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T2);
            seznam.vlozPrvni(T3);

            assertEquals(3, seznam.size());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_VlozPosledni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPosledni(T1);

            assertEquals(1, seznam.size());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_02_VlozPosledni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPosledni(T1);
            seznam.vlozPosledni(T2);
            seznam.vlozPosledni(T3);

            assertEquals(3, seznam.size());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_NastavPrvni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.nastavPrvni();
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_NastavPosledni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);

            seznam.nastavPosledni();
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_Dalsi() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T2);

            seznam.nastavPrvni();
            seznam.dalsi();
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_JeDalsi() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T2);

            seznam.nastavPrvni();
            assertTrue(seznam.jeDalsi());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_VlozZaAktualni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.nastavPrvni();
            seznam.vlozZaAktualni(T2);

            assertEquals(2, seznam.size());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_JePrazdny() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();

            assertTrue(seznam.jePrazdny());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_DejPrvni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);

            assertEquals(T1, seznam.dejPrvni());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_02_DejPrvni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T2);


            assertEquals(T2, seznam.dejPrvni());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_DejPosledni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPosledni(T2);


            assertEquals(T2, seznam.dejPosledni());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_DejAktualni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.nastavPrvni();

            assertEquals(T1, seznam.dejAktualni());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_DejZaAktualnim() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.nastavPrvni();
            seznam.vlozPosledni(T2);

            assertEquals(T2, seznam.dejZaAktualnim());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_OdeberPrvni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPosledni(T2);

            assertEquals(T1, seznam.odeberPrvni());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_OdeberPosledni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPosledni(T2);

            assertEquals(T2, seznam.odeberPosledni());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_OdeberAktualni() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.nastavPrvni();
            seznam.vlozPosledni(T2);

            assertEquals(T1, seznam.odeberAktualni());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_OdeberZaAktualnim() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.nastavPrvni();
            seznam.vlozPosledni(T2);

            assertEquals(T2, seznam.odeberZaAktualnim());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void test_01_Size() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPosledni(T2);

            assertEquals(2, seznam.size());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test()
    public void test_01_Zrus() {
        try {
            SpojovySeznam seznam = new SpojovySeznam();
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T1);
            seznam.vlozPrvni(T1);
            seznam.nastavPosledni();

            seznam.zrus();
            assertEquals(0, seznam.size());
        } catch (Exception ex) {
            fail();
        }
    }
}