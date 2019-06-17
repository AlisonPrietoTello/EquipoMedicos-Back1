package com.gts.equipos.rest;

import com.gts.equipos.modelo.Grupo;
import com.gts.equipos.service.GrupoService;
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
public class GrupoRest {
    
    @Autowired
    private GrupoService grupoService;
    
    //Listar grupos
    @RequestMapping (value="/rest/v1/grupo/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Grupo> findAll(){
        return grupoService.findAllParametro();
    }    
    

    //GRupos por idEMpresa y idGrupo
    @RequestMapping (value="/rest/v1/grupos/{idEmpresa}/{idGrupos}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )

     public List<Grupo> findByFkEmpresaAndGrupos(@PathVariable("idEmpresa") Integer idEmpresa, @PathVariable("idGrupos") Integer idGrupos ){
        return grupoService.findByFkEmpresaAndGrupos(idEmpresa, idGrupos);
    }
    
    //Grupos por idGrupo
    @RequestMapping (value="/rest/v1/grupo/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Grupo> findById(@PathVariable("id") Integer id  ){
        return grupoService.findParametroById(id);
    }

    //Crear nuevo grupo
    @RequestMapping (value="/rest/v1/grupo/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Grupo createGrupo(@RequestBody Grupo grupo  ){
        return grupoService.cretaeGrupo(grupo);
    }    
    
    //Modificar grupos
    @RequestMapping (value="/rest/v1/grupo/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateParametro(@PathVariable("id") Integer idGrupo, @RequestBody Grupo grupo){
        return grupoService.updateGrupo(idGrupo, grupo);
    }
    
}
