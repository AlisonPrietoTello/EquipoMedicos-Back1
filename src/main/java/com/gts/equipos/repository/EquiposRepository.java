/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.repository;

import com.gts.equipos.modelo.Equipos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Xamir Mercado
 */
public interface EquiposRepository extends JpaRepository< Equipos, Integer>{
    
    @Query("SELECT e FROM Equipos e WHERE e.fkEmpresa.idEmpresa = :idEmpresa AND e.idEquipos = :idEquipos")
    List<Equipos> findByEmpresaAndEquipos(@Param("idEmpresa") Integer IdEmpresa, @Param("idEquipos") Integer IdEquipos);

    @Query(value="SELECT * FROM equipos e WHERE e.fk_empresa = :idEmpresa", nativeQuery = true)
    List<Equipos> findByEmpresa(@Param("idEmpresa") Integer idEmpresa);
}
