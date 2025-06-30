package CadastroDeProduto.Produto.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import CadastroDeProduto.Produto.Model.ProdutoModel;
import CadastroDeProduto.Produto.Repository.ProdutoRepository;
import CadastroDeProduto.Produto.Service.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/salvar")
    public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody ProdutoModel produto) {

        ProdutoModel salvar = produtoService.salvarProduto(produto);
        if (salvar != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> mostrarProduto(@PathVariable Long id) {

        try {
            ProdutoModel buscar = produtoService.buscarProduto(id);
            if (buscar != null) {

                return ResponseEntity.ok(buscar);
            } else {

                return ResponseEntity.status(404).body("Produto não encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro:");
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {

        Optional<ProdutoModel> deletarProdutos = produtoRepository.findById(id);
        if (deletarProdutos.isPresent()) {
            produtoRepository.deleteById(id);
            System.out.println("Produto deletado");
            return ResponseEntity.ok("Produto deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
   

}
