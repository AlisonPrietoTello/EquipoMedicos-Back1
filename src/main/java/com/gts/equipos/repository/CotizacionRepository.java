/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gts.equipos.modelo.Cotizacion;

/**
 *
 * @author laszlo
 */
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer>{
    
    @Query("SELECT c FROM Cotizacion c where c.fkEmpresa.idEmpresa = :idEmpresa and c.fkCliente.estado = 1")
    public List<Cotizacion> findCotizacionesClientesActivos(@Param("idEmpresa") Integer idEmpresa);
    
    @Query(value = "SELECT count(*) FROM cotizacion cot, clientes cli where cot.fk_empresa = :idEmpresa and cot.fk_cliente = cli.id_cliente ", nativeQuery = true)
    public Integer totalCotizacionesByEmpresa(@Param("idEmpresa") Integer idEmpresa);
    
    public List<Cotizacion> findByEstado(@Param("estado") Integer estado);
    
    @Query(value = "SELECT id_parametro, nombre FROM parametro where fk_grupo=13;", nativeQuery = true)
    public List<String> metodosDePago();

    
}
