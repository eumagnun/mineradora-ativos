package br.com.danielamaral.mineradora.ativos.bussiness;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.ativos.model.Orcamento;
import br.com.danielamaral.mineradora.ativos.model.Situacao;
import br.com.danielamaral.mineradora.ativos.model.Usuario;
import br.com.danielamaral.mineradora.ativos.repository.AtivoRepository;
import br.com.danielamaral.mineradora.ativos.repository.OrcamentoRepository;
import br.com.danielamaral.mineradora.ativos.repository.UsuarioRepository;
import br.com.danielamaral.mineradora.ativos.security.TokenService;

@Service
public class OrcamentoBussiness {

	@Autowired
	private OrcamentoRepository repository;

	@Autowired
	private AtivoRepository ativoRepository;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Orcamento avaliarOrcamento(Long id, Situacao situacao, String token) {
		Orcamento orcamento = repository.getOne(id);
		Long idUsuario = tokenService.getIdUsuario(token.substring(7, token.length()));
		Usuario u = usuarioRepository.findById(idUsuario);
		if (orcamento.getSituacaoOrcamento().equals(Situacao.pendente)) {
			orcamento.setSituacaoOrcamento(situacao);
			orcamento.setDataAvaliacao(new Date());
			orcamento.setNomeAvaliador(u.getNome());
			repository.save(orcamento);
			
			orcamento.getAtivo().setSituacao(orcamento.getSituacaoOrcamento());
			orcamento.getAtivo().setDataAquisicao(new Date());
			ativoRepository.save(orcamento.getAtivo());

		}

		return orcamento;

	}

	public void submeterOrcamento(Orcamento orcamento) {
		repository.save(orcamento);
	}

}
