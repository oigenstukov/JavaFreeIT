package main.java.com.example.task3;

public class Main {

    public static void main(String[] args) {
        MyList list = new MyList(10);
        MyProducer producer = new MyProducer(list);
        MyConsumer consumer = new MyConsumer(list);
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
