package br.com.crud.crud_api;

import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarporId(Long id) {
        return produtoRepository.findById(id);
    }
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar (Long id){
        produtoRepository.deleteById(id);
    }
}
