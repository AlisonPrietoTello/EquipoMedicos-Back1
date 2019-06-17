package com.gts.equipos.service;

import com.gts.equipos.modelo.Parametro;
import com.gts.equipos.repository.ParametroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametroService {
    @Autowired
    private ParametroRepository parametroRepository;
    
    public List<Parametro> findAllParametro(){
        return parametroRepository.findAll();
    } 

    public List<Parametro> findByEmpresaAndParametro(Integer idEmpresa, Integer idParametro){
        return parametroRepository.findByEmpresaAndParametro(idEmpresa, idParametro);
    }
    
    public List<Parametro> findByGrupoAndParametro(Integer idGrupo, Integer idParametro){
        return parametroRepository.findByGrupoAndParametro(idGrupo, idParametro);
    }
    
    public List<Parametro> findByEmpresaAndGrupo(Integer idEmpresa, Integer idGrupo){
        return parametroRepository.findByEmpresaAndGrupo(idEmpresa, idGrupo);
    }
    
    public List<Parametro> findByEmpresaAndGrupoAndParametro(Integer idEmpresa, Integer idGrupo, Integer idParametro){
        return parametroRepository.findByEmpresaAndGrupoAndParametro(idEmpresa, idGrupo, idParametro);
    }
     
    public Optional<Parametro> findParametroById( Integer id){
        return parametroRepository.findById(id);
    }
    
    public List<Parametro>findByParametroXEMpresa (Integer idEmpresa){
        return parametroRepository.findByParametroXEMpresa(idEmpresa);
    }
    
    public Parametro cretaeParametro( Parametro parametro){            
        return parametroRepository.save(parametro);
    }
    
    public String updateParametro( Integer idParametro, Parametro parametro){            
        if (parametroRepository.findById(idParametro) == null)
        {
            return "El parametro no existe.";
        }
        else
        {
             parametroRepository.save(parametro);
             return "Parametro actualizada.!";
        }      
    }
    
}
