package executorPack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskUnit implements Runnable{

    private int id;

    public TaskUnit(int id) {
        this.id = id;
    }

    public void run() {

        System.out.println("Feladat elindult, id: " + this.id);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A feladat befejeződött/elkészült, id: " + this.id);
    }
}

public class Executor {

    public static void main(String[] args) throws InterruptedException {

        //végrehajtó szolgáltatás, melynek segítégével megmondom, hogy az adott 'Pool'-ba hány szál fér bele.
        //szálak fogják végezni a feladatokat.
        ExecutorService executor = Executors.newFixedThreadPool(2);


        for (int i = 1; i <= 5; i++) {

            /*
            * ahelyett, hogy 5 alkalommal 5 szálat indítanánk, közben nekünk csak kettő szálra van szükség,
            * de az adott feladatot esetünkben ötször kell elvégezni, akkor előre lefixált szálmennyiséggel végeztetjük el
            * a feladatunkat.
            * Gyakorlatilag újrahasználjuk a szálakat, ha valamelyikőjük már szabad lett.
            * */
            executor.submit( new TaskUnit(i));
        }

        //miután kiosztottuk az összes feladatot az execute()-ot leállítjuk!
        executor.shutdown();

        System.out.println("Erre a pointra minden munka ki lett osztva!");
        executor.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Kész van az összes munka!");

    }
}
