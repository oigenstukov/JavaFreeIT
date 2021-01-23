package main.java.com.example.task1;

/*
a) Создать класс расширяющий Thread.
 */
public class MyThread extends Thread {
    StringBuilder str;

    /**
     * в) Для того чтобы три объекта потока имели доступ к одному объекту, создаем конструктор
     * принимающий на вход StringBuilder объект.
     *
     * @param str letter
     */
    public MyThread(StringBuilder str) {
        this.str = str;
    }

    /**
     * б) Переопределить метод run() - здесь будет находиться синхронизированный блок кода.
     */
    @Override
    public void run() {
        /*
        г) Синхронизированный блок кода будет получать монитор на объект StringBuilder из пункта
        в).
         */
        synchronized (str) {
            /*
            д) Внутри синхронизированного блока кода выведите StringBuilder на экран 100 раз, а потом
            увеличьте значение символа на 1.
             */
            for (int i = 0; i < 100; i++) {
                System.out.print(str + " ");
            }
            char c = str.charAt(0);
            c += 1;
            str.setCharAt(0, c);
            System.out.println();
        }
    }
}
