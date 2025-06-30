package CadastroDeProduto.Produto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CadastroDeProduto.Produto.Model.ProdutoModel;
import CadastroDeProduto.Produto.Repository.ProdutoRepository;

@Service
public class ProdutoService {
  @Autowired
  private ProdutoRepository produtoRepository;

  public ProdutoModel salvarProduto(ProdutoModel produto) {

    String nome = produto.getNome();
    double preco = produto.getPreco();
    int quantidade = produto.getQuantidade();

    if (nome.trim().isEmpty() || nome == null) {
      System.out.println("Nome do produto não pode estar vazio");
    } else if (preco <= 0) {
      System.out.println("O preço não pode ser menor ou igual a 0");
    } else if (quantidade == 0) {
      System.out.println("A quantidade não pode ser 0");
    } else if (produtoRepository.existsByNome(nome)) {

      System.out.println("Produto já cadastrado");
    } else {
      System.out.println("Nome:" + nome);
      System.out.println("Preço:" + preco);
      System.out.println("Qauntidade:" + quantidade);
      produtoRepository.save(produto);

      System.out.println("Produto cadastrado com sucesso");
      return produto;
    }
    return null;

  }

  public ProdutoModel buscarProduto(Long id) {

    if (produtoRepository.existsById(id)) {
      System.out.println("Produto encontrado");
      return produtoRepository.findById(id).orElse(null);

    }

    else {

      return null;
    }

  }
  
}
