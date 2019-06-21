/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;

import com.gts.equipos.modelo.CotizacionDetalle;
import com.gts.equipos.service.CotizacionDetalleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laszlo
 */
@RestController
@RequestMapping("/rest/v1/")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class CotizacionDetalleRest {
     @Autowired
     private CotizacionDetalleService service;
     
    @GetMapping ("/cotizacionDetalle/list")
    public List<CotizacionDetalle> findAll(){
        return service.findAll();
    }  
    
    @GetMapping ("/cotizacionDetalle/{id}" )
    public Optional<CotizacionDetalle> findById(@PathVariable("id") Integer id  ){
        return service.findCotizacionById(id);
    }   
    
    @RequestMapping (value="/cotizacionDetalle/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public CotizacionDetalle createCotizacionDetalle(@RequestBody CotizacionDetalle cotizacion  ){
        return service.createCotizacionDetalle(cotizacion);
    }    
}
