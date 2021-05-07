package inOutErrPackage;

import java.io.IOException;

public class InAndOut {

    public static void main(String[] args) {
        System.out.println("ebben az esetben kifelé megy az adat!");

        int something = 0;
        //bejön adat!
        try {
            System.out.println("Adjon meg egy beolvasandó elemet!");
            something = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("kimegy adat = " + something);

        System.err.println("Baj van tesóóó!");

        Writer w = new Writer();
        //w.writeSingleCharacter();
        w.writeMultipleCharacter();

        Reader r = new Reader();
        //r.readSingleCharacter();
        r.readMiltipleCharacter();
    }
}
