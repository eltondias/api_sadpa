package org.sadpa.dto;

 
import org.sadpa.models.Estado;
import org.sadpa.models.Regiao;
import java.util.List;

public class RegionalizacaoCreateDto
{

   private Integer idRegionalizacao;
   private String nome;
   
    
   private Estado estado;
   
   private List<Regiao> regiao;



}
