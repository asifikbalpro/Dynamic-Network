import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class Run{
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

    public void net_4() throws IOException {
        long start = System.currentTimeMillis();

        Network4 network4 = new Network4(5);
        network4.node_link_generator();
//        network4.degree_distribution();
//        network4.degree_distribution_average();
//        network4.data();
        network4.view();
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
}