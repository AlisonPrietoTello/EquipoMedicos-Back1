/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.rest;

import com.gts.equipos.modelo.Empresa;
import com.gts.equipos.service.EmpresaService;
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
 * @author Erick Arias
 */
@RestController
@CrossOrigin(origins={"http://localhost:4200","*"})

public class EmpresaRest {
     
    @Autowired
    private EmpresaService empresaService;
    
    @RequestMapping (value="/rest/v1/empresa/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public List<Empresa> findAll(){
        return empresaService.findAllEmpresa();
    }     
    
    @RequestMapping (value="/rest/v1/empresa/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE  )
    public Optional<Empresa> findById(@PathVariable("id") Integer idEmpresa  ){
        return empresaService.findEmpresaById(idEmpresa);
    }
     
    @RequestMapping (value="/rest/v1/empresa/new", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Empresa createEmpresa(@RequestBody Empresa empresa  ){
        return empresaService.cretaeEmpresa(empresa);
    }    
    
    @RequestMapping (value="/rest/v1/empresa/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public String updateEmpresa(@PathVariable("id") Integer idEmpresa,@RequestBody Empresa empresa  ){
        return empresaService.updateEmpresa(idEmpresa,empresa);
    }  
        
}
