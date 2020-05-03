import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class DataWrite {

    Vector<Integer> averageData = new Vector<>();
    DataWrite() throws IOException {
        Run run = new Run();
        run.net_4(10,10);
        Object O = run.vec.clone();
//        System.out.println(O);
        averageData = (Vector) O;
//        System.out.println(averageData);
        data();
    }
    DataWrite(int netSize, int runTimes) throws IOException {
        Run run = new Run();
        run.net_4(netSize,runTimes);
        Object O = run.vec.clone();
//        System.out.println(O);
        averageData = (Vector) O;
//        System.out.println(averageData);
        System.out.println(averageData);
        for (int i = 0; i < averageData.size(); i++){
            averageData.set(i, averageData.elementAt(i)/runTimes);
        }
        for (int i = 0; i < averageData.size(); i++){
            if (averageData.elementAt(i).equals(0)){
                averageData.remove(i);
            }
        }

        System.out.println(averageData);
        data();
    }
    /// files.
    File file = new File("Data/data_net_4.txt");
    File file_graph = new File("Data/data_net_4_G.txt");
    File file_graph2 = new File("Data/data_net_4_G_D.txt");


    public void data() throws IOException {
        System.out.println("writing data");
//        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
//        FileWriter fileWriter2 = new FileWriter(file_graph.getAbsoluteFile());
        FileWriter fileWriter3 = new FileWriter(file_graph2.getAbsoluteFile());
//        for (int i = 0; i < node_A.length; i++){
//            fileWriter.write(node_A[i] +"\t"+ node_B[i]+"\n");
//        }
//        for (int i = 0; i < degree.length; i++){
//            fileWriter2.write(i + "\t" + degree[i] +"\n");
//        }
//        for (int i = 0; i < degree_ava.length; i++){
//            fileWriter3.write(i + "\t" + degree_ava[i] +"\n");
//        }
        for (int i = 1; i < averageData.size(); i++){ // started from 1.can be change
            fileWriter3.write(i + "\t" + averageData.get(i) +"\n");
//            if (averageData.elementAt(i).equals(0)){
//                continue;
//            }else {
//                fileWriter3.write(i + "\t" + averageData.get(i) +"\n");
//            }
        }
//        fileWriter.close();
//        fileWriter2.close();
        fileWriter3.close();
    }
}
