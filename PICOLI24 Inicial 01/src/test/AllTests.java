package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    YoungTest.class,
    ControlSeresTest.class,
    seresTest.class// Añade aquí las demás clases de prueba
})
public class AllTests {
}
