public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "inside runnable using an anonymous inner class");
            }
        }).start();
    }
}