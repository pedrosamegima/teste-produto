package com.formativa.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.formativa.entities.Produto;

class ProdutoTest {
	private Produto produto;
	
	@BeforeEach
	void setUp(){
		//Arrange
		produto = new Produto(1L, "Iphone", "Black", 8.500 );
	}
	

	@Test
	@DisplayName("Testando o getter e setter do campo Id")
	void testId() {
		//Act
		produto.setId(2L);
		//Assert
		assertEquals(2L, produto.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		produto.setNome("Iphone 15");
		//Assert
		assertEquals("Iphone 15", produto.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo descrição")
	void testDescricao() {
		//Act
		produto.setDescricao("Cinza");
		//Assert
		assertEquals("Cinza", produto.getDescricao());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo preço")
	void testPreco() {
		//Act
		produto.setPreco(9.000);
		//Assert
		assertEquals(9.000, produto.getPreco());
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testeConstrutorAll() {
		//Act
		Produto novoProduto = new Produto(3L, "Iphone 15 pro", "Gold", 10.000);
		//Assertion
		assertAll("novoHospede",
				()-> assertEquals(3L,novoProduto.getId()),
				()-> assertEquals("Iphone 15 pro", novoProduto.getNome()),
				()-> assertEquals("Gold",novoProduto.getDescricao()),
				()-> assertEquals(10.000, novoProduto.getPreco()));
		
	}

}
	