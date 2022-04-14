package br.com.zup.handora.delecaocascataregistroid4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.delecaocascataregistroid4.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
