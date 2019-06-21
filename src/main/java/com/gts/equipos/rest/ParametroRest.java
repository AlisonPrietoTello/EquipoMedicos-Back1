package com.gts.equipos.rest;

import com.gts.equipos.modelo.Parametro;
import com.gts.equipos.service.ParametroService;
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
public class ParametroRest {
    
    @Autowired
    private ParametroService parametroService;
    
    @GetMapping ("/parametro/list")
    public List<Parametro> findAll(){
        return parametroService.findAllParametro();
    }     

    @RequestMapping (value="/rest/v1/parametro/filtro_empresa_parametro/{idEmpresa}/{idParametro}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Parametro> findByEmpresaAndParametro(@PathVariable("idEmpresa") Integer idEmpresa, 
                                                     @PathVariable("idParametro") Integer idParametro ){
        return parametroService.findByEmpresaAndParametro(idEmpresa, idParametro);
    }

    @RequestMapping (value="/rest/v1/parametro/filtro_grupo_parametro/{idGrupo}/{idParametro}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Parametro> findByGrupoAndParametro(@PathVariable("idGrupo") Integer idGrupo, 
                                                   @PathVariable("idParametro") Integer idParametro ){
        return parametroService.findByGrupoAndParametro(idGrupo, idParametro);
    }

    @RequestMapping (value="/rest/v1/parametro/filtro_empresa_grupo/{idEmpresa}/{idGrupo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Parametro> findByEmpresaAndGrupo(@PathVariable("idEmpresa") Integer idGrupo, 
                                                   @PathVariable("idGrupo") Integer idParametro ){
        return parametroService.findByEmpresaAndGrupo(idGrupo, idGrupo);
    }


    @RequestMapping (value="/rest/v1/parametro/filtro_empresa_grupo_parametro/{idEmpresa}/{idGrupo}/{idParametro}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Parametro> findByEmpresaAndGrupoAndParametro(@PathVariable("idEmpresa") Integer idEmpresa, 
                                                             @PathVariable("idGrupo") Integer idGrupo, 
                                                             @PathVariable("idParametro") Integer idParametro ){
        return parametroService.findByEmpresaAndGrupoAndParametro(idEmpresa, idGrupo, idParametro);
    }

    
    
    //Listar parametors por id
    @RequestMapping (value="/rest/v1/parametro/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Parametro> findById(@PathVariable("id") Integer id  ){
        return parametroService.findParametroById(id);
    }
    
     //Listar parametors por Empresa
    @RequestMapping (value="/rest/v1/parametro/empresa/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Parametro> findByParametroXEMpresa(@PathVariable("id") Integer idEmpresa  ){
        return parametroService.findByParametroXEMpresa(idEmpresa);
    }
    
    
    
    //Crear un nuevo parametro
    @RequestMapping (value="/rest/v1/parametro/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Parametro createParametro(@RequestBody Parametro parametro  ){
        return parametroService.cretaeParametro(parametro);
    }    
    
    //Modificar parametros
    @RequestMapping (value="/rest/v1/parametro/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateParametro(@PathVariable("id") Integer idParametro, @RequestBody Parametro parametro  ){
        return parametroService.updateParametro(idParametro, parametro);
    }
    
}
