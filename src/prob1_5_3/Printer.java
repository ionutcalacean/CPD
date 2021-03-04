package prob1_5_3;

public class Printer extends Thread {

    private boolean isFree;

    public Printer(){
        this.isFree=true;
    }

    public boolean isFree(){
        return this.isFree;
    }

    public void setOccupied(){
        this.isFree=false;
    }

    public void setFree(){
        this.isFree=true;
    }

    public synchronized void print(int functionarNr,Integer time){

        while(!this.isFree()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.setOccupied();

        try {
            this.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Functionar "+functionarNr+" printed for: "+time);
        this.setFree();
        notify();




    }
}
