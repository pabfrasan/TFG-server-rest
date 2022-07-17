package us.tfg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.tfg.model.Cobertura;
import us.tfg.model.CoberturaDAO;

@Service
public class CoberturaServiceImpl implements CoberturaService {

    @Autowired
    private CoberturaDAO coberturaDAO;

	@Override
	public void save(Cobertura cobertura) {
		coberturaDAO.save(cobertura);
	}

}
