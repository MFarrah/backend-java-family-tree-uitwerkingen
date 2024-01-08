package nl.MFarr;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setOwner() {
        //arrange
        var jazz = new Person("Jazz", "Farrah Girgis", 9, "female");
        Pet houdini = new Pet("Houdini", 11, "Cat");
        //act
        houdini.setOwner(jazz);
        //assert
        assertTrue(houdini.getOwner().equals(jazz));
    }
}