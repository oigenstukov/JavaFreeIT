package task1;

public class NewThread extends Thread {

    public NewThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.print("a");
        }
    }
}
