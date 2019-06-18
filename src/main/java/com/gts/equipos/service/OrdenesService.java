/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.Ordenes;
import com.gts.equipos.repository.OrdenesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laszlo
 */
@Service
public class OrdenesService {
    @Autowired
    private OrdenesRepository protocolosRepository;
    
     public List<Ordenes> findAllOrdenes(){
        return protocolosRepository.findAll();
    }
     
     
     public Optional<Ordenes> findByIdOrdenes( Integer id){
        return protocolosRepository.findById(id);
    } 
     
     
    public Ordenes createOrdenes( Ordenes ordenes){            
        return protocolosRepository.save(ordenes);
    } 
    
    public String updateOrdenes( Integer idProtocolos, Ordenes ordenes){            
        if (protocolosRepository.findById(idProtocolos) == null)
        {
            return "El Protocolo no existe.";
        }
        else
        {
             protocolosRepository.save(ordenes);
             return "Protocolo actualizado.!";
        }      
    }
}
