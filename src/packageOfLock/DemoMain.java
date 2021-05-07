package packageOfLock;

import java.util.ArrayList;

class Locker {

    private ArrayList<Integer> numbers1 = new ArrayList<>();
    private ArrayList<Integer> numbers2 = new ArrayList<>();

    /*
     * két kulcsot hozunk létre, tehát míg az egyik szál bemegy az egyik kulccsal az egyik ajtón,
     * másik ugyanezt teszi csak másik ajtón másik kulccsal, így nem várják be egymást és nem gyarapodik a futási idő.
     *
     * a 'synchronized'-os metódusnak köszöhetően tudnak egymástól függetlenül dolgozni a szálak.
     * */
    private Object lockOne = new Object();
    private Object lockTwo = new Object();

    public ArrayList<Integer> getNumbers1() {
        return numbers1;
    }

    public ArrayList<Integer> getNumbers2() {
        return numbers2;
    }

    public void doorOne() throws InterruptedException {

        synchronized (lockOne) {
            numbers1.add(10);
            Thread.sleep(1);
        }
    }

    public void doorTwo() throws InterruptedException {

        synchronized (lockTwo) {
            numbers2.add(10);
            Thread.sleep(1);
        }
    }
    public void doWork() throws InterruptedException {

        for (int i = 0; i < 500; i++) {

            doorOne();
            doorTwo();

        }
    }

}

public class DemoMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Kezdjük!");
        long star = System.currentTimeMillis();
        Locker locker = new Locker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    locker.doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    locker.doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //így három szálunk van: a main(), a t1 és a t2 és mindhárom párhuzamosan fut.
        //main()-en belül a 'sout' kerül meghívásra
        //elidítjuk a két szálat
        t1.start();
        t2.start();
        //.join()-nal bevárjuk, hogy a két szál elvégezze a rászabott feladatokat.
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(end - star + " milisec a futási idő!");
        System.out.println(locker.getNumbers2().size());
        System.out.println(locker.getNumbers1().size());
    }
}
