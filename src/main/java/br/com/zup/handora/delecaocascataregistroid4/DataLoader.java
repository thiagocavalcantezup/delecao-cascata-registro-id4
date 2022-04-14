package br.com.zup.handora.delecaocascataregistroid4;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.handora.delecaocascataregistroid4.models.ItemDePedido;
import br.com.zup.handora.delecaocascataregistroid4.models.Pedido;
import br.com.zup.handora.delecaocascataregistroid4.models.Produto;
import br.com.zup.handora.delecaocascataregistroid4.repositories.ItemDePedidoRepository;
import br.com.zup.handora.delecaocascataregistroid4.repositories.PedidoRepository;
import br.com.zup.handora.delecaocascataregistroid4.repositories.ProdutoRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final PedidoRepository pedidoRepository;
    private final ItemDePedidoRepository itemDepedidoRepository;
    private final ProdutoRepository produtoRepository;

    public DataLoader(PedidoRepository pedidoRepository,
                      ItemDePedidoRepository itemDepedidoRepository,
                      ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.itemDepedidoRepository = itemDepedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Pedido pedido1 = new Pedido("123", new BigDecimal("100.0"));
        Pedido pedido2 = new Pedido("124", new BigDecimal("300.0"));

        pedido1 = pedidoRepository.save(pedido1);
        pedido2 = pedidoRepository.save(pedido2);

        Produto produto1 = new Produto("Refrigerante");
        Produto produto2 = new Produto("Cerveja");
        Produto produto3 = new Produto("Amendoim");
        Produto produto4 = new Produto("Biscoito");

        produto1 = produtoRepository.save(produto1);
        produto2 = produtoRepository.save(produto2);
        produto3 = produtoRepository.save(produto3);
        produto4 = produtoRepository.save(produto4);

        ItemDePedido item1 = new ItemDePedido(20);
        ItemDePedido item2 = new ItemDePedido(25);
        ItemDePedido item3 = new ItemDePedido(30);
        ItemDePedido item4 = new ItemDePedido(35);

        item1.associar(produto1);
        item2.associar(produto2);
        item3.associar(produto3);
        item4.associar(produto4);

        item1 = itemDepedidoRepository.save(item1);
        item2 = itemDepedidoRepository.save(item2);
        item3 = itemDepedidoRepository.save(item3);
        item4 = itemDepedidoRepository.save(item4);

        pedido1.adicionar(item1);
        pedido1.adicionar(item3);

        pedido2.adicionar(item2);
        pedido2.adicionar(item4);

        pedido1 = pedidoRepository.save(pedido1);
        pedido2 = pedidoRepository.save(pedido2);
    }

}
