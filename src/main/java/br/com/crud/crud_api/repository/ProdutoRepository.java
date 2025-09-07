package br.com.crud.crud_api.repository;

import br.com.crud.crud_api.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
