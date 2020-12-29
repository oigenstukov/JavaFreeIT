package task01;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Name1", EyeColour.BLUE, CatBreed.MAINE_COON);
        Cat cat1 = cat.setBreed(CatBreed.PERSIAN);
        System.out.println(cat.toString());
        System.out.println(cat1.toString());
    }
}
