package inOutErrPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Reader {

    public void readSingleCharacter(){

        try {
            FileInputStream fIS = new FileInputStream("E:\\Portfolio\\Java\\test.txt");
            int numb = fIS.read();
            System.out.println(  (char) numb );
            fIS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readMiltipleCharacter(){

        try {
            FileInputStream fIS = new FileInputStream("E:\\Portfolio\\Java\\test.txt");
            int numb = 0;

            String result = "";
            //ez jelzi a fájl végét!
            while ( (numb = fIS.read()) != -1 ){
                result += (char) numb;
            }
            System.out.println(result);
            fIS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
