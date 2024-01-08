package nl.MFarr;

public class Pet {

    private String name;
    private int age;
    private String species;
    private Person owner;

    public Pet(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }
    /*getters voor pet attributen*/
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public Person getOwner() {
        return owner;
    }

    /*setter voor toewijzing van attribuut aan Person class*/
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
