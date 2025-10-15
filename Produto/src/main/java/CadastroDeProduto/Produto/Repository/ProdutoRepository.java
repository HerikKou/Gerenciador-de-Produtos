package CadastroDeProduto.Produto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import CadastroDeProduto.Produto.Model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNome(String nome);

    boolean existsByNome(String nome);
}
