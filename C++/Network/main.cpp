#include <iostream>
#include <vector>
#include <iomanip>
#include "src/Network.h"
#include "src/Analysis.h"


int main() {

    clock_t start, end; // clock
    std::cout << "Hello, World!" << std::endl;
    int network_size = 100000; // this is contain Network size
    int runTimeOfProgram = 10000;

    start = clock();

    // making object acceptable.
//    Network network1(network_size);



// this is the network section..
//    network1.NodeLinkGenerator();
//    network1.DegreeDistribution();
//    network1.DegreeDistributionAverage();
//    network1.degreeDistributionAveragedone();
//    network1.Data();
//    network1.view();


    /**************************************************************************************/
    /*** from here is the finalize section.. */
    /** the cloning prosses works */
    Network network(network_size);
    Analysis analysis(network_size);

    for (int i = 0; i < runTimeOfProgram; ++i) {
        std::cout << "loop = " << i << std::endl;
        network.NodeLinkGenerator();
        network.degreeDistributionAveragedone();
//        std::cout<< network.degree_ava.size() << std::endl;
        for (int j = 0; j < network.degree_ava.size(); ++j) {
            analysis.cloned.push_back(network.degree_ava[j]);
        }
//        std::cout << analysis.cloned.size() << std::endl;
        analysis.clone();
        analysis.cloned.clear();
        network.degree_ava.clear();
        network.node_A.clear();
        network.node_B.clear();
        network.degree.clear();

//        std::cout<< network.degree_ava.size() << std::endl;

    }

    analysis.getingAverage(runTimeOfProgram);
    analysis.Data();

//    network.Data();


    end = clock();
    double time_taken = double(end - start) / double(CLOCKS_PER_SEC);
    std::cout << "Time taken by program is : " << std::fixed << time_taken << std::setprecision(5) << "sec";

    return 0;
}