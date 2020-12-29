package task01;

import java.util.Objects;

/**
 * Создайте класс Кошка с параметрами цвет глаз, порода.
 */
public final class Cat {
    /**
     * Сделайте его объекты immutable, ...
     */
    private final String name;
    private final EyeColour eyeColour;
    private final CatBreed breed;

    public Cat(String name, EyeColour eyeColour, CatBreed breed) {
        this.name = name;
        this.eyeColour = eyeColour;
        this.breed = breed;
    }

    /**
     * ...но при этом добавьте возможность setters на объектах этого класса
     *
     * @param name cat's name
     * @return a new instance of the class
     */
    public Cat setName(String name) {
        return new Cat(name, this.eyeColour, this.breed);
    }

    public Cat setEyeColour(EyeColour eyeColour) {
        return new Cat(this.name, eyeColour, this.breed);
    }

    public Cat setBreed(CatBreed breed) {
        return new Cat(this.name, this.eyeColour, breed);
    }

    public String getName() {
        return name;
    }

    public EyeColour getEyeColour() {
        return eyeColour;
    }

    public CatBreed getBreed() {
        return breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) &&
                eyeColour == cat.eyeColour &&
                breed == cat.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eyeColour, breed);
    }

    @Override
    public String toString() {
        return "Cat" +
                "\nname\t" + name +
                "\neyes\t" + eyeColour.toString().toLowerCase() +
                "\nbreed\t" + breed.toString().toLowerCase();
    }
}
