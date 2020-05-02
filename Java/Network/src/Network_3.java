import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.Random;
import java.util.Scanner;


// todo: this will be static network.

/** this will make input number of node.
 * and then it will connect each node entryway possible.
 */

class Network_3 {

    // element store
    int[] node;
    int[] node_A;
    int[] node_B;
    int[] store;
    int[] connected_node;
    int[] random_num;
    Scanner scanner; // input
    int combination_value;
    Random random = new Random();


    File file = new File("Data/Data.txt"); // file writer
    File file2 = new File("Data/Data.csv"); // file writer

    // constructor
    public Network_3(){
        node = new int[10];
        node_A = new int[combination()];
        node_B = new int[combination()];
    }

    public Network_3(int N){
        if (N <= 0) {
            System.out.println("Network cannot be Zero");
        }else {
            node = new int[N];
            node_A = new int[combination()];
            node_B = new int[combination()];
        }
    }

    // getting number of link as possible.
    // using formula to find the combination value.
    public int combination() {
        int a = node.length * (node.length - 1);
        int b = 2;
        combination_value = a / b;
//        System.out.println(combination_value);
        return combination_value;
    }

    // getting nodes.
    public void nodeGenerate(){
        for (int i = 0; i < node.length; i++){
            node[i] = i+1;
        }
    }

    // links old varsion
    // this way wont work..
    // TODO: 02-Oct-19 won't work.
    public void node_link() throws IOException {
        int[] A = new int[node_A.length];
        int[] B = new int[node_B.length];
        int numm = 0;
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());

        for (int i = 0; i < node.length; i++){
            for (int j = i+1; j < node.length; j++){
                A[numm] = j;
                B[i] = j+1;
//                A[i] = j;
                System.out.println(A[i] +" "+ B[i]);
                fileWriter.write(A[i] +"\t"+B[i] +"\n");
                numm++;
            }
        }
    }

    // generating link with node_A and node_B.
    // works.
    public void node_link_2(){
        int number = 0;
        for (int i = 0; i < node.length;i++){
            for(int j = i+1; j < node.length;j++){
                node_A[number] = i;
                node_B[number] = j;
                number++;
            }
        }
    }


    // generating link with node_A and node_B.
    // todo: make 50% link
    public void node_link_3(){
        int number = 0;
        for (int i = 0; i < node.length;i++){
            for(int j = i+1; j < node.length;j++){
//                node_A[number] = random.nextInt(node.length);
//                node_B[number] = random.nextInt(node.length);
                node_A[number] = i;
                node_B[number] = j;
                number++;
            }
        }
    }


    // getting node links everything.
    /** viewing node_A and node_B */
    public void view_network(){
        for (int i = 0; i < node_A.length; i++){
            System.out.println(i +" "+ "link: "+ node_A[i] +"<---->"+node_B[i]);
        }
        System.out.println("-----------------------");
    }

    // writing data for the plot.and network graph
    public void data() throws IOException {
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
//        FileWriter fileWriter2 = new FileWriter(file2.getAbsoluteFile());
        for (int i = 0; i < node_A.length; i++){
            fileWriter.write(node_A[i] +"\t"+ node_B[i] +"\n");
//            fileWriter2.write(node_A[i] +"\t"+ node_B[i] +"\n");
        }
        fileWriter.close();
//        fileWriter2.close();
    }

    //this will get input "node" and find that how many link that value have.
    // also this will show how many of them connect with which one.
    public void number_of_links(){
        int number_of_linked = 0;
        System.out.printf("Enter you number: ");
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < node_A.length; i++){
            if (node_A[i] == n){
                number_of_linked++;
            }else if (node_B[i] == n){
                number_of_linked++;
            }
        }
        System.out.println(n +" connect to "+ number_of_linked +" nodes \n");
        /***************************************************************************************/
        store = new int[number_of_linked];
        int A = 0;
        for (int i = 0; i < node_A.length; i++){
            if (node_A[i] == n) {
                store[A] = node_B[i];
                A++;
            }else if (node_B[i] == n){
                store[A] = node_A[i];
                A++;
            }
        }
        for (int i = 0; i < store.length; i++){
            System.out.println(n + " is connected to "+ store[i]);
        }
    }


    //this will get input "node" and find that how many link that value have.
    // also this will show how many of them connect with which one.
    public void number_of_links_2(int n){
        int number_of_linked = 0;
        for (int i = 0; i < node_A.length; i++){
            if (node_A[i] == n){
                number_of_linked++;
            }else if (node_B[i] == n){
                number_of_linked++;
            }
        }
        System.out.println(n +" connect to "+ number_of_linked +" nodes");
    }


    public void number_of_connected_node() {
        connected_node = new int[node.length];
        for (int i = 0; i < node.length-1; i++) {
            number_of_links_2(node[i]);
        }
    }
}
