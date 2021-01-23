package main.java.com.example.task1;

public class Main {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("a");
        /*
        е) В методе main() создайте один объект класса StringBuilder, используя символ ‘a’. Затем
        создайте три экземпляра объекта нашего класса и запустите потоки.
         */
        int numberOfThreads = 3;
        for (int i = 0; i < numberOfThreads; i++) {
            System.out.println("Thread " + (i+1) + " starting:");
            new MyThread(str).run();
        }
    }
}
