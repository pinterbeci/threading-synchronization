package mainPackage;

public class Main {

    public static void main(String[] args) {

        System.out.println("henóóóóóó");
        Bat denever = new Bat();
        process(denever);
    }
    /*
        olyan objektumot kér a 'process', aki 100%-osan fogja tudni a 'Fly' metódusait
    */
    public static void process(Fly currentAnimal){

        currentAnimal.ascend();

    }
}
