package main.java.com.example.task3;

public class MyProducer implements Runnable {
    private MyList list;

    public MyProducer(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < MyList.getCapacity(); i++) {
            list.add();
        }
    }
}
