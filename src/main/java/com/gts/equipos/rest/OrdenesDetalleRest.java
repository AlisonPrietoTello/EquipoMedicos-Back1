/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;

import com.gts.equipos.modelo.OrdenesDetalle;
import com.gts.equipos.service.OrdenesDetalleService;
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

public class OrdenesDetalleRest {
    @Autowired
    private OrdenesDetalleService service;

    @RequestMapping (value="ordenes/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<OrdenesDetalle> findAll(){
        return service.findAllOrdenes();
    }     
    
    @RequestMapping (value="ordenes/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<OrdenesDetalle> findById(@PathVariable("id") Integer id  ){
        return service.findByIdOrden(id);
    }
    
    @RequestMapping (value="ordenes/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public OrdenesDetalle createInstrumentos(@RequestBody OrdenesDetalle ordenesDetalle  ){
        return service.createOrden(ordenesDetalle);
    }    
    
    @RequestMapping (value="ordenes/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateActividades(@PathVariable("id") Integer idActividades,@RequestBody OrdenesDetalle ordenesDetalle  ){
        return service.updateOrden(idActividades,ordenesDetalle);
    }  
}
