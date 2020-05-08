


//todo: this will be dynamic network.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

/** what it will do is make 2 node,and connect it.
 * after it will start making more node and connect it randomly with previews nodes.
 */
class Network4 {
    int[] node_A;
    int[] node_B;
    int[] degree;
    int num;
    int[] degree_ava;
    Random random;
    Vector<Integer> vectorDegree = new Vector<>();
    Vector<Integer> vectorDegreeAve = new Vector<>();

    /// files.
    File file = new File("Data/data_net_4.txt");
    File file_graph = new File("Data/data_net_4_G.txt");
    File file_graph2 = new File("Data/data_net_4_G_D.txt");


    // constructor
    public Network4(){
        node_A = new int[10];
        node_B = new int[node_A.length];
    }

    public Network4(int N){
        node_A = new int[N];
        node_B = new int[node_A.length];
    }

    /** THis will make random network access.
     * inside the loop goes to node_A length and make link along the way.
     * for plot to work i made left side random.not the right side. and that will be the node_A.
     * node_B is containing serial number from loop.
     * node_A is containing random number from loop.
     * and there is no repetition.
     */
    public void defult(){
        for (int i = 0; i < node_A.length; i++){
            vectorDegree.add(1); // setting all vector to one.cause "nodeB is already one node.
//            vectorDegreeAve.add(0); // setting all vector to zero.
        }
    }
    public void node_link_generator(){
        random = new Random();
        for (int i = 0; i < node_A.length; i++){
            node_B[i] = i+1;
            node_A[i] = random.nextInt(i+1);
            vectorDegree.add(1); // setting all vector to one.cause "nodeB is already one node.
            vectorDegreeAve.add(0); // setting all vector to zero.
            degreeDistributionV3(node_A[i]); // calling degreeDistributionV3
        }
//        for (int i = 0; i < node_A.length; i++){
//            System.out.println(node_B[i] +"<------->"+node_A[i]);
//        }
    }

    /** this will find the degree distribution data
     * todo: need to is simple.find the number and how many are they.and store that.
     * todo: needed improve. take too much time.
     * degreeDistributionV3 is the improve varsion.
     */
    // degreeDistributionV3
    public void degreeDistributionV3(int nodeA){
        vectorDegree.set(nodeA, vectorDegree.elementAt(nodeA)+1);
    }

    public void degreeDistributionV2(int index){
        for (int i = 0; i < index+1;i++){
            if (i == node_A[index]){
                vectorDegree.set(i, vectorDegree.elementAt(i)+1);
            }
        }
    }

    public void degree_distribution(){
        degree = new int[node_A.length];
        for (int i = 0; i < node_A.length;i++){
            for (int j = 0; j < node_A.length;j++){
                if (i == node_A[j]){
                    degree[i] += 1;
                }else if (i == node_B[j]){
                    degree[i] += 1;
                }
            }
        }
//        Arrays.sort(degree);
        for (int i = 0; i < degree.length; i++){
            System.out.println(i +" "+degree[i]);
        }
//        System.out.println("--------------------");
    }


    /** this will find all the number of same element.
     * and convert into single number. like " number 1 is about there is 100"
     * this put that there is 1 = 100.
     * todo: needed improve.it's take too much time.
     */
    /*************************************************************************************************************/
    public int degreeDistributionAverageV2(int nodeA){ /*****************************************************/
        return vectorDegreeAve.set(nodeA, vectorDegreeAve.elementAt(nodeA)+1); // returning vector degree average
    }
    // degree average getting done..
    public void degreeDistributionAverageDone(){
//        System.out.println("degreeDistributionAverage");
        for (int i = 0; i < vectorDegree.size();i++){
//            vectorDegreeAve.add(0);
            degreeDistributionAverageV2(vectorDegree.elementAt(i)); // calling degreeDistributionAverageV2
        }
//        for (int i = 1; i < vectorDegreeAve.size();i++){
//            if (vectorDegreeAve.elementAt(i) == 0){
//                System.out.println("ye");
//                vectorDegreeAve.remove(i);
//            }
//        }
//        vectorDegreeAve.trimToSize();
//        for (int i = 0; i < vectorDegreeAve.size(); i++){
//            System.out.println(vectorDegreeAve.elementAt(i));
//        };
//        System.out.println(vectorDegreeAve);
    }
    /***********************************************************************************************/

    public void degree_distribution_average(){
        degree_ava = new int[degree[degree.length-1]];

        for (int i = 0; i < degree_ava.length; i++){
            for (int j = 0; j < degree.length;j++){
                if (i+1 == degree[j]){
                    degree_ava[i] += 1;
                }
            }
        }

        for (int i = 0; i < degree_ava.length;i++){
            System.out.println(degree_ava[i]+ " lenthe "+degree_ava.length);
        }
    }


    /** this will write data on file.
     * for network plot.
     * and degree distribution.
     */

    public void data() throws IOException {
        System.out.println("writing data");
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        FileWriter fileWriter2 = new FileWriter(file_graph.getAbsoluteFile());
        FileWriter fileWriter3 = new FileWriter(file_graph2.getAbsoluteFile());
        for (int i = 0; i < node_A.length; i++){
            fileWriter.write(node_A[i] +"\t"+ node_B[i]+"\n");
        }
//        for (int i = 0; i < degree.length; i++){
//            fileWriter2.write(i + "\t" + degree[i] +"\n");
//        }
//        for (int i = 0; i < degree_ava.length; i++){
//            fileWriter3.write(i + "\t" + degree_ava[i] +"\n");
//        }
        fileWriter.close();
//        fileWriter2.close();
//        fileWriter3.close();
    }

    /**
     * Viewing function
     */
    // this will view vector
    public void view(){
//        System.out.println("viewing");
//        for (int i = 0; i < vector.size(); i++){
//            System.out.println(i +" "+ vector.elementAt(i));
//        }
        System.out.println(vectorDegree);
        System.out.println(vectorDegreeAve);
    }

    public void alldone() {
        System.out.println("vec "+vectorDegreeAve);
        Object average = (Vector)vectorDegreeAve.clone();
        System.out.println("av "+ average);

    }
}
