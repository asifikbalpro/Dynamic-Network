//
// Created by Asif on 5/4/2020.
//


#include "Analysis.h"

void Analysis::clone() {
//    std::cout << "Cloning vector" << std::endl;
    for (int i = 0; i < cloned.size(); ++i) {
//        std::cout<<cloned[i] << std::endl;
        cloneFinal[i] += cloned[i];
    }

//    for (int i = 0; i < cloneFinal.size(); ++i) {
//        std::cout<< "cloned vector " <<cloneFinal[i] << std::endl;
//    }

}

void Analysis::getingAverage(int times) {
    for (int i = 0; i < cloneFinal.size(); ++i) {
        cloneFinal[i] /= times;
//        std::cout<< "final value " << cloneFinal[i]<< std::endl;
    }
}

void Analysis::Data() {
    std::cout << "writing average data" << std::endl;
    averageData.open("Degree final Average.txt");
    for (int i = 0; i < 100; ++i) {
        averageData << i << " " << cloneFinal[i] << std::endl;
    }
    averageData.close();
}

