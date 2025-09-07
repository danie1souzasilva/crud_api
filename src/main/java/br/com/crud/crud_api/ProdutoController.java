package br.com.crud.crud_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    public final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return produtoService.buscarporId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.buscarporId(id)
                .map(p ->{produto.setId(id);
            return ResponseEntity.ok(produtoService.salvar(produto));
    })
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return produtoService.buscarporId(id)
                .map(p ->{
                    produtoService.deletar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
