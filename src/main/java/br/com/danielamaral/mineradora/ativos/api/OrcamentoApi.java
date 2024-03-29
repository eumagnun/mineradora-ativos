package br.com.danielamaral.mineradora.ativos.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielamaral.mineradora.ativos.bussiness.OrcamentoBussiness;
import br.com.danielamaral.mineradora.ativos.dto.OrcamentoDto;
import br.com.danielamaral.mineradora.ativos.model.Orcamento;
import br.com.danielamaral.mineradora.ativos.model.Situacao;
import br.com.danielamaral.mineradora.ativos.repository.OrcamentoRepository;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/orcamento")
public class OrcamentoApi {

	@Autowired
	OrcamentoBussiness bussiness;
	
	@Autowired
	OrcamentoRepository repository;
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Submeter Orçamento")
	@PostMapping(consumes = "application/json",path = "/submeter")
	public void submeterOrcamento(@RequestBody OrcamentoDto orcamento) {
		bussiness.submeterOrcamento(Orcamento.parseModel(orcamento));
	}
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Avaliar Orçamento" )
	@PostMapping(consumes = "application/json", produces = "application/json",path = "/avaliar/{id}")
	public ResponseEntity<OrcamentoDto> avaliarOrcamento(@PathVariable Long id, @RequestBody Situacao situacao, @RequestHeader("Authorization") String token) {
		if(token ==null || token.length()==0) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new OrcamentoDto());
		}
		
		return ResponseEntity.ok().body(OrcamentoDto.parseDto(bussiness.avaliarOrcamento(id, situacao,token)));
	}
	
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Pesquisar Orçamento")
	@GetMapping(produces = "application/json")
	public List<OrcamentoDto> pesquisaOrcamento() {
		List<OrcamentoDto> list = new ArrayList<>();
		repository.findAll().forEach(p -> list.add(OrcamentoDto.parseDto(p)));
		
		return list;
	}
}
