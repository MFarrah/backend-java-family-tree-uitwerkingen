package nl.MFarr;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addParent() {
        // arrange
        var mathilde = new Person("Mathilde", "Bellwinkel", 70, "female");
        var ibrahim = new Person("Ibrahim", "Farrah Girgis", 0, "male");
        var suzanne = new Person("Suzanne", "Farrah Girgis", 34, "female");
        var michael = new Person("Michael", "Farrah Girgis", 38, "male");
        // act
        suzanne.addParent(mathilde, ibrahim, suzanne);
        michael.addParent(mathilde, ibrahim, michael);
        Person mother = suzanne.getMother();
        Person father = michael.getFather();
        // assert
        assertEquals(mathilde.getName(), mother.getName());
        assertEquals(ibrahim.getName(), father.getName());
        assertTrue(ibrahim.getChildren().contains(michael));
        assertTrue(mathilde.getChildren().contains(suzanne));
    }

    @Test
    void addChildToChildren() {

        //arrange
        var michael = new Person("Michael", "Farrah Girgis", 38, "male");
        var jazz = new Person("Jazz", "Farrah Girgis", 9, "female");
        //act
        michael.addChildToChildren(michael, jazz);
        //assert
        assertTrue(michael.getChildren().contains(jazz));
    }

    @Test
    void addPet() {
        //arrange
        var jazz = new Person("Jazz", "Farrah Girgis", 9, "female");
        Pet houdini = new Pet("Houdini", 11, "Cat");
        //act
        jazz.addPet(jazz, houdini);
        var cat = jazz.getPets();
        //assert
        assertEquals(jazz.getPets(), cat);
    }

    @Test
    void addSiblings() {
        //arrange
        var suzanne = new Person("Suzanne", "Farrah Girgis", 34, "female");
        var michael = new Person("Michael", "Farrah Girgis", 38, "male");
        //act

        michael.addSiblings(michael, suzanne);
        var sister = michael.getSiblings();
        //assert
        assertEquals(michael.getSiblings(), sister);
    }

    @Test
    void getGrandChildren() {
        // arrange
        var helma = new Person("Helma", "Bellwinkel", 0, "female");
        var mathilde = new Person("Mathilde", "Bellwinkel", 70, "Female");
        var michael = new Person("Michael", "Farrah Girgis", 38, "male");
        // act
        helma.addChildToChildren(helma, mathilde);
        mathilde.addChildToChildren(mathilde, michael);
        // assert
        List<Person> grandChildren = helma.getGrandChildren();
        assertTrue(grandChildren.contains(michael));
    }
}
