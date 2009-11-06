package producao.videoteca;

import producao.videoteca.configuracao.TipoConfiguracaoVideoteca;
import producao.xteca.Xteca;

public class Videoteca extends Xteca implements TipoVideoteca {

	public Videoteca(TipoConfiguracaoVideoteca configuração) {
		super(configuração);
	}

}
