/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.repository;

import com.gts.equipos.modelo.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author laszlo
 */
public interface ClienteRepository extends JpaRepository<Clientes, Integer>{
    
}
