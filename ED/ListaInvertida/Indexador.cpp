/*
 * Indexador.cpp
 *
 *  Created on: Jun 26, 2010
 *      Author: pedropaulo
 */

#include "Indexador.h"
#include <sys/types.h>
#include <dirent.h>
#include <tr1/regex>
#include <string>


Indexador::Indexador() {
}

Indexador::~Indexador() {
}

void Indexador::gerarArquivoDados(std::string diretorioBase,
		std::string arquivoDados) {

}

std::string Indexador::codificarString(std::string string) {
	std::tr1::regex regex("\r\n");
	std::string subst = "\\r\\n";
	return std::tr1::regex_replace(string, regex, subst);
}

std::string Indexador::decodificarString(std::string string) {
	std::tr1::regex regex("\\r\\n");
	std::string subst = "\r\n";
	return std::tr1::regex_replace(string, regex, subst);
}

ListaEncadeada<std::string> Indexador::abrirDiretorio(
		std::string caminhoDiretorio) {
	DIR *diretorio;
	struct dirent *arquivoAtual;
	ListaEncadeada<std::string> *arquivos = new ListaEncadeada<std::string> ();

	diretorio = opendir(caminhoDiretorio.c_str());

	arquivoAtual = readdir(diretorio);
	while (arquivoAtual != NULL) {
		arquivos->adicionarNoInicio(new std::string(arquivoAtual->d_name));
		arquivoAtual = readdir(diretorio);
	}

	closedir(diretorio);
	return *arquivos;
}
