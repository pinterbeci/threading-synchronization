package lambda;

public class Western {

    //az új változat
    public String letsDoSomething(String input1, String input2, String input3, String whatIf) {

        if( whatIf.equals("true")){

            //do something
        }else if(whatIf.equals("false")){

            //do something
        }
        return input1 + input2 + input3;

    }

        //régi
    public String letsDoSomething(String input1, String input2, String input3){

        return letsDoSomething(input1, input2, input3, "");
    }
}