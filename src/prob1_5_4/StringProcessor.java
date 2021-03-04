package prob1_5_4;

public class StringProcessor extends Thread {
    private int threadNr;
    private String processedString;
    private int pointer;

    public StringProcessor(int threadNr,String processedString, int pointer){
        this.threadNr = threadNr;
        this.processedString=processedString;
        this.pointer=pointer;
    }

    @Override
    public void run(){
        while(true){

            if(threadNr==1){
                    while(pointer < processedString.length()){
                        System.out.println("I am thread nr: "+ threadNr+ " printing:"+processedString.charAt(pointer));
                        pointer++;
                    }

            }
            else{
                while(pointer >= 0){
                    System.out.println("I am thread nr: "+ threadNr+ " printing:"+processedString.charAt(pointer));
                    pointer--;
                }
            }
            break;
        }
    }
}
