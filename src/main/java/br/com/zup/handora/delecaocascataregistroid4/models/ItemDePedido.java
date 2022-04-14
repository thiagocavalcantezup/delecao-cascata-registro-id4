package br.com.zup.handora.delecaocascataregistroid4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "itens_de_pedido")
public class ItemDePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    private Produto produto;

    @Column(nullable = false)
    @Positive
    private Integer quantidade;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public ItemDePedido() {}

    public ItemDePedido(@Positive Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void associar(Produto produto) {
        this.produto = produto;
    }

}
