package mensagem;


public enum CodigosMensagem {
	//Códigos para comunicação entre estações base e servidor central
	BUSCAR_ESTACAO, ADICIONAR_CELULAR, REMOVER_CELULAR, CELULAR_LOCALIZADO,
	
	//Códigos para comunicação entre estações base e celulares
	ASSOCIAR_CELULAR, DESASSOCIAR_CELULAR, REQUISITAR_LIGACAO, RECEBER_LIGACAO, RECEBER_TERMINO_LIGACAO,
	RESPOSTA_CELULAR, ESTACAO_RESPONDE_CELULAR, ENVIAR_TERMINO_LIGACAO,
	
	//Códigos para comunicação entre estações base
	RESPOSTA_ESTACAO,
	
	//Códigos de manutenção
	TIME_OUT

}
