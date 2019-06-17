/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.Empresa;
import com.gts.equipos.repository.EmpresaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Arias
 */
@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;    
    
    public List<Empresa> findAllEmpresa(){
        return empresaRepository.findAll();
    } 
     
    public Optional<Empresa> findEmpresaById( Integer id){
        return empresaRepository.findById(id);
    }    
    
    public Empresa cretaeEmpresa( Empresa empresa){
            
        return empresaRepository.save(empresa);
    }
    
    public String updateEmpresa( Integer idEmpresa, Empresa empresa){            
        if (   empresaRepository.findById(idEmpresa) == null  )
        {
            return "Empresa No existe.";
        }else {
             empresaRepository.save(empresa);
             return "Emnpresa Actualizada.!";
        }      
    }    
    
}
