package com.gts.equipos.rest;

import com.gts.equipos.modelo.Instrumentos;
import com.gts.equipos.service.InstrumentosService;
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

@RestController
@CrossOrigin(origins={"http://localhost:4200","*"})
public class InstrumentosRest {

    @Autowired
    private InstrumentosService instrumentosService;

    @RequestMapping (value="/rest/v1/instrumentos/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Instrumentos> findAll(){
        return instrumentosService.findAllInstrumentos();
    }     
    
    @RequestMapping (value="/rest/v1/instrumentos/{idEmpresa}/{idInstrumentos}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Instrumentos> findByEmpresaAndInstrumentos(@PathVariable("idEmpresa") Integer idEmpresa, 
                                                           @PathVariable("idInstrumentos") Integer idInstrumentos ){
        return instrumentosService.findByEmpresaAndInstrumentos(idEmpresa, idInstrumentos);
    }
    
    @RequestMapping (value="/rest/v1/instrumentos/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Instrumentos> findById(@PathVariable("id") Integer id  ){
        return instrumentosService.findInstrumentosById(id);
    }
    
    @RequestMapping (value="/rest/v1/instrumentos/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Instrumentos createInstrumentos(@RequestBody Instrumentos instrumentos  ){
        return instrumentosService.cretaeInstrumentos(instrumentos);
    }    
    
    @RequestMapping (value="/rest/v1/instrumentos/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateActividades(@PathVariable("id") Integer idActividades,@RequestBody Instrumentos instrumentos  ){
        return instrumentosService.updateActividades(idActividades,instrumentos);
    }  
}
