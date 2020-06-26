package br.com.danielamaral.mineradora.ativos.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielamaral.mineradora.ativos.bussiness.AtivoBussiness;
import br.com.danielamaral.mineradora.ativos.dto.AtivoDto;
import br.com.danielamaral.mineradora.ativos.dto.ManutencaoDto;
import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Manutencao;
import br.com.danielamaral.mineradora.ativos.repository.AtivoRepository;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/ativo")
public class AtivoApi {

	@Autowired
	private AtivoRepository repository;
	
	@Autowired
	private AtivoBussiness ativoBussiness;


	@ApiOperation(value = "Pesquisar Ativos Disponiveis")
	@GetMapping(produces = "application/json")
	public List<AtivoDto> pesquisarAtivosDisponiveis() {
		List<AtivoDto> list = new ArrayList<>();
		
		ativoBussiness.listarAtivosAdquiridos().forEach(p -> list.add(AtivoDto.parseDto(p)));
		
		return list;
	}
	
	
	@ApiOperation(value = "Consultar Ativo por id")
	@GetMapping(value = "/{id}", produces = "application/json")
	public AtivoDto consultar(@PathVariable Long id) {
		return AtivoDto.parseDto(repository.findById(id).get());
	}

	@ApiOperation(value = "Atualizar Ativo")
	@PutMapping(consumes = "application/json")
	public AtivoDto atualizar(@RequestBody AtivoDto ativo) {
		AtivoDto ativoDto = AtivoDto.parseDto(repository.save(Ativo.parseModel(ativo)));
		return ativoDto;
	}
	
	@ApiOperation(value = "cadastrar manutenção")
	@PostMapping(value = "/{id}/manutencao", produces = "application/json")
	public ManutencaoDto cadastrarManutençao(@PathVariable Long id,@RequestBody ManutencaoDto manutencaoDto) {
		return ManutencaoDto.parseDto(ativoBussiness.cadastrarManutencaoAtivo(id, Manutencao.parseModel(manutencaoDto)));
	}
	
}
