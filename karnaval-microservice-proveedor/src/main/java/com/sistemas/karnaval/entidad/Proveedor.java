package com.sistemas.karnaval.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // ID único del proveedor

	@Column(nullable = false, unique = true, length = 11)
	private String ruc; // RUC (Registro Único de Contribuyentes) - 11 dígitos

	@Column(nullable = false, length = 100)
	private String razonSocial; // Razón social del proveedor

	@Column(nullable = false, length = 150)
	private String direccion; // Dirección del proveedor

	@Column(nullable = false, length = 20)
	private String telefono; // Teléfono de contacto

	@Column(nullable = false, length = 50)
	private String email; // Email del proveedor

	@Column(nullable = false)
	private Boolean estado; // Estado del proveedor (Activo/Inactivo)
}