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
        degree.push_back(1); // this is node_B adding on vector.
        degree_ava.push_back(0);
        degreeDistriburionv2(node_A[i]); // calling degreedistributionv2.
    }

//    for (int k = 0; k < node_A.size(); ++k) {
//        std::cout<< node_B[k] << " " << node_A[k] << std::endl;
//    }
}


/** this will find the degree distribution data
     * todo: need to is simple.find the number and how many are they.and store that.
     * todo: needed improve. take too much time.
     */

// this is the improved varsion of degreedistribution.
void Network::degreeDistriburionv2(int nodeA) {
    degree[nodeA] = degree[nodeA]+1; // putting input random value on index of random value on vector.
}
// this is old one.take's long time to complete..
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
/************************************************************************/
int & Network::degreeDistributionAveragev3(int nodeA) {
    return degree_ava[nodeA] += 1;
}

void Network::degreeDistributionAveragedone() {
    std::cout<<"degreeDistributionAveragedone for degree"<< std::endl;
    for (int i = 0; i < degree.size(); ++i) {
//        degree_ava.push_back(0);
//        degreeDistributionAveragev2(degree[i]);
        degreeDistributionAveragev3(degree[i]);
//        std::cout<< degree[i] << std::endl;
    }

//    for (int j = 1; j < degree_ava.size(); ++j) {
//        std::cout<< degree_ava[j] << std::endl;
//    }
}

/******************************************************************************/
// this one take long time..
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
    for (int i = 0; i < degree_ava.size();i++){
        std::cout << degree_ava[i] << " " << i << std::endl;
    }
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
    for (int i = 1; i < size; ++i) { // started from 1. can be changed to 0
        generated_data << node_B[i] << "\t" << node_A[i] << std::endl; // genarated node data.
        degree_distribution << i << "\t" << degree[i] << std::endl; // degree distribution
        average << i << " " << degree_ava[i] << std::endl; // degree average
    }
    generated_data.close();
    degree_distribution.close();
    average.close();
}

void Network::view() {
    std::cout<< "viewing" << std::endl;
    for (int i = 0; i < degree.size(); ++i) {
        std::cout<< i << " " << degree[i] << std::endl;
    }
}







