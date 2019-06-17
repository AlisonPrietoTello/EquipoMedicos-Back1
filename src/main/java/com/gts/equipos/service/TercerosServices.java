/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.Terceros;
import com.gts.equipos.repository.TercerosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xamir Mercado
 */
@Service
public class TercerosServices {
    
    @Autowired
    private TercerosRepository tercerosRepository;
    
     public List<Terceros> findAllTerceros(){
        return tercerosRepository.findAll();
    }
     
      public Optional<Terceros> findTercerosById( Integer id){
        return tercerosRepository.findById(id);
    } 
      
     public Terceros createTerceros( Terceros terceros){     
        return tercerosRepository.save(terceros);
    }  
     
    public String updateTerceros( Integer idTerceros, Terceros terceros){            
        if (   tercerosRepository.findById(idTerceros) == null  )
        {
            return "Terceros No existe.";
        }else {
             tercerosRepository.save(terceros);
             return "Terceros Actualizado.!";
        }      
    } 
    
}
