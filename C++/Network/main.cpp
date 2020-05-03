#include <iostream>
#include <vector>
#include <iomanip>
#include "src/Network.h"


int main() {

    clock_t start, end; // clock
    std::cout << "Hello, World!" << std::endl;
    int network_size = 100; // this is contain Network size

    start = clock();

    Network network1(network_size);
    network1.NodeLinkGenerator();
    network1.DegreeDistribution();
    network1.DegreeDistributionAverage();
//    network1.degreeDistributionAveragedone();
    network1.Data();
//    network1.view();

    end = clock();


    double time_taken = double(end - start) / double(CLOCKS_PER_SEC);
    std::cout << "Time taken by program is : " << std::fixed << time_taken << std::setprecision(5) << "sec";

    return 0;
}