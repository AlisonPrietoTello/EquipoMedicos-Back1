/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.repository;

import com.gts.equipos.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Erick Arias
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
}
