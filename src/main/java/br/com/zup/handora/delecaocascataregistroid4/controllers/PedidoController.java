package br.com.zup.handora.delecaocascataregistroid4.controllers;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.delecaocascataregistroid4.models.Pedido;
import br.com.zup.handora.delecaocascataregistroid4.repositories.PedidoRepository;

@RestController
@RequestMapping(PedidoController.BASE_URI)
public class PedidoController {

    public final static String BASE_URI = "/pedidos";

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                                        .orElseThrow(
                                            () -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND,
                                                "Não existe um pedido com o id informado."
                                            )
                                        );

        pedidoRepository.delete(pedido);

        return ResponseEntity.noContent().build();
    }

}
