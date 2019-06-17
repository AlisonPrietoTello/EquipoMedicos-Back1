/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.repository;

import com.gts.equipos.modelo.Grupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Erick Arias
 */
public interface GrupoRepository extends JpaRepository<Grupo, Integer>{
    
    
    @Query("SELECT g FROM Grupo g WHERE g.fkEmpresa = :fkEmpresa")
    List<Grupo> findByIdEmpresa(@Param("fkEmpresa") Integer idEmpresa );
    
    
    @Query("SELECT g FROM Grupo g WHERE g.fkEmpresa = :idEmpresa AND g.idGrupo = :idGrupo")
    List<Grupo> findByFkEmpresaAndGrupos(@Param("idEmpresa") Integer IdEmpresa, @Param("idGrupo") Integer IdEquipos);
    
    
}
