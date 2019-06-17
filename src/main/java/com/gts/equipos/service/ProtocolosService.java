/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.Protocolos;
import com.gts.equipos.repository.ProtocolosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xamir Mercado
 */
@Service
public class ProtocolosService {
    
    @Autowired
    private ProtocolosRepository protocolosRepository;
    
     public List<Protocolos> findAllProtocolos(){
        return protocolosRepository.findAll();
    }
     
     
     public Optional<Protocolos> findByIdProtocolo( Integer id){
        return protocolosRepository.findById(id);
    } 
     
     
    public Protocolos createProtocolos( Protocolos Protocolos){            
        return protocolosRepository.save(Protocolos);
    } 
    
    public String updateProtocolos( Integer idProtocolos, Protocolos protocolos){            
        if (protocolosRepository.findById(idProtocolos) == null)
        {
            return "El Protocolo no existe.";
        }
        else
        {
             protocolosRepository.save(protocolos);
             return "Protocolo actualizado.!";
        }      
    }
    
}
