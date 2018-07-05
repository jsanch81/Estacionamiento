package com.ceiba.estacionamiento.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vehiculo")
@EntityListeners(AuditingEntityListener.class)
public class VehiculoModel implements Serializable {
	

		private static final long serialVersionUID = 1L;

		@Id
	 	@NotBlank
	 	@NotNull
	    private String placa;

		@NotNull
	    private String tipo;

	    @NotNull
	    private short cilindraje;
	    
	    @NotNull
	    private String estado;
	    
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    @NotNull
	    private Date fechaIngreso;

	    @NotNull
	    private long ingresoTimestamp;
		
	    @Autowired
	    public VehiculoModel() {}
	    
	    public VehiculoModel(String placa, String tipo, short cilindraje){
	    	this.placa = placa;
	    	this.tipo = tipo;
	    	this.cilindraje = cilindraje;
	    	this.estado = "false";
	    }
	    
		public String getPlaca() {
			return placa;
		}

		public String getTipo() {
			return tipo;
		}

		public short getCilindraje() {
			return cilindraje;
		}

		public String getEstado() {
			return estado;
		}	
		
		public Date getFechaIngreso() {
			return fechaIngreso;
		}

		public long getIngresoTimestamp() {
			return ingresoTimestamp;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		public void setFechaIngreso(Date fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}

		public void setIngresoTimestamp(long ingresoTimestamp) {
			this.ingresoTimestamp = ingresoTimestamp;
		}

	    
	    // Getters and Setters ... (Omitted for brevity)
	    	
}
