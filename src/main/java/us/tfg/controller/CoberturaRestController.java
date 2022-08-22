package us.tfg.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import us.tfg.model.Cobertura;
import us.tfg.service.CoberturaService;

@RestController
@RequestMapping("/")
public class CoberturaRestController {
	
	@Autowired
	CoberturaService coberturaService;
	
    @GetMapping("save/{datosCobertura}")
    public void gaurdar(@PathVariable String datosCobertura){
        String[] listaValores = datosCobertura.split("&");
        
        Cobertura c = new Cobertura();
        c.setDbm(listaValores[0]);
        c.setCoordenadas(listaValores[1]);
        c.setFecha(formatearFecha(listaValores[2]));
        c.setTipoFrecuencia(listaValores[3]);
        c.setOperadora(listaValores[4]);
        c.setFabricante(listaValores[5]);
        c.setModelo(listaValores[6]);
        c.setAndroidVersion(listaValores[7]);
        c.setSdkVersion(listaValores[8]);
        
        coberturaService.save(c);
    }
    
    @GetMapping("findByOperadora/{operadora}")
    public List<Cobertura> findByOperadora(@PathVariable String operadora){
        return coberturaService.findByOperadora(operadora);     
    }
    
    @GetMapping("findAll")
    public List<Cobertura> findAll(){
        return coberturaService.findAll();  
    }
    @GetMapping("findAllOperadoras")
    public List<String> findAllOperadoras(){
        return coberturaService.findAll()
        		.stream()
        		.map(x->x.getOperadora())
        		.distinct()
        		.collect(Collectors.toList());     
    }
	
    private LocalDateTime formatearFecha(String UtcDateTime) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .toFormatter();

        return LocalDateTime.parse(UtcDateTime, formatter);
    }
}
