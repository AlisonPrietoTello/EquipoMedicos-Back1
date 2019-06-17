package com.gts.equipos.rest;

import com.gts.equipos.modelo.InstrumentosProtocolo;
import com.gts.equipos.service.InstrumentosProtocoloService;
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
public class InstrumentosProtocoloRest {

    @Autowired
    private InstrumentosProtocoloService instrumentosProtocoloService;
    
    //Lista de instrumentos_protocolos
    @RequestMapping (value="/rest/v1/instrumentos_protocolo/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<InstrumentosProtocolo> findAll(){
        return instrumentosProtocoloService.findAllInstrumentosProtocolo();
    }     
    
    @RequestMapping (value="/rest/v1/instrumentos_protocolo/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<InstrumentosProtocolo> findById(@PathVariable("id") Integer idInstProt  ){
        return instrumentosProtocoloService.findInstrumentosProtocoloById(idInstProt);
    }
     
    @RequestMapping (value="/rest/v1/instrumentos_protocolo/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public InstrumentosProtocolo createInstrumentosProtocolo(@RequestBody InstrumentosProtocolo instrumentosProtocolo  ){
        return instrumentosProtocoloService.cretaeInstrumentosProtocolo(instrumentosProtocolo);
    }    
    
    @RequestMapping (value="/rest/v1/instrumentos_protocolo/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateInstrumentosProtocolo(@PathVariable("id") Integer idInstProt,@RequestBody InstrumentosProtocolo instrumentosProtocolo  ){
        return instrumentosProtocoloService.updateInstrumentosProtocolo(idInstProt, instrumentosProtocolo);
    }  
    
    
    @RequestMapping (value="/rest/v1/ip/{idEmpresa}/instrumento/{idInstrumento}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public List<InstrumentosProtocolo> findInstrumentosProtocoloByIdEmpresa_and_IdInstrumento(@PathVariable("idEmpresa") Integer idEmpresa, @PathVariable("idInstrumento") Integer idInstrumento ){
        return instrumentosProtocoloService.findInstrumentosProtocoloByIdEmpresa_and_IdInstrumento(idEmpresa, idInstrumento);
    }
    
    
    
    @RequestMapping (value="/rest/v1/ip/{idEmpresa}/protocolo/{idProtocolo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public List<InstrumentosProtocolo> findInstrumentosProtocoloByIdEmpresa_and_IdProtocolo(@PathVariable("idEmpresa") Integer idEmpresa, @PathVariable("idProtocolo") Integer idProtocolo ){
        return instrumentosProtocoloService.findInstrumentosProtocoloByIdEmpresa_and_IdInstrumento(idEmpresa, idProtocolo);
    }
}
