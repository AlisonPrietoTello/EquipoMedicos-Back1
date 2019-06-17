/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;

import com.gts.equipos.modelo.Terceros;
import com.gts.equipos.service.TercerosServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Xamir Mercado
 */
@RestController
@CrossOrigin(origins={"http://localhost:4200","*"})
public class TercerosRest {
    
    @Autowired
    private TercerosServices tercerosRepository;
    
    
    @RequestMapping (value="/rest/v1/terceros/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Terceros> findAll(){
        return tercerosRepository.findAllTerceros();
    }
    
    @RequestMapping (value="/rest/v1/terceros/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Terceros> findById(@PathVariable("id") Integer idTerceros  ){
        return tercerosRepository.findTercerosById(idTerceros);
    }
    
     @RequestMapping (value="/rest/v1/terceros/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Terceros creatTerceros(@RequestBody Terceros terceros  ){
        return tercerosRepository.createTerceros(terceros);
    }
    
    @RequestMapping (value="/rest/v1/terceros/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateTerceros(@PathVariable("id") Integer idTerceros,@RequestBody Terceros terceros  ){
        return tercerosRepository.updateTerceros(idTerceros,terceros);
    } 
    
}
