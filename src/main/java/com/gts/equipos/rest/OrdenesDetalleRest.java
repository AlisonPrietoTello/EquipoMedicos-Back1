package com.gts.equipos.rest;

import com.gts.equipos.modelo.OrdenesDetalle;
import com.gts.equipos.service.OrdenesDetalleService;
import java.util.List;
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

public class OrdenesDetalleRest {
    
    @Autowired
    private OrdenesDetalleService ordenesDetalleService;
    
    @GetMapping ("/ordenesDetalle/list")
    public List<OrdenesDetalle> findAll(){
        return ordenesDetalleService.findAllOrdenes();
    }         
    
    @RequestMapping (value="/rest/v1/ordenesDetalle/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public OrdenesDetalle createParametro(@RequestBody OrdenesDetalle orden){
        return ordenesDetalleService.cretaeOrdenes(orden);
    }    
    
    @RequestMapping (value="/rest/v1/ordenesDetalle/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateParametro(@PathVariable("id") Integer idOrden, @RequestBody OrdenesDetalle orden ){
        return ordenesDetalleService.updateOrden(idOrden, orden);
    }
    
}
