/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;

import com.gts.equipos.modelo.Protocolos;
import com.gts.equipos.service.ProtocolosService;
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

public class ProtocolosRest {
    
    @Autowired
    private ProtocolosService protocolosService;
    
    @RequestMapping (value="/rest/v1/protocolos/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Protocolos> findAll(){
        return protocolosService.findAllProtocolos();
    }
    
    
    @RequestMapping (value="/rest/v1/protocolos/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Protocolos> findById(@PathVariable("id") Integer id  ){
        return protocolosService.findByIdProtocolo(id);
    }
    
    
     @RequestMapping (value="/rest/v1/protocolos/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Protocolos createProtocolos(@RequestBody Protocolos protocolos  ){
        return protocolosService.createProtocolos(protocolos);
    } 
    
     @RequestMapping (value="/rest/v1/protocolos/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateProtocolos(@PathVariable("id") Integer idProtocolos, @RequestBody Protocolos protocolos){
        return protocolosService.updateProtocolos(idProtocolos, protocolos);
    }
}
