import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class BANetwork {
    // all the files..
    File nodesFile = new File("Data/data_BANet_nodes.txt");
    File file = new File("Data/data_BANet.txt");
    // all the store vector
    Vector<Integer> node_A = new Vector<>();
    Vector<Integer> node_B = new Vector<>();
    Vector<Integer> degree = new Vector<>();
    Vector<Integer> degreeAverage = new Vector<>();
    // local init and netsize
    int initNetsize = 5; // initial net size
    int netsize = 1000000; // total netsize;
    int clonedhelpSize = (factorial(initNetsize) / (factorial(2)*factorial(initNetsize-2)))+netsize;

    // factorial
    private int factorial(int n){
        int result = 1;
        while (n >= 1){
            result *= n--;
        }
        return result;
    }

    // genarating nodes from initial value
    public void initNodeGenarate(){
        for (int i = 0; i < initNetsize; i++){
            for (int j = i+1; j < initNetsize; j++){
                node_A.add(i);
                node_B.add(j);
            }
        }
//        for (int i = 0; i < node_A.size();i++){
//            System.out.println(node_A.elementAt(i)+ " "+ node_B.elementAt(i));
//        }
        afterNodeGenarate();
    }

    // generating nodes after initial
    private void afterNodeGenarate(){
        Random random = new Random();
        for (int i = 0; i < netsize; i++){
            node_A.add(initNetsize+i);
//            System.out.println(node_A.lastElement());
            node_B.add(random.nextInt(node_A.lastElement()-1));
//            node_B.add(random.nextInt(node_A.lastElement()-1));
        }
//        for (int i = 0; i < node_A.size();i++){
//            System.out.println(node_A.elementAt(i)+ " "+ node_B.elementAt(i));
//        }
    }

    /******************************************************************/
    // adding degree
    private int adding(int n){
        return degree.set(n, degree.elementAt(n)+1);
    }
    // calling for adding degree
    public void addDegree(){
        for (int i = 0; i < node_A.size();i++){
            degree.add(0);
        }
        for (int i = 0; i < node_A.size(); i++){
            adding(node_B.elementAt(i));
        }
        for (int i = 0; i < node_A.size(); i++){
            adding(node_A.elementAt(i));
        }
    }


    /************************************************************/

    // adding degree average
    private int addDegreeAverage(int n){
        return degreeAverage.set(n, degreeAverage.elementAt(n)+1);
    }
     // calling for degree average
    public void degreeAverage(){
        for (int i = 0; i < degree.size(); i++){
            degreeAverage.add(0);
        }
        for (int i = 0; i < degree.size(); i++){
            addDegreeAverage(degree.elementAt(i));
        }
    }

    /**********************************************************************/
    // writing data into a file.
    public void data() throws IOException {
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile()); // this one contain degree average data
        FileWriter fileWriter1 = new FileWriter(nodesFile.getAbsoluteFile()); // this one contain nodes
        for (int i = 0; i < node_A.size(); i++){
            fileWriter1.write(node_B.elementAt(i)+ "\t"+ node_A.elementAt(i) + "\n");
        }
        for (int i = 1; i < degreeAverage.size(); i++){
            fileWriter.write(i+ "\t" + degreeAverage.elementAt(i) + "\n");
        }
        fileWriter1.close();
        fileWriter.close();
    }

    // this will view whatever needed.
    public void view(){
        for (int i =0; i < degree.size(); i++){
            System.out.println(i + " "+degree.elementAt(i));
        }
        System.out.println("------------------------------------");
        for (int i = 1; i < degreeAverage.size();i++){
            System.out.println(i + " " + degreeAverage.elementAt(i));
        }
    }
}
