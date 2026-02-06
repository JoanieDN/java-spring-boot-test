package net.javaguides.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.javaguides.demo.dto.PedidoRequestDTO;
import net.javaguides.demo.model.Pedido;
import net.javaguides.demo.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/pedidos/")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping("crearPedido")
    public ResponseEntity<Pedido> crearPedido(@Valid @RequestBody PedidoRequestDTO request) {
        Pedido nuevoPedido = pedidoService.crearPedidoCompleto(request);

        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }
}