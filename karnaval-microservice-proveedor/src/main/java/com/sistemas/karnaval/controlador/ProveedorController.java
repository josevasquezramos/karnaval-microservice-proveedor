package com.sistemas.karnaval.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.karnaval.entidad.Proveedor;
import com.sistemas.karnaval.servicio.ProveedorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;

	/**
	 * Endpoint para listar todos los proveedores.
	 * 
	 * @return Lista de proveedores.
	 */
	@GetMapping
	public ResponseEntity<List<Proveedor>> listarProveedores() {
		return ResponseEntity.ok(proveedorService.listarTodos());
	}

	/**
	 * Endpoint para obtener un proveedor por su ID.
	 * 
	 * @param id ID del proveedor.
	 * @return Detalles del proveedor.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Long id) {
		return ResponseEntity.ok(proveedorService.buscarPorId(id));
	}

	/**
	 * Endpoint para crear un nuevo proveedor.
	 * 
	 * @param proveedor Datos del proveedor.
	 * @return Proveedor creado.
	 */
	@PostMapping
	public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
		return ResponseEntity.ok(proveedorService.crear(proveedor));
	}

	/**
	 * Endpoint para actualizar un proveedor existente.
	 * 
	 * @param id        ID del proveedor a actualizar.
	 * @param proveedor Datos del proveedor a actualizar.
	 * @return Proveedor actualizado.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
		return ResponseEntity.ok(proveedorService.actualizar(id, proveedor));
	}

	/**
	 * Endpoint para eliminar un proveedor.
	 * 
	 * @param id ID del proveedor a eliminar.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
		proveedorService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
