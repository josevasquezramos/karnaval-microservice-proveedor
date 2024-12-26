package com.sistemas.karnaval.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.karnaval.entidad.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}
