public class Main {
    public static int mValue = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable logic = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(2000);
                    System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
                }
            } catch (InterruptedException err) {

            } finally {
                System.out.printf("%s завершен\n", Thread.currentThread().getName());
            }

        };


        ThreadGroup threadGroup = new ThreadGroup("main group");

        Thread thread1 = new Thread(threadGroup, logic);
        Thread thread2 = new Thread(threadGroup, logic);
        Thread thread3 = new Thread(threadGroup, logic);
        Thread thread4 = new Thread(threadGroup, logic);

        thread1.setName("поток 1");
        thread2.setName("поток 2");
        thread3.setName("поток 3");
        thread4.setName("поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(15000);
        threadGroup.interrupt();
        //  threadGroup.interrupt();

    }

}
