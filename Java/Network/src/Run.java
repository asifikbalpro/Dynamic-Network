import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

class Run{
    Vector<Integer>vec = new Vector<>();



    public void net_3(){
        Network_3 network_3 = new Network_3();
//        network_3.node_link();
        network_3.nodeGenerate();
    }



    public void net_5() throws IOException {
        long start = System.currentTimeMillis();
        Network4 network4 = new Network4(100);

        network4.node_link_generator();
//        network4.degree_distribution();
//        network4.degree_distribution_average();
//        network4.degreeDistributionAverageDone();
        network4.data();
//        network4.view();

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    public void net_4(int netSize, int runtimes) throws IOException {
        long start = System.currentTimeMillis();
        Network4 network4 = new Network4(10);

        network4.node_link_generator();
//        network4.degree_distribution();
//        network4.degree_distribution_average();
//        network4.degreeDistributionAverageDone();
//        network4.data();
//        network4.view();
//        network4.alldone();

        /********************************************/

//        for (int i = 0; i < netSize;i++){
//            vec.add(0);
//        }
//        for (int i = 0; i < runtimes; i++){
//            Network4 network41 = new Network4(netSize);
//            network41.node_link_generator();
//            network41.degreeDistributionAverageDone();
//            Object O = network41.vectorDegreeAve.clone();
////            System.out.println("cloned "+ O);
//            Vector V = (Vector) O;
////            System.out.println("vector made "+ V);
//            for (int j = 0; j < V.size();j++){
//                int num = (int) V.elementAt(j);
//                vec.set(j, vec.elementAt(j)+num);
//            }
////            System.out.println(vec);
//            System.out.println("loops ended "+ i);
//        }
//        System.out.println(vec);


        /**********************************************************/

//        Vector b = (Vector)v;
//        System.out.println(" v "+ b);
//        for (int i = 0; i < b.size(); i++){
//            int num = (int) b.elementAt(i);
//            vec.set(i, num);
//
//            vec.set(i, num+num+num);
//            System.out.println(vec.elementAt(i));
//        }

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    /*** this is another section */

//    Vector<Integer>clonedDegreeAverage = new Vector<>();
//    BANetwork baNetwork = new BANetwork();
//
//    public void runing(){
//        baNetwork.initNodeGenarate();
//        baNetwork.addDegree();
//        baNetwork.degreeAverage();
//        Object o = baNetwork.degreeAverage.clone();
//        Vector v = (Vector) o;
//        for (int i = 0; i < v.size(); i++){
//            int num = (int) v.elementAt(i);
//            clonedDegreeAverage.set(i, clonedDegreeAverage.elementAt(i)+num);
//        }
//        baNetwork.node_A.clear();
//        baNetwork.node_B.clear();
//        baNetwork.degree.clear();
//        baNetwork.degreeAverage.clear();
//    }
//    public void BA_network(int times){
//        for (int i = 0; i < baNetwork.clonedhelpSize;i++){
//            clonedDegreeAverage.add(0);
//        }
//        for (int i = 0; i < times;i++){
//            runing();
//        }
//        for (int i = 1; i < clonedDegreeAverage.size(); i++){
//            clonedDegreeAverage.set(i, clonedDegreeAverage.elementAt(i)/times);
//
//            if (!clonedDegreeAverage.elementAt(i).equals(0))
//                System.out.println(i + " " + clonedDegreeAverage.elementAt(i));
//        }
//        BA_DataWrite ba_dataWrite = new BA_DataWrite();
//        ba_dataWrite.Finalizing = clonedDegreeAverage.clone();
//
//    }

}