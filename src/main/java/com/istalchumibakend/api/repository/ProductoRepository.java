package com.istalchumibakend.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.istalchumibakend.api.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{
	
	Page<Producto> findAll(Pageable pageable );

}
