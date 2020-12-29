package L24T01.animals;

public class Parrot extends Pet implements Comparable<Parrot> {
    private String species;
    private boolean flying;

    public Parrot() {
    }

    public Parrot(String name, int age, String species, boolean flying) {
        super(name, age);
        this.species = species;
        this.flying = flying;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    @Override
    public int compareTo(Parrot o) {
        return super.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "\nParrot: " +
                "\nName: \"" + super.getName() + '\"' +
                "\nage: " + super.getAge() +
                "\nspecies: " + species +
                "\nflying: " + flying +
                '\n';
    }
}
