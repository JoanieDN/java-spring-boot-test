package net.javaguides.demo.service;


import lombok.RequiredArgsConstructor;
import net.javaguides.demo.dto.PedidoRequestDTO;
import net.javaguides.demo.model.EstatusPedido;
import net.javaguides.demo.model.ItemPedido;
import net.javaguides.demo.model.Pedido;
import net.javaguides.demo.repository.EstatusRepository;
import net.javaguides.demo.repository.ItemPedidoRepository;
import net.javaguides.demo.repository.PedidoRepository;
import net.javaguides.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final ProductoRepository productoRepository;
    private final EstatusRepository estatusRepository;


    @Transactional
    public Pedido crearPedidoCompleto(PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setNombreCliente(dto.nombreCliente());
        pedido.setDireccionEnvio(dto.direccionEnvio());
        pedido.setMontoTotal(dto.montoTotal());

        EstatusPedido estatus = estatusRepository.getReferenceById(dto.estatusId());
        pedido.setEstatus(estatus);


        Pedido pedidoGuardado = pedidoRepository.save(pedido);


        List<ItemPedido> items = dto.items().stream().map(itemDto -> {
            ItemPedido item = new ItemPedido();
            item.setPedido(pedidoGuardado);
            item.setProducto(productoRepository.getReferenceById(itemDto.productoId()));
            item.setCantidad(itemDto.cantidad());

            return item;
        }).toList();


        itemPedidoRepository.saveAll(items);

        return pedidoGuardado;
    }
}