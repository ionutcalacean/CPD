package prob1_5_4;

public class StringsCoordinator {



    public static void execute(){

        String s = new String("Test 1 pentru string!");

        StringProcessor sp1 = new StringProcessor(1,s,0);
        StringProcessor sp2 = new StringProcessor(2,s, s.length()-1);

        sp1.start();
        sp2.start();

    }

}
