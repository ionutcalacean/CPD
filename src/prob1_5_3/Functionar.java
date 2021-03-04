package prob1_5_3;


import java.util.Random;

public class Functionar extends Thread{

    public int id;
    public Printer printer;

    public Functionar(int i, Printer printer) {
        this.id=i;
        this.printer=printer;
    }

    public void run()
    {
        int counter = 0;

        while(true){
            counter++;
            System.out.println("in run for "+ counter+ "time");
            this.checkPrinter();

        }
    }

    public synchronized void checkPrinter(){


        Random rand = new Random();
        Integer time=Math.abs(rand.nextInt())%1000+3000;

        printer.print(id ,time);

    }


}
