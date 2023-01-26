package com.istalchumibakend.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.istalchumibakend.api.entity.Producto;
import com.istalchumibakend.api.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/crearProducto")
	public ResponseEntity<?> create (@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
	}
	
	@GetMapping("/buscarId/{id}")
	public ResponseEntity<?> read (@PathVariable(value="id")Long codigo){
		Optional<Producto> oProducto= productoService.findById(codigo);
		if(!oProducto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProducto);
	}
	
	@PutMapping("/actualizarProducto/{id}")
	public ResponseEntity<?> update(@RequestBody Producto productodetails,@PathVariable(value="id")Long codigo){
		Optional<Producto> productoNew=productoService.findById(codigo);
		if(!productoNew.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoNew.get().setDescripcion(productodetails.getDescripcion());
		productoNew.get().setPrecio(productodetails.getPrecio());
		productoNew.get().setCantidad(productodetails.getCantidad());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(productoNew.get()));
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id")Long codigo){
		if(!productoService.findById(codigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoService.deleteById(codigo);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/listarProductos")
	public List<Producto> readAll(){
		List<Producto> productos=StreamSupport.stream(productoService.findAll().spliterator(), false).collect(Collectors.toList());
		return productos;
	}
	
	@GetMapping("/productos/percios")
	public String mostrarPrecios(@PathVariable(value="id")Long codigo) {
		Optional<Producto> oProducto= productoService.findById(codigo);
		if(!oProducto.isPresent()) {
		 ResponseEntity.notFound().build();
		}
		 ResponseEntity.ok(oProducto);
		 return oProducto.toString();
	}
	
	
	
}
