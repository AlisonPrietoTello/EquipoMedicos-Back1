/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;

import com.gts.equipos.modelo.Ordenes;
import com.gts.equipos.service.OrdenesService;
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
 * @author laszlo
 */
@RestController
@RequestMapping("/rest/v1/")
@CrossOrigin(origins={"http://localhost:4200","*"})

public class OrdenesRest {
        @Autowired
    private OrdenesService service;

    @RequestMapping (value="ordenes/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Ordenes> findAll(){
        return service.findAllOrdenes();
    }     
    
    @RequestMapping (value="ordenes/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Ordenes> findById(@PathVariable("id") Integer id  ){
        return service.findByIdOrdenes(id);
    }
    
    @RequestMapping (value="ordenes/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Ordenes createInstrumentos(@RequestBody Ordenes ordenes  ){
        return service.createOrdenes(ordenes);
    }    
    
    @RequestMapping (value="ordenes/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateActividades(@PathVariable("id") Integer idActividades,@RequestBody Ordenes ordenes  ){
        return service.updateOrdenes(idActividades,ordenes);
    }  
}
