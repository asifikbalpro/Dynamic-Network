import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

class Run{
    Vector<Integer>vec = new Vector<>();

    public void net_1() throws IOException {
        Network network = new Network();
        network.node_generate();
//        network.link_genarate();
        network.link_genarate_2();
        network.view_network();
//        network.find_network_link();
//        network.number_of_links();
//        network.number_of_links_2();
//        network.find_network_link();
//        network.sorting();
//        network.data();

    }

    public void net_2() throws IOException {
        Network_2 network2 = new Network_2(5000);
        network2.node_generate();
        network2.link_genarate();
        network2.view_network();
        network2.find_network_link();
        network2.data();
    }

    public void net_3() throws IOException {
        Network_3 network_3 = new Network_3(20);
        network_3.combination();
        network_3.nodeGenerate();
//        network_3.node_link();
//        network_3.node_link_2();
        network_3.node_link_3();
        network_3.view_network();
        network_3.data();
//        network_3.number_of_links();
//        network_3.number_of_links_2(50);
//        network_3.number_of_connected_node();

    }

    public void net_5() throws IOException {
        long start = System.currentTimeMillis();
        Network4 network4 = new Network4(100);

        network4.node_link_generator();
        network4.degree_distribution();
        network4.degree_distribution_average();
//        network4.degreeDistributionAverageDone();
        network4.data();
//        network4.view();

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    public void net_4(int netSize, int runtimes) throws IOException {
        long start = System.currentTimeMillis();
//        Network4 network4 = new Network4(10);

//        network4.node_link_generator();
//        network4.degree_distribution();
//        network4.degree_distribution_average();
//        network4.degreeDistributionAverageDone();
//        network4.data();
//        network4.view();
//        network4.alldone();

        /********************************************/

        for (int i = 0; i < netSize;i++){
            vec.add(0);
        }
        for (int i = 0; i < runtimes; i++){
            Network4 network41 = new Network4(netSize);
            network41.node_link_generator();
            network41.degreeDistributionAverageDone();
            Object O = network41.vectorDegreeAve.clone();
//            System.out.println("cloned "+ O);
            Vector V = (Vector) O;
//            System.out.println("vector made "+ V);
            for (int j = 0; j < V.size();j++){
                int num = (int) V.elementAt(j);
                vec.set(j, vec.elementAt(j)+num);
            }
//            System.out.println(vec);
            System.out.println("loops ended "+ i);
        }
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
//
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

}