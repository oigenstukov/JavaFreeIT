package L24T01.animals;

public class Dog extends Pet {
    private String breed;
    private boolean allergic;

    public Dog() {
    }

    public Dog(String name, int age, String breed, boolean allergic) {
        super(name, age);
        this.breed = breed;
        this.allergic = allergic;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isAllergic() {
        return allergic;
    }

    public void setAllergic(boolean allergic) {
        this.allergic = allergic;
    }

    @Override
    public String toString() {
        return "\nName: \"" + super.getName() + '\"' +
                "\nage: " + super.getAge() +
                "\nbreed: " + breed +
                "\nallergic: " + allergic +
                '\n';
    }
}
