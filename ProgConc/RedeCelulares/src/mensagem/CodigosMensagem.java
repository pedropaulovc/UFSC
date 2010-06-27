package mensagem;


public enum CodigosMensagem {
	//Códigos para comunicação entre estações base e servidor central
	BUSCAR_ESTACAO, ADICIONAR_CELULAR, REMOVER_CELULAR, CELULAR_LOCALIZADO,
	
	//Códigos para comunicação entre estações base e celulares
	ASSOCIAR_CELULAR, DESASSOCIAR_CELULAR, REQUISITAR_LIGACAO, RECEBER_LIGACAO, TERMINAR_LIGACAO,
	RESPOSTA_CELULAR, ESTACAO_RESPONDE_CELULAR,
	
	//Códigos para comunicação entre estações base
	RESPOSTA_ESTACAO

}
