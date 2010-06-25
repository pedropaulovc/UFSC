package mensagem;


public enum CodigosMensagem {
	//Codigos para comunicação entre estações base e servidor central
	BUSCAR_ESTACAO, ADICIONAR_CELULAR, REMOVER_CELULAR, CELULAR_CADASTRADO, 
	
	//Codigos para comunicacao entre estações base e celulares
	ASSOCIAR_CELULAR, DESASSOCIAR_CELULAR, FAZER_LIGACAO, RECEBER_LIGACAO, TERMINAR_LIGACAO
	

}
