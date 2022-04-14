package br.com.zup.handora.delecaocascataregistroid4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.delecaocascataregistroid4.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
