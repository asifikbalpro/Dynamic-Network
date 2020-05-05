//
// Created by Asif on 5/4/2020.
//

#ifndef NETWORK_ANALYSIS_H
#define NETWORK_ANALYSIS_H


#include <vector>
#include "Network.h"

/** Analyze the data.
 *  cloning vector into new vector
 *  make the final data...
 */
class Analysis {
private:
    std::vector<int> cloneFinal;

public:
    std::vector<int> cloned;
    std::ofstream averageData;

    Analysis(int N){
        for (int i = 0; i < N; ++i) {
            cloneFinal.push_back(0);
        }
    }

    void clone();
    void getingAverage(int times);
    void Data();



};


#endif //NETWORK_ANALYSIS_H
