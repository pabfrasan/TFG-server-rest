package us.tfg.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import us.tfg.model.Cobertura;
import us.tfg.service.CoberturaService;

@RestController
@RequestMapping("/cobertura")
public class CoberturaRestController {
	
	@Autowired
	CoberturaService coberturaService;
	
    @GetMapping("/{datosCobertura}")
    public void findAll(@PathVariable String datosCobertura){
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
	
    private LocalDateTime formatearFecha(String UtcDateTime) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .toFormatter();

        return LocalDateTime.parse(UtcDateTime, formatter);
    }
}
