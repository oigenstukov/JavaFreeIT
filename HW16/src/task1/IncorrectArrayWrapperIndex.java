package task1;

/**
 * Реализовать класс-исключение throw new IncorrectArrayWrapperIndex
 * (unchecked), которое выбрасывается при выходе за границы.
 *
 */
public class IncorrectArrayWrapperIndex extends RuntimeException {
    public IncorrectArrayWrapperIndex(String message) {
        super(message);
    }
}
