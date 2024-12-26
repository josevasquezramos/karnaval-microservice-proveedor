package com.sistemas.karnaval.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.karnaval.entidad.Proveedor;
import com.sistemas.karnaval.repositorio.ProveedorRepository;
import com.sistemas.karnaval.servicio.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor crear(Proveedor entidad) {
        return proveedorRepository.save(entidad);
    }

    @Override
    public Proveedor actualizar(Long id, Proveedor entidad) {
        if (!proveedorRepository.existsById(id)) {
            throw new RuntimeException("Proveedor no encontrado");
        }
        entidad.setId(id); // Asegúrate de establecer el ID
        return proveedorRepository.save(entidad);
    }

    @Override
    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }
}
