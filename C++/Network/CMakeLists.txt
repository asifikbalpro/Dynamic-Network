cmake_minimum_required(VERSION 3.7)
project(Network)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp
        src/Network.cpp
        src/Network.h src/Analysis.cpp src/Analysis.h)
add_executable(Network ${SOURCE_FILES})