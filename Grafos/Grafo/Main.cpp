/*
 * Main.cpp
 *
 *  Created on: Aug 26, 2010
 *      Author: pedropaulovc
 */

#include <string>
#include <cstring>
#include "Grafo.h"
using namespace std;

struct eqstr{
  bool operator()(const char* s1, const char* s2) const {
    return strcmp(s1,s2)==0;
  }
};


int main(int argc, char **argv){
	Grafo<const char*, eqstr> *grafo = new Grafo<const char*, eqstr>();
}
