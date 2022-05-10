package com.ecommerce.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.QRcode.ZXingHelper;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.modal.Product;
import com.ecommerce.service.ProductService;

import antlr.CodeGenerator;


import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductController {
	

	@Autowired
	private ProductService productService;
	

	@Autowired
	private ProductDao productDao;

	@PostMapping("/addProductToCategory/{idCategory}")
	Product addProductToCategory(@RequestBody Product product, @PathVariable long idCategory) {
		return productService.addProductToCategory(product, idCategory);
	}

	@PutMapping("/editProduct/{id}")
	Product editProduct(@RequestBody Product product, @PathVariable long id) {
		 return productService.editProduct(product, id);
	}

	@GetMapping("/findProductById/{id}")
	Product findProductById(@PathVariable long id) {
		return productService.findProductById(id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/findAllProducts")
	List<Product> findAllProducts()
			 {
		return productService.findAllProducts();
	}

	@GetMapping("/findProductsForCategory/{idCategory}")
	List<Product> findProductsForCategory(@PathVariable long idCategory) {
		return productService.findProductsForCategory(idCategory);
	}

	@GetMapping("/findByName/{name}")
	List<Product> findByName(@PathVariable String name) {
		return productDao.findByName("%" + name + "%");
	}
	
	
   
	
	
	
	
	 @RequestMapping(value = "qrcode/{id}", method = RequestMethod.GET)
		public void qrcode(@PathVariable("id") long id, HttpServletResponse response) throws Exception {
			response.setContentType("image/png");
			
			Product produit=productDao.findById(id).orElse(null);
			String text = "\n Nom produit : "+produit.getName()+"\n Prix produit : "+produit.getPrice()+"\n Description produit : "+produit.getDescription()
			;
			
			
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(ZXingHelper.getQRCodeImage(text, 200, 200));
			outputStream.flush();
			outputStream.close();
			
		} 
	 
	 
	 @GetMapping
	    
	    Page<Product> getProduit(
	            @RequestParam Optional<Integer> page,
	            @RequestParam Optional<String> sortBy
	    ) {
	    	
	        return productDao.findAll(
	                PageRequest.of(
	                        page.orElse(0),
	                        2,
	                        Sort.Direction.ASC, sortBy.orElse("id")
	                )
	        );
	    }
		
	 
	 
	
}
