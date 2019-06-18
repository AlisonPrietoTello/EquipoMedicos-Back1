/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gts.equipos.modelo.Ordenes;
/**
 *
 * @author laszlo
 */
public interface OrdenesRepository extends JpaRepository<Ordenes, Integer>{
    
}
