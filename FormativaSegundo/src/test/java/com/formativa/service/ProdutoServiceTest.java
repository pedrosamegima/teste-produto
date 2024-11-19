package com.formativa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.formativa.entities.Produto;
import com.formativa.repository.ProdutoRepository;

@SpringBootTest
@Transactional

class ProdutoServiceTest {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ProdutoRepository produtoRepository;

	@BeforeEach
	void setUp() {
		produtoRepository.deleteAll(); // Limpa o banco de dados antes de cada teste
	}

	@DisplayName("Testando salvar Produto")
	@Test
	void testSalvarProduto() {
		Produto produto = new Produto(null, "Dell inspiron", "notbook", 3.550);

		Produto resultado = produtoService.salvarProduto(produto);

		assertNotNull(resultado);
		assertEquals("Dell inspiron", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}

	@DisplayName("Testando listar hospedes")
	@Test
	void testListarTodos() {
		Produto produto1 = new Produto(null, "Dell inspiron", "notbook", 3.550);
		Produto produto2 = new Produto(null, "Dell vostro", "notbook", 3.750);

		produtoService.salvarProduto(produto1);
		produtoService.salvarProduto(produto2);

		List<Produto> resultado = produtoService.listarTodos();

		assertNotNull(resultado);
		assertEquals(2, resultado.size());

	}

	@DisplayName("Testando buscar hóspede por Id")
	@Test
	void testBuscarPorId() {
		Produto produto1 = new Produto(null, "Dell inspiron", "notbook", 3.550);

		Produto salvo = produtoService.salvarProduto(produto1);

		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());

		assertTrue(resultado.isPresent());
		assertEquals("Dell inspiron", resultado.get().getNome());
	}

	@DisplayName("Testando atualizar hóspede")
	@Test
	void testAtualizarHospede() {
		Produto produto = new Produto(null, "Dell inspiron", "notbook", 3.550);
		Produto salvo = produtoService.salvarProduto(produto);

		salvo.setNome("Dell vostro");
		salvo.setDescricao("notbook");
		salvo.setPreco(4.500);

		Produto atualizado = produtoService.atualizarProduto(salvo);

		assertNotNull(atualizado);
		assertEquals("Dell vostro", atualizado.getNome());
		assertEquals("notbook", atualizado.getDescricao());
		assertEquals(4.500, atualizado.getPreco());
	}

	@DisplayName("Testando deletar hóspede")
	@Test
	void testDeletarProduto() {
		Produto produto = new Produto(null, "Dell inspiron", "notbook", 3.550);

		Produto salvo = produtoService.salvarProduto(produto);
		produtoService.deletarHospede(produto.getId());

		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());
		assertTrue(resultado.isEmpty());

	}
}