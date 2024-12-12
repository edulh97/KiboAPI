package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "detallepedidos")
public class Detallepedido {
    @EmbeddedId
    private DetallepedidoId id;

    @MapsId("idPedido")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_pedido", nullable = false)
    private com.example.demo.model.Pedido idPedido;

    @MapsId("idProducto")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_producto", nullable = false)
    private com.example.demo.model.Producto idProducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    public DetallepedidoId getId() {
        return id;
    }

    public void setId(DetallepedidoId id) {
        this.id = id;
    }

    public com.example.demo.model.Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(com.example.demo.model.Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public com.example.demo.model.Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(com.example.demo.model.Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

}