package com.gts.equipos.rest;

import com.gts.equipos.modelo.Ordenes;
import com.gts.equipos.service.OrdenesService;
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

@RestController
@CrossOrigin(origins={"http://localhost:4200","*"})
@RequestMapping ("/rest/v1/")

public class OrdenesRest {
    
    @Autowired
    private OrdenesService ordenesService;
    
    @GetMapping ("/ordenes/list")
    public List<Ordenes> findAll(){
        return ordenesService.findAllOrdenes();
    }         
    
    @RequestMapping (value="/rest/v1/ordenes/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Ordenes createParametro(@RequestBody Ordenes orden){
        return ordenesService.cretaeOrdenes(orden);
    }    
    
    @RequestMapping (value="/rest/v1/ordenes/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateParametro(@PathVariable("id") Integer idOrden, @RequestBody Ordenes orden ){
        return ordenesService.updateOrden(idOrden, orden);
    }
    
}
