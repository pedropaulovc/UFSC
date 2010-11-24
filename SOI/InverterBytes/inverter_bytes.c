#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(int argc, char **argv){
	if(argc < 3){
		puts("Uso: inverter_bytes entrada saida [tam_bloco (bytes)]");
		return -1;
	}
	
	char *entrada = argv[1];
	char *saida = argv[2];
	int tam_bloco = 512;
	if (argc == 4 && atoi(argv[3]) > 0)
		tam_bloco = atoi(argv[3]);

	char *buffer = (char *) malloc(tam_bloco * sizeof(char));
	if(buffer == NULL){
		puts("Não foi possível alocar um buffer do tamanho requisitado");
		return -1;
	}

	FILE *fd_entrada = fopen(entrada, "r");
	FILE *fd_saida = fopen(saida, "w");
	
	if(fd_entrada == NULL) {
		puts("Arquivo de entrada inválido");
		return -1;
	}
	
	if(fd_saida == NULL) {
		puts("Arquivo de saída inválido");
		return -1;
	}
	
	static struct stat stat_entrada;
	stat(entrada, &stat_entrada);
	int tam_entrada = stat_entrada.st_size;
	
	int pos;
	/* Iterando o arquivo de entrada, lendo um bloco por vez, de trás para frente */
	for (pos = 0; pos < tam_entrada; pos += tam_bloco ) {
		size_t bytes_a_ler = tam_bloco;
		int j;
 
		if (pos + tam_bloco > tam_entrada) {
			bytes_a_ler += tam_entrada - tam_bloco - pos;
		}
		
		fseek(fd_entrada, tam_entrada - bytes_a_ler - pos, SEEK_SET);
		int bytes_lidos = fread(buffer, 1, bytes_a_ler, fd_entrada);
		
		/* Invertendo os bytes do buffer */
		for(j = 0; j < bytes_lidos/2; j++) {
			char t;
			t = buffer[bytes_lidos-1-j];
			buffer[bytes_lidos-1-j] = buffer[j];
			buffer[j] = t;
		}
		
		/* Gravando os bytes revertidos no arquivo de saída */
		fwrite(buffer, 1, bytes_lidos, fd_saida);
	}

	fclose(fd_entrada);
	fclose(fd_saida);
	
	return 0;
}
