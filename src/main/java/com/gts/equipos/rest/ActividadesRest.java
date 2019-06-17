package com.gts.equipos.rest;

import com.gts.equipos.modelo.Actividades;
import com.gts.equipos.service.ActividadesService;
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
@RequestMapping("/rest/v1/")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class ActividadesRest {
    
    @Autowired
    private ActividadesService actividadesService;
    
    //lista de actividades
    @GetMapping ("/actividades/list")
    public List<Actividades> findAll(){
        return actividadesService.findAllActividades();
    }  
    
    //Actividades por idEmpresa y idActividades
    @RequestMapping (value="/actividades/{idEmpresa}/{idActividades}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Actividades> findByEmpresaAndEquipos(@PathVariable("idEmpresa") Integer idEmpresa, @PathVariable("idActividades") Integer idActividades ){
        return actividadesService.findByIEmpresaAndActividades(idEmpresa, idActividades);
    }
    
    //Actividades por idProtocolo
    @RequestMapping (value="/actividades/protocolo/{idProtocolo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Actividades> findByActividadesXProtocolo(@PathVariable("idProtocolo") Integer idProtocolo ){
        return actividadesService.findByActividadesXProtocolo(idProtocolo);
    }
    
     //Actividades por idActividades y idProtocolo
    @RequestMapping (value="/actividades/protocolo/{idActividades}/{idProtocolo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Actividades> findByIProtocoloAndActividades(@PathVariable("idActividades") Integer idActividades, @PathVariable("idProtocolo") Integer idProtocolo ){
        return actividadesService.findByIProtocoloAndActividades(idActividades, idProtocolo);
    }
    
    //avtividades por idEmpresa, idProtocolo y idActividades
    @RequestMapping (value="/actividades/protocolo/{idEmpresa}/{idProtocolo}/{idActividades}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Actividades> findByIEmpresaAndProtoloAndactividades(@PathVariable("idEmpresa") Integer idEmpresa, @PathVariable("idProtocolo") Integer idProtocolo, @PathVariable("idActividades") Integer idActividades ){
        return actividadesService.findByIEmpresaAndProtoloAndactividades(idEmpresa, idProtocolo, idActividades);
    }
    
    
    //actividades por id
    @GetMapping ("/actividades/{id}" )
    public Optional<Actividades> findById(@PathVariable("id") Integer id  ){
        return actividadesService.findActividadesById(id);
    }    
    
    //Crear actividades
    @RequestMapping (value="/actividades/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Actividades createActividades(@RequestBody Actividades actividades  ){
        return actividadesService.createActividades(actividades);
    }    
    
    //Modificar actividades
    @RequestMapping (value="/actividades/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateActividades(@PathVariable("id") Integer idActividades,@RequestBody Actividades actividades  ){
        return actividadesService.updateActividades(idActividades,actividades);
    }
}
