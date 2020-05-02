import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class Network_2 {
    // never initialize outsize the constructor
    int[] node ;
    int[] link_A;
    int[] link_B;

    Random random ;
    Scanner scanner ;

    File file = new File("Data.txt");

    public Network_2(){
        // default constructor
        node = new int[10];
        link_A = new int[node.length*2];
        link_B = new int[link_A.length];

        random = new Random();
        scanner = new Scanner(System.in);
    }

    public Network_2(int N){
        random = new Random();
        scanner = new Scanner(System.in);
        // N is the network size
        if (N <= 0) {System.out.println("Network size cannot be zero");}
        else{
            node = new int[N];
            link_A = new int[node.length*2];
            link_B = new int[link_A.length];
        }
    }


    // this function generate network node..
    public void node_generate(){

        for (int i = 0; i < node.length; i++){
            node[i] = i;
//            node[i] = 1+random.nextInt(100); // why assign random number to a node?

        }
    }

    // this will make link with link A to B.
    public void link_genarate(){

        for (int i = 0; i < link_A.length; i++){
            int A = 1+node[random.nextInt(node.length)];
            int B = 1+node[random.nextInt(node.length)];
            link_A[i] = A;
            if (A != B){
                link_B[i] = B;
            }
            for (int j = 0; j < link_B.length;j++){
                if (B != 0){
                    continue;
                }
            }
        }
        // checking the whole netwrok? not efficient if you have to do it every time you run it. if you need it for debugging purposes then it's ok
//        for (int i = 0; i < link_A.length;i++){
//            int temp = link_A[i];
//            if (link_A[i] != link_B[i]){
//                continue;
//            }else if (temp == link_B[i]){
//                System.out.println("---");
//            }
//        }
    }

    // this function view the link with A and B
    public void view_network(){

        for (int i = 0; i < link_A.length; i++){
            System.out.println(i +" "+ "link: "+ link_A[i] +"<---->"+link_B[i]);
        }
    }

    // this will find the network link.
    public void find_network_link(){

        System.out.println("Number of value to find: ");
        int A = scanner.nextInt();
        System.out.println("You enterd: "+A);
        System.out.println("finding : ");


        for (int i = 0; i < link_A.length; i++){
            if (A == link_A[i]){
                System.out.println("found: "+link_A[i]+" linked to "+link_B[i]);
            }else if (A == link_B[i]){
                System.out.println("found: "+A+" linked to "+link_A[i]);
            }
        }
    }

    public void data() throws IOException {
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        for (int i = 0; i < link_A.length; i++){
            fileWriter.write(link_A[i] +"\t"+ link_B[i] +"\n");
        }
        fileWriter.close();
    }
}
