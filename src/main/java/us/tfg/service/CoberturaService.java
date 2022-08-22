package us.tfg.service;

import java.util.List;

import us.tfg.model.Cobertura;

public interface CoberturaService {

    public void save(Cobertura cobertura);
    
    public List<Cobertura> findByOperadora(String operadora);
    
    public List<Cobertura> findAll();

}
