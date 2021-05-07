package volatilePackage;


import java.util.Scanner;

class Tasker extends Thread{

    //a 'volatile' gátolja, hogy az adott változó cache-elve legyen.
    //mivel ez az osztály a kill()-t nem hívja meg, így a  változó értéke cache-elve lesz, 'true' értékkel!
    private volatile boolean runner = true;

    @Override
    public void run(){

        while(runner) {

            System.out.println("futááás");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void kill(){
        this.runner = false;
    }
}

public class Volatile {


    public static void main(String[] args) {


        Tasker t1 = new Tasker();
        t1.start();

        System.out.println("Nyomjon meg egy billentyűt!");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

       //Enter nyomás után meg áll a szál.
        t1.kill();

    }
}
