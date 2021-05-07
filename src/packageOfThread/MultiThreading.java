package packageOfThread;
/*
class Tasker extends Thread{
    public void run(){

        for (int i = 0; i < 5 ; i++) {

            System.out.println("Mellékszál. " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
*/


class Tasker implements Runnable{

    @Override
    public void run(){

        for (int i = 0; i < 5 ; i++) {

            System.out.println("Mellékszál. " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class MultiThreading {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Tasker());
        Thread t2 = new Thread(new Tasker());

        t1.start();
        t2.start();
        
        /*
        Tasker run1 = new Tasker();
        run1.start();

        Tasker run2 = new Tasker();
        run2.start();
        */
    }
}
