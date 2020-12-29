package task1;

/**
 * Необходимо реализовать класс-обертку над массивом ArrayWrapper,
 * который может хранить массив любого типа данных. Индексация
 * элементов этим классов ведется от 1.
 *
 * @param <T> array type
 */

public class ArrayWrapper<T> {
    private T[] arr;

    /**
     * Определить один конструктор, в который передается массив любого типа.
     *
     * @param arr array of any type
     */
    public ArrayWrapper(T[] arr) {
        this.arr = arr;
    }

    /**
     * Определить метод получения элемента по индексу (пример: get(2)) (счет
     * ведется от 1, а не от 0).
     *
     * @param index index of element
     * @return array element
     */
    public T get(int index) {
        if (index < 1 || index > this.arr.length) {
            throw new IncorrectArrayWrapperIndex("Incorrect element index");
        } else {
            return this.arr[index - 1];
        }
    }

    /**
     * Определить метод замены элемента по определенному индексу (пример:
     * replace(1, “Test”)). Реализовать следующие ограничения:
     * Для String: заменить строку можно только на строку большей длины
     * Для Integer: заменить число можно только на большее по значению
     * Метод replace должен возвращать boolean значение успешности замены.
     *
     * @param index index of element
     * @param newElement new element
     * @return "true" if replacement was successful
     */
    public boolean replace(int index, T newElement) {
        if (index < 1 || index > this.arr.length) {
            throw new IncorrectArrayWrapperIndex("Incorrect element index");
        }
        if (newElement instanceof String) {
            String newStr = (String) newElement;
            String oldStr = (String) this.arr[index - 1];
            if (newStr.length() > oldStr.length()) {
                this.arr[index - 1] = newElement;
                return true;
            } else {
                System.out.println("String length must be longer");
                return false;
            }
        }
        if (newElement instanceof Integer) {
            Integer newInt = (Integer) newElement;
            Integer oldInt = (Integer) this.arr[index - 1];
            if (newInt > oldInt) {
                this.arr[index - 1] = newElement;
                return true;
            } else {
                System.out.println("Int must be bigger");
                return false;
            }
        } else {
            this.arr[index - 1] = newElement;
            return true;
        }
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }
}
