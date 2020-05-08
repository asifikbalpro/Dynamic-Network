import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] argc) throws IOException {
        System.out.println("welcome");

        // dynamic network..
//        Run run = new Run();

//        run.net_1();
//        run.net_2();
//        run.net_3();
//        run.net_4(10,10);
//        run.net_5();

//        DataWrite dataWrite = new DataWrite(1000000, 1000);
        /********************************************************************/

        // BA_network
        long start = System.currentTimeMillis();

//        BANetwork baNetwork = new BANetwork();
//        baNetwork.initNodeGenarate();
//        baNetwork.addDegree();
//        baNetwork.degreeAverage();
//        baNetwork.view();
//        baNetwork.data();

        BA_DataWrite ba_dataWrite = new BA_DataWrite();
        ba_dataWrite.BA_network(1000);



        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
}
