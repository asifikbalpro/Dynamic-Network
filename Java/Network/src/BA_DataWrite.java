import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class BA_DataWrite {

    File file = new File("Data/data_BAnet_degreeAverage.txt");
    Vector<Integer>clonedDegreeAverage = new Vector<>();
    BANetwork baNetwork = new BANetwork();

    // this will run the program BA network
    public void runing(){
        baNetwork.initNodeGenarate();
        baNetwork.addDegree();
        baNetwork.degreeAverage();
        Object o = baNetwork.degreeAverage.clone(); // clone the degree average form BA network to an object
        Vector v = (Vector) o; // clone the object into a vector
        for (int i = 0; i < v.size(); i++){
            int num = (int) v.elementAt(i);
            clonedDegreeAverage.set(i, clonedDegreeAverage.elementAt(i)+num); // putting v on clonedDegree Average
        }
        //clearing for next run.
        baNetwork.node_A.clear();
        baNetwork.node_B.clear();
        baNetwork.degree.clear();
        baNetwork.degreeAverage.clear();
    }

    // control section
    public void BA_network(int times) throws IOException {
        System.out.println("begin BA Network");
        for (int i = 0; i < baNetwork.clonedhelpSize;i++){
            clonedDegreeAverage.add(0); // adding initial value
        }

        // calling multiple time for program to run
        for (int i = 0; i < times;i++){
            System.out.println("Program running : "+ i);
            runing();
        }

        // finalizing value
        for (int i = 1; i < clonedDegreeAverage.size(); i++){
            clonedDegreeAverage.set(i, clonedDegreeAverage.elementAt(i)/times);

//            if (!clonedDegreeAverage.elementAt(i).equals(0)) System.out.println(i + " " + clonedDegreeAverage.elementAt(i));
        }
        data_BA(); // calling to write data
    }

    // data writing function
    public void data_BA() throws IOException {
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        for (int i = 1; i < clonedDegreeAverage.size(); i++){
            if (!clonedDegreeAverage.elementAt(i).equals(0)){
                fileWriter.write(i + "\t" + clonedDegreeAverage.elementAt(i)+ "\n");
            }
        }

        fileWriter.close();
    }
}
