package CadastroDeProduto.Produto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CadastroDeProduto.Produto.Model.ProdutoModel;
import CadastroDeProduto.Produto.Repository.ProdutoRepository;

@Service
public class ProdutoService {
 
  private final ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public ProdutoModel salvarProduto(ProdutoModel produto) {

    String nome = produto.getNome();
    double preco = produto.getPreco();
    int quantidade = produto.getQuantidade();

    if (nome == null || nome.trim().isEmpty()) {
      throw new IllegalArgumentException("Nome do produto não pode estar vazio");
    } else if (preco <= 0) {
      throw new IllegalArgumentException("O preço não pode ser menor ou igual a 0");
    } else if (quantidade == 0) {
      throw new IllegalArgumentException("A quantidade não pode ser 0");
    } else if (produtoRepository.existsByNome(nome)) {
      throw new IllegalStateException("Produto já cadastrado");
    }
    
    return produtoRepository.save(produto);
  }

  public ProdutoModel buscarProduto(Long id) {
   
    return produtoRepository.findById(id).orElse(null);
  }
  
  public List<ProdutoModel> listarTodosProdutos(){
      return produtoRepository.findAll();
  }
  
}
