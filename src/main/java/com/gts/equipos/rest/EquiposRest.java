package com.gts.equipos.rest;

import com.gts.equipos.modelo.Equipos;
import com.gts.equipos.service.EquiposService;
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
public class EquiposRest {
    
    @Autowired
    private EquiposService equiposService;
    
    @RequestMapping (value="/rest/v1/equipos/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Equipos> findAll(){
        return equiposService.findAllEquipos();
    }
    @RequestMapping (value="/rest/v1/equipos/{idEmpresa}/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Equipos> findByEmpresa(@PathVariable("idEmpresa") Integer idEmpresa){
        return equiposService.findByEmpresa(idEmpresa);
    }
    @RequestMapping (value="/rest/v1/equipos/{idEmpresa}/{idEquipos}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Equipos> findByEmpresaAndEquipos(@PathVariable("idEmpresa") Integer idEmpresa, @PathVariable("idEquipos") Integer idEquipos ){
        return equiposService.findByEmpresaAndEquipos(idEmpresa, idEquipos);
    }

    @RequestMapping (value="/rest/v1/equipos/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Equipos> findById(@PathVariable("id") Integer id  ){
        return equiposService.findEquiposById(id);
    }

    @RequestMapping (value="/rest/v1/equipos/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Equipos createEquipos(@RequestBody Equipos equipos  ){
        return equiposService.createEquipos(equipos);
    }    
    
    @RequestMapping (value="/rest/v1/equipos/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateEquipos(@PathVariable("id") Integer idEquipos, @RequestBody Equipos equipos){
        return equiposService.updateEquipos(idEquipos, equipos);
    }
    
}
