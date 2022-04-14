package br.com.zup.handora.delecaocascataregistroid4.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    @Positive
    private BigDecimal total;

    @Column(nullable = false)
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<ItemDePedido> itens = new HashSet<>();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Pedido() {}

    public Pedido(String numero, @Positive BigDecimal total) {
        this.numero = numero;
        this.total = total;
    }

    public void adicionar(ItemDePedido itemDePedido) {
        itens.add(itemDePedido);
    }

    public Long getId() {
        return id;
    }

}
