package com.gts.equipos.service;

import com.gts.equipos.modelo.Ordenes;
import com.gts.equipos.repository.OrdenesRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenesService {
    @Autowired
    private OrdenesRepository OrdenesDao;
    
    public List<Ordenes> findAllOrdenes(){
        return OrdenesDao.findAll();
    } 

    public Optional<Ordenes> findOrdenesById( Integer id){
        return OrdenesDao.findById(id);
    }
    
    public Ordenes cretaeOrdenes( Ordenes orden){            
        return OrdenesDao.save(orden);
    }
    
    public String updateOrden( Integer idOrden, Ordenes orden){            
        if (OrdenesDao.findById(idOrden) == null)
        {
            return "El parametro no existe.";
        }
        else
        {
        	OrdenesDao.save(orden);
             return "Parametro actualizada.!";
        }      
    }
    
}
