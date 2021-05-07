package syncPackage;

//anonim osztály

public class Synchronization {

    private static int count;

    public static void main(String[] args) throws InterruptedException {

        //mivel ez a metódus 'static', akkor csak olyan osztályváltozót tud elérni, ami szintén 'static'

        Synchronization sd = new Synchronization();
        sd.threadWork();
    }

    public synchronized void addToCount(){
        count++;
    }

    void threadWork() throws InterruptedException {
        //két szál

        //a két szál az erőforráshoz lehet, hogy egyszerre nyúl hozzá.
        //emiatt lehet nem kapjuk meg a kellő értéket.
        // a count++ ==> count = count + 1;
        //nem atomic-us, akkor is megtörténik, ha hibásan történik meg.
        //atomic-us feladatok, azok amelyek akkor történnek meg, ha nem hibásak.
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 12000; i++) {

                    //első lépés: kivesszük az értéket
                    //második: hozzáadunk egyet
                    //harmadik: elmentjük.

                    //DE, mivel két szál egyszerre veszi ki az értéket és egyszerre akarnak rajta módosítani
                    //szálak egymás mellett párhuzamosan futnak és nem várják be egymást.
                    //és emiatt ebben a példában nem kapjuk meg a 24000-t végeredménybe, mivel túl nagy számmal dolgozunk
                    //mert sokszor egyszerre változtatnak a számon és lényegében az a művelet nem növelte (esetünkben)
                    //ezért következő lépésben kikommentezzük
                   // count++; - t és egy függvényt adunk át, az értékmódosítással.

                    addToCount();

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 12000; i++) {
                    //count++;
                    addToCount();
                }
            }
        });

        t1.start();
        t2.start();

        //bevárom a t1 szál lefutását
        t1.join();
        //bevárom a t2 szál lefutását
        t2.join();
        System.out.println("Count értéke = " + count);
        //azért lesz count = 0, mivel három szál indul el
        //t1, t2, az 'sout'-t, és mivel 'sout' végez leghamrabb, így nem változik a 'count'.
    }
}
