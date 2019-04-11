package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;

public abstract class AdministracionElectronicaBase {
	protected int id;
	protected String nombre;
	protected Usuario usuario;
	protected LocalDate fechaCreacion;
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	
}
