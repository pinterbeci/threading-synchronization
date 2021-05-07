package inOutErrPackage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Writer {

    public void writeSingleCharacter(){

        try {
            FileOutputStream fOS = new FileOutputStream("E:\\Portfolio\\Java\\test.txt");
            fOS.write(65);
            //kiflusholás, kiürítés
            fOS.flush();
            fOS.close();
            System.out.println("Készen vagyok!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void writeMultipleCharacter(){

        try {
            FileOutputStream fOutS = new FileOutputStream("E:\\Portfolio\\Java\\test.txt");
            String text = "váribóóóón gyöööttem mááán!";
            byte a[] = text.getBytes();


            fOutS.write(a);
            //kiflusholás, kiürítés
            fOutS.flush();
            fOutS.close();
            System.out.println("Készen vagyok!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
