package CadastroDeProduto.Produto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import CadastroDeProduto.Produto.Model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNome(String nome);
 
    Optional<ProdutoModel> findById(long id);
    Optional<ProdutoModel> deleteById(long id);

    boolean existsByNome(String nome);
    boolean existsById(long id);
}
