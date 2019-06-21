package com.gts.equipos.service;

import com.gts.equipos.modelo.OrdenesDetalle;
import com.gts.equipos.repository.OrdenesDetalleRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenesDetalleService {
    @Autowired
    private OrdenesDetalleRepository OrdenesDetalleDao;
    
    public List<OrdenesDetalle> findAllOrdenes(){
        return OrdenesDetalleDao.findAll();
    } 

    public Optional<OrdenesDetalle> findOrdenesById( Integer id){
        return OrdenesDetalleDao.findById(id);
    }
    
    public OrdenesDetalle cretaeOrdenes( OrdenesDetalle orden){            
        return OrdenesDetalleDao.save(orden);
    }
    
    public String updateOrden( Integer idOrden, OrdenesDetalle orden){            
        if (OrdenesDetalleDao.findById(idOrden) == null)
        {
            return "El parametro no existe.";
        }
        else
        {
        	OrdenesDetalleDao.save(orden);
             return "Parametro actualizada.!";
        }      
    }
    
}
