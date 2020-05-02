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
private:
    std::vector<int>node_A;
    std::vector<int>node_B;
    std::vector<int>degree;
    std::vector<int>degree_ava;
    int size;

    std::ofstream generated_data;
    std::ofstream degree_distribution;
    std::ofstream average;



public:
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


};


#endif //NETWORK_NETWORK_H
