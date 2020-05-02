//
// Created by Asif on 12/23/2019.
//
#include <iostream>
#include <random>
#include <fstream>
#include "Network.h"



/** THis will make random network access.
     * inside the loop goes to node_A length and make link along the way.
     * for plot to work i made left side random.not the right side. and that will be the node_A.
     * node_B is containing serial number from loop.
     * node_A is containing random number from loop.
     * and there is no repetition.
     */
void Network::NodeLinkGenerator() {
    srand(time(0));
    std::cout << "Entering Node Generator Function:\t" << std::endl;
    for (int i = 0; i < size; i++) {
        node_A.push_back(rand()%(i+1));
        node_B.push_back(i+1);
    }

//    for (int k = 0; k < N; ++k) {
//        std::cout<< node_B[k] << " " << node_A[k] << std::endl;
//    }
}


/** this will find the degree distribution data
     * todo: need to is simple.find the number and how many are they.and store that.
     * todo: needed improve. take too much time.
     */
void Network::DegreeDistribution() {
    std::cout << "Entering Degree Distribution Function:\t" << std::endl;
    degree.reserve(size);

    for (int k = 0; k < size; ++k) {
        degree.push_back(0);
    }
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            if (i == node_A[j]){
//                degree.push_back(0);
                degree[i] += 1;
            }else if (i == node_B[j]){
//                degree.push_back(1);
                degree[i] += 1;
            } else{
                continue;
            }
        }
    }
//    for (int k = 0; k < size; k++) {
//        std::cout << k << " " << degree[k] << std::endl;
//    }
}


/** this will find all the number of same element.
   * and convert into single number. like " number 1 is about there is 100"
   * this put that there is 1 = 100.
   * todo: needed improve.it's take too much time.
   */
void Network::DegreeDistributionAverage() {
    std::cout << "Entering Degree Distribution Average Function:\t" << std::endl;
//    degree_ava.reserve(size);
    for (int k = 0; k < size; ++k) {
        degree_ava.push_back(0);
    }
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            if (i+1 == degree[j]){
                degree_ava[i] += 1;
            }
        }
    }
    for (int l = 0; l < degree_ava.size(); ++l) {
        if (degree_ava[l] == 0){
            degree_ava.erase(degree_ava.begin()+l);
        } else continue;
    }
//    for (int i = 0; i < degree_ava.size();i++){
//        std::cout << degree_ava[i] << " " << i << std::endl;
//    }
}


/** this will write data on file.
   * for network plot.
   * and degree distribution.
   */
void Network::Data() {
    std::cout << "Entering Data Writing Function" << std::endl;
    generated_data.open("generated_data.txt");
    degree_distribution.open("degree_distribution.txt");
    average.open("degree_average.txt");
    for (int i = 0; i < size; ++i) {
        generated_data << node_B[i] << "\t" << node_A[i] << std::endl;
        degree_distribution << i << "\t" << degree[i] << std::endl;
        average << degree_ava[i] << std::endl;
    }
    generated_data.close();
    degree_distribution.close();
    average.close();
}





