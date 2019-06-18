/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.OrdenesDetalle;
import com.gts.equipos.repository.OrdenesDetalleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laszlo
 */
@Service
public class OrdenesDetalleService {
    @Autowired
    private OrdenesDetalleRepository protocolosRepository;
    
     public List<OrdenesDetalle> findAllOrdenes(){
        return protocolosRepository.findAll();
    }
     
     
     public Optional<OrdenesDetalle> findByIdOrden( Integer id){
        return protocolosRepository.findById(id);
    } 
     
     
    public OrdenesDetalle createOrden( OrdenesDetalle ordenesDetalle){            
        return protocolosRepository.save(ordenesDetalle);
    } 
    
    public String updateOrden( Integer idProtocolos, OrdenesDetalle ordenesDetalle){            
        if (protocolosRepository.findById(idProtocolos) == null)
        {
            return "El Protocolo no existe.";
        }
        else
        {
             protocolosRepository.save(ordenesDetalle);
             return "Protocolo actualizado.!";
        }      
    }
}
