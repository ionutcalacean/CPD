package prob1_5_3;

import java.util.ArrayList;

public class PrinterCoordinator {


    public static void execute(){

        Printer printer= new Printer();
        ArrayList<Functionar> list= new ArrayList<Functionar>();
        for(int i=0; i<8; i++)
        {
            Functionar f = new Functionar(i,printer);
            list.add(f);
            f.start();
        }
    }
}
