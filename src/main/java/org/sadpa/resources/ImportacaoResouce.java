package org.sadpa.resources;

import javax.validation.Valid;
import org.sadpa.dto.ImportacaoCreateDto;
import org.sadpa.services.ImportacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/importacao")
@Api(description = "Importação de dados")
public class ImportacaoResouce {

	
	@Autowired
	private ImportacaoService importacaoService;
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Importar dados para uma camada")
	@PostMapping()
	public @ResponseBody ImportacaoCreateDto importar(@RequestBody @Valid ImportacaoCreateDto importacaoCreateDto) throws Exception{								
		
		importacaoService.importar(importacaoCreateDto);
		
		return importacaoCreateDto;
	}
	
}
