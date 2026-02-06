package net.javaguides.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

public record PedidoRequestDTO(
        @NotBlank(message = "El nombre del cliente es obligatorio")
        String nombreCliente,

        @NotBlank(message = "La dirección de envío es obligatoria")
        String direccionEnvio,

        @NotNull(message = "El monto total es obligatorio")
        @Positive(message = "El monto total debe ser mayor a cero")
        BigDecimal montoTotal,

        @NotNull(message = "El ID del estatus es obligatorio")
        Integer estatusId,

        @NotEmpty(message = "El pedido debe contener al menos un item")
        @Valid
        List<ItemPedidoDTO> items
) {}