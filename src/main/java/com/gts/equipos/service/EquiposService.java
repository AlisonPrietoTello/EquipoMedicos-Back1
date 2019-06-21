package com.gts.equipos.service;

import com.gts.equipos.modelo.Equipos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gts.equipos.repository.EquiposRepository;
import java.util.Optional;

@Service
public class EquiposService {
    
    @Autowired
    private EquiposRepository  equiposRepository;
    
    public List<Equipos> findAllEquipos(){
        return equiposRepository.findAll();
    } 
     
    public List<Equipos> findByEmpresaAndEquipos(Integer idEmpresa, Integer IdEquipos){
        return equiposRepository.findByEmpresaAndEquipos(idEmpresa, IdEquipos);
    }
    
    
    public Optional<Equipos> findEquiposById( Integer id){
        return equiposRepository.findById(id);
    }

    public Equipos createEquipos( Equipos equipos){            
        return equiposRepository.save(equipos);
    }
    
    public String updateEquipos( Integer idEquipos, Equipos equipos){            
        if (equiposRepository.findById(idEquipos) == null)
        {
            return "El equipo no existe.";
        }
        else
        {
             equiposRepository.save(equipos);
             return "Equipo actualizado.!";
        }      
    }

	public List<Equipos> findByEmpresa(Integer idEmpresa) {
		// TODO Auto-generated method stub
		return equiposRepository.findByEmpresa(idEmpresa);
	}
}
