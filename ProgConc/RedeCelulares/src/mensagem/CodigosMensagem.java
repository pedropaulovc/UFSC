package mensagem;


public enum CodigosMensagem {
	//Códigos para comunicação entre estações base e servidor central
	BUSCAR_ESTACAO, ADICIONAR_CELULAR, REMOVER_CELULAR, CELULAR_CADASTRADO, 
	
	//Códigos para comunicação entre estações base e celulares
	ASSOCIAR_CELULAR, DESASSOCIAR_CELULAR, FAZER_LIGACAO, RECEBER_LIGACAO, TERMINAR_LIGACAO, RESULTADO_LIGACAO

}
