import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Network {

    int[] node = new int[5];
    int[] link_A = new int[node.length*2];
    int[] link_B = new int[link_A.length];
    int[] number_of_link = new int[node.length];
    int[] same_node = new int[node.length];

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    File file = new File("Data.txt");


    // this function generate network node..
    public void node_generate(){

        for (int i = 0; i < node.length; i++){
            node[i] = i+1;
//            node[i] = 1+random.nextInt(10);
        }
    }

    // this will make link with link A to B.
    public void link_genarate(){

        for (int i = 0; i < link_A.length; i++){
            int A = node[random.nextInt(node.length)];
            int B = node[random.nextInt(node.length)];
            link_A[i] = A;

            if (A == B){
                newlink(i);
//                continue;
            }else if (A != B && B != 0){
                link_B[i] = B;
            }
            if (B == 0){
                System.out.println(B+"is zero");
            }
        }
    }

    public void link_genarate_2(){
        for (int i = 0; i < link_A.length; i++){
            int A = node[random.nextInt(node.length)];
            int B = node[random.nextInt(node.length)];
            link_A[i] = A;
            if (A == B){
                newlink(i);
//                continue;
            }else if (A != B && B != 0){
                link_B[i] = B;
            }
            if (B == 0){
                System.out.println(B+"is zero");
            }
        }
    }

    private void newlink(int n) {
         int B = node[random.nextInt(node.length)];
         if (B == 0){
             System.out.println("B is zero");
         }else {
             link_B[n] = B;
         }
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

    public void number_of_links(){
        for (int i = 0; i < number_of_link.length; i++){
            for (int j = 0; j < link_A.length; j++) {
                if (node[i] == link_A[j]){
                    number_of_link[i] += 1; // this is forward trace.
                }else if (link_B[i] == link_A[j]){
//                    number_of_link[i] += 1; // this is for backward trace
                }
            }
        }

        for (int i = 0; i < number_of_link.length; i++){
            System.out.println(node[i] +" "+number_of_link[i]);
        }
    }

    public void number_of_links_2(){
        for (int i = 0; i < number_of_link.length; i++){
            for (int j = 0; j < link_A.length; j++) {
                if (node[i] == node[j]){
                    same_node[i] += 1;
                }
            }
        }

        for (int i = 0; i < number_of_link.length; i++){
            System.out.println(node[i] +" "+number_of_link[i]);
        }
    }


    public void sorting(){
        Arrays.sort(number_of_link);
        for (int i = 0; i < number_of_link.length; i++){
            System.out.println(number_of_link[i]);
        }
    }


    public void data() throws IOException {

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());

//        fileWriter.write("Node"+"\t"+"degree");
        for (int i = 0; i < node.length; i++){
            fileWriter.write(node[i] +"\t"+ number_of_link[i]+"\n");
        }
        fileWriter.close();
    }
}
