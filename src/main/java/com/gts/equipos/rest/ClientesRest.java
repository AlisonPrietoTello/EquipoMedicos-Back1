/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;

import com.gts.equipos.modelo.Clientes;
import com.gts.equipos.service.ClienteService;
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

public class ClientesRest {
      @Autowired
     private ClienteService service;
     
    @GetMapping ("/clientes/list")
    public List<Clientes> findAll(){
        return service.findAllCotizaciones();
    }  
    
    @GetMapping ("/clientes/{id}" )
    public Optional<Clientes> findById(@PathVariable("id") Integer id  ){
        return service.findCotizacionById(id);
    }   
    
    @RequestMapping (value="/clientes/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Clientes createCotizacion(@RequestBody Clientes cliente  ){
        return service.createCotizacion(cliente);
    }    
    @RequestMapping (value="/cliente/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateEmpresa(@PathVariable("id") Integer idCliente,@RequestBody Clientes cliente  ){
        return service.updateCotizacion(idCliente,cliente);
    }  
}
