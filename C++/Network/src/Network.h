//
// Created by Asif on 12/23/2019.
//

#ifndef NETWORK_NETWORK_H
#define NETWORK_NETWORK_H

//todo: this will be dynamic Network.


#include <iostream>
#include <array>
#include <vector>
#include <fstream>
#include "Network.h"

/** what it will do is make 2 node,and connect it.
 * after it will start making more node and connect it randomly with previews nodes.
 */
class Network {
public:
    std::vector<int>node_A;
    std::vector<int>node_B;
    std::vector<int>degree;
    int size;

    std::ofstream generated_data;
    std::ofstream degree_distribution;
    std::ofstream average;




    Network(){
        size = 10;
    }

    Network(int N){
        size = N;
    }
    void NodeLinkGenerator();
    void DegreeDistribution();
    void DegreeDistributionAverage();

    void Data();
    void view();

    //v2
    void degreeDistriburionv2(int nodeA);
    void degreeDistributionAveragev2(int nodeA);
    int & degreeDistributionAveragev3(int nodeA);
    void degreeDistributionAveragedone();

    std::vector<int> degree_ava;
};


#endif //NETWORK_NETWORK_H
