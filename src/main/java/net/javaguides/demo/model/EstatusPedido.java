package net.javaguides.demo.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "cat_estatus_pedido")
public class EstatusPedido {
    @Id
    private Integer estatusId;

    @Column(unique = true, nullable = false, length = 50)
    private String descripcion;
}

