package nl.MFarr;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String middleName;
    private String lastName;
    private int age;
    private String sex;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;


    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    /*een tweede constructor voor de NIET verplichte optie middleName*/
    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }
    /*getters voor alle attributen*/
    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    /*setters voor de attributen minus namen*/
    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    /*methods*/
    public void addParent(Person mother, Person father, Person child) {
        child.setMother(mother);
        mother.addChildToChildren(mother, child);
        child.setFather(father);
        father.addChildToChildren(father, child);
    }

    public void addChildToChildren(Person parent, Person child) {
        List<Person> kids = new ArrayList<>();
        if (parent.getChildren() != null) {
            for (Person person : parent.getChildren()) {
                kids.add(person);
            }
        }
        kids.add(child);
        parent.setChildren(kids);
    }

    public void addPet(Person person, Pet pet) {
        List<Pet> pets = new ArrayList<>();
        if (person.getPets() != null) {
            pets.addAll(person.getPets());
        }
        pets.add(pet);
        person.setPets(pets);
    }

    public void addSiblings(Person person, Person sibling) {
        List<Person> family = new ArrayList<>();
        if (person.getSiblings() != null) {
            for (Person people : person.getSiblings()) {
                family.add(people);
            }
        }
        family.add(sibling);
        person.setSiblings(family);
    }
    /*grandChildren identifier*/
    public List<Person> getGrandChildren () {
        List<Person> grandChildren = new ArrayList<>();
        if (getChildren() != null) {
            for (Person children : getChildren()) {
                if (children.getChildren() != null) {
                    for (Person grandChild : children.getChildren()) {
                        grandChildren.add(grandChild);
                    }
                }
            }
        }
        return grandChildren;
    }

}
