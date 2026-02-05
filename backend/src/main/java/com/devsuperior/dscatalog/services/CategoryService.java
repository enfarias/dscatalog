package com.devsuperior.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRespository;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryRespository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
/*		
		Substitui este código pelo código abaixo, fora do comentário 
		List<CategoryDTO> listDto = new ArrayList<>();
		for(Category cat : list) {
			listDto.add(new CategoryDTO(cat));
		}
		return listDto;
*/
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

}
