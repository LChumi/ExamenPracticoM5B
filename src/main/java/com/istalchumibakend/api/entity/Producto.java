package com.istalchumibakend.api.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "productos")
public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5957803363257140474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	@Column(length = 100, nullable=false)
	private String descripcion;
	
	@Column(nullable=false)
	private Double precio;
	
	@Column(nullable=false)
	private Integer cantidad;
	

	public Producto(String descripcion, Double precio, Integer cantidad) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Long getId_producto() {
		return codigo;
	}

	public void setId_producto(Long id_producto) {
		this.codigo = id_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double subtotal() {
		return this.precio*this.cantidad;
	}
	
	public Double calcularIva() {
		return subtotal()*1.12;
	}
	
	public double calculaerDescuento() {
		double res=0;
		if(subtotal()>=50) {
			res=subtotal()*0.10;
		}return res;
	}
	
	public double total() {
		return subtotal()+calcularIva()-calculaerDescuento();
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad="
				+ cantidad + ", subtotal()=" + subtotal() + ", calcularIva()=" + calcularIva()
				+ ", calculaerDescuento()=" + calculaerDescuento() + ", total()=" + total() + "]";
	}
	
	

	
}
