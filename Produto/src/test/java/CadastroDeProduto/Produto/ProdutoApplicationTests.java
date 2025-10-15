package CadastroDeProduto.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import CadastroDeProduto.Produto.Model.ProdutoModel;
import CadastroDeProduto.Produto.Repository.ProdutoRepository;
import CadastroDeProduto.Produto.Service.ProdutoService;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Habilita o uso de anotações do Mockito
class ProdutoApplicationTests {

	@Mock // Cria um mock do repositório
	private ProdutoRepository repository;

	@InjectMocks // Cria uma instância do serviço e injeta os mocks (o 'repository' acima)
	private ProdutoService service;

	@Test
	void listarTodosProdutos(){
		ProdutoModel produto1 = new ProdutoModel();
		produto1.setNome("Notebook");
		produto1.setPreco(2000);
		produto1.setQuantidade(5);
		when(repository.findAll()).thenReturn(List.of(produto1));
		List<ProdutoModel> resultado = service.listarTodosProdutos();
		assertEquals(1, resultado.size());
		assertEquals("Notebook", resultado.get(0).getNome());

	}
	@Test
	void Teste(){
		String texto = "Testando..";
		assertEquals("Testando..", texto);
	}
	@Test
	void salvarProduto(){
		ProdutoModel produto1 = new ProdutoModel();
		produto1.setNome("Notebook");
		produto1.setPreco(2000);
		produto1.setQuantidade(5);
		when(repository.save(produto1)).thenReturn(produto1);
		ProdutoModel resultado = service.salvarProduto(produto1);
		assertEquals("Notebook", resultado.getNome());

	}
	@Test
	void buscarProduto(){
		ProdutoModel produto1 = new ProdutoModel();
		produto1.setId(1);
		produto1.setNome("Notebook");
		produto1.setPreco(2000);
			produto1.setQuantidade(5);
	    when(repository.findById(produto1.getId())).thenReturn(Optional.of(produto1));
			ProdutoModel resultado = service.buscarProduto(produto1.getId());
		assertEquals("Notebook", resultado.getNome());

	}
}
