/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.Grupo;
import com.gts.equipos.repository.GrupoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Arias
 */
@Service
public class GrupoService {
    
    @Autowired
    private GrupoRepository grupoRepository;
    
    public List<Grupo> findAllParametro(){
        return grupoRepository.findAll();
    } 
     
    public Optional<Grupo> findParametroById( Integer id){
        return grupoRepository.findById(id);
    }
    
    
    public List<Grupo> findByFkEmpresaAndGrupos(Integer idEmpresa, Integer IdGrupos){
        return grupoRepository.findByFkEmpresaAndGrupos(idEmpresa, IdGrupos);
    }
    
    public Grupo cretaeGrupo( Grupo parametro){            
        return grupoRepository.save(parametro);
    }
    
    public String updateGrupo( Integer idGrupo, Grupo grupo){            
        if (grupoRepository.findById(idGrupo) == null)
        {
            return "El grupo no existe.";
        }
        else
        {
             grupoRepository.save(grupo);
             return "Grupo actualizada.!";
        }      
    }
    
}
