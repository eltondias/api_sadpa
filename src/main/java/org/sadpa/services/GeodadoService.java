package org.sadpa.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.sadpa.dto.DadosGeodadoDto;
import org.sadpa.dto.FiltroDados;
import org.sadpa.dto.GeoadadoMapDto;
import org.sadpa.dto.GeodadoReadDto;
import org.sadpa.dto.GeodadoUpdateDto;
import org.sadpa.dto.ValorCampoReadDto;
import org.sadpa.models.Geodado;
import org.sadpa.models.ValorCampo;
import org.sadpa.repositories.CamadaRepository;
import org.sadpa.repositories.GeodadoRepository;
import org.sadpa.repositories.ValorCampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeodadoService {

	@Autowired
	private CamadaRepository camadaRepository;

	@Autowired
	private GeodadoRepository geodadoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ValorCampoRepository valorCampoRepository;

	public GeodadoReadDto atualizar(GeodadoUpdateDto geodado) {

		Geodado geodadoAtual = geodadoRepository.findByIdGeodado(geodado.getIdGeodado());

		geodadoAtual.setLatitude(geodado.getLatitude());
		geodadoAtual.setLongitude(geodado.getLongitude());

		return modelMapper.map(geodadoRepository.save(geodadoAtual), GeodadoReadDto.class);
	}

	public Geodado obter(int idGeodado) {
		return geodadoRepository.findByIdGeodado(idGeodado);
	}

	public Iterable<GeodadoReadDto> obterPorCamada(int idCamada) {
		Iterable<Geodado> response = geodadoRepository.findByCamada(camadaRepository.findByIdCamada(idCamada));
		List<GeodadoReadDto> lista = new ArrayList<GeodadoReadDto>();
		for (Geodado geodado : response) {
			lista.add(modelMapper.map(geodado, GeodadoReadDto.class));
		}
		return lista;
	}

	/*
	 * public Iterable<GeoadadoMapDto> old_geodadoMap(FiltroDados filtroDados) {
	 * 
	 * List<GeoadadoMapDto> listGeoadadoMapDto = new ArrayList<GeoadadoMapDto>();
	 * 
	 * int indice = 0;
	 * 
	 * for (int idCamada : filtroDados.getCamadas()) {
	 * 
	 * Camada oCamada = camadaRepository.findByIdCamada(idCamada);
	 * 
	 * List<Geodado> listGeodados = geodadoRepository.findByCamada(oCamada);
	 * 
	 * Geodado geodado = listGeodados.get(indice);
	 * 
	 * Double x = Double.valueOf(geodado.getMunicipio().getLatitude()); Double y =
	 * Double.valueOf(geodado.getMunicipio().getLongitude()); Double yInicial = y;
	 * 
	 * if (geodado.getLatitude() == null || geodado.getLongitude() == null) {
	 * geodado.setLatitude(String.valueOf(x));
	 * geodado.setLongitude(String.valueOf(y)); }
	 * 
	 * indice++;
	 * 
	 * int nItens = listGeodados.size(); Double n = Math.sqrt(nItens); Double iCord
	 * = 0.0009; Double jCord = 0.0009;
	 * 
	 * for (int i = 1; i <= n; i++) {
	 * 
	 * x = (x > 0)? x + iCord: x - iCord;
	 * 
	 * for (int j = 1; j <= n; j++) {
	 * 
	 * y = (y > 0)? y + jCord: y - jCord;
	 * 
	 * geodado = listGeodados.get(indice);
	 * 
	 * if (geodado.getLatitude() == null || geodado.getLongitude() == null) {
	 * geodado.setLatitude(String.valueOf(x));
	 * geodado.setLongitude(String.valueOf(y)); }
	 * 
	 * GeoadadoMapDto oGeoadadoMapDto = modelMapper.map(geodado,
	 * GeoadadoMapDto.class); oGeoadadoMapDto.setCamada(modelMapper.map(oCamada,
	 * CamadaReadDto.class));; listGeoadadoMapDto.add(oGeoadadoMapDto);
	 * 
	 * System.out.println(indice + " => " + "(" + x + "," + y + ")");
	 * 
	 * 
	 * indice++; }
	 * 
	 * y = yInicial; }
	 * 
	 * 
	 * indice = 0;//zera quando termina os geodados da camada
	 * 
	 * }
	 * 
	 * return listGeoadadoMapDto;
	 * 
	 * }
	 */

	public Iterable<GeoadadoMapDto> geodadoMap(FiltroDados filtroDados) {

		List<GeoadadoMapDto> listGeoadadoMapDto = new ArrayList<GeoadadoMapDto>();

		int indice = 0;

		List<Geodado> listGeodados = geodadoRepository.geodadoMap(filtroDados.getCamadas(), filtroDados.getMunicipios(),
				filtroDados.getDataInicial(), filtroDados.getDataFinal());

		if (listGeodados.size() > 0) {

			Geodado geodado = listGeodados.get(indice);

			Double x = Double.valueOf(geodado.getMunicipio().getLatitude());
			Double y = Double.valueOf(geodado.getMunicipio().getLongitude());
			Double yInicial = y;

			int nItens = listGeodados.size();
			Double n = Math.ceil(Math.sqrt(nItens));

			Double iCord = 0.0009;
			Double jCord = 0.0009;

			for (int i = 1; i <= n; i++) {

				x = (x > 0) ? x + iCord : x - iCord;

				for (int j = 1; j <= n; j++) {

					if (indice < listGeodados.size()) {

						y = (y > 0) ? y + jCord : y - jCord;

						geodado = listGeodados.get(indice);

						if (geodado.getLatitude() == null || geodado.getLongitude() == null) {
							geodado.setLatitude(String.valueOf(x));
							geodado.setLongitude(String.valueOf(y));
						}
						GeoadadoMapDto oGeoadadoMapDto = modelMapper.map(geodado, GeoadadoMapDto.class);
						listGeoadadoMapDto.add(oGeoadadoMapDto);

						System.out.println(indice + " => " + "(" + x + "," + y + ")");

					} else
						break;

					indice++;
				}

				y = yInicial;
			}

		}

		return listGeoadadoMapDto;

	}
	
	
	public DadosGeodadoDto dadosGeodado(int idGeodado) throws Exception {

		DadosGeodadoDto oDadosGeodadoDto = new DadosGeodadoDto();
		Geodado geodado = geodadoRepository.findByIdGeodado(idGeodado);
		oDadosGeodadoDto.setGeodado(modelMapper.map(geodado, GeodadoReadDto.class));
		Iterable<ValorCampo> valores = valorCampoRepository.findByGeodado(geodado);

		for (ValorCampo valorCampo : valores)
			oDadosGeodadoDto.getValorCampos().add(modelMapper.map(valorCampo, ValorCampoReadDto.class));

		return oDadosGeodadoDto;
	}

}
