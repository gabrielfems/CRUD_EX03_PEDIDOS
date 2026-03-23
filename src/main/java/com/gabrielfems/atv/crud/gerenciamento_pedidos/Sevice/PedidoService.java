package com.gabrielfems.atv.crud.gerenciamento_pedidos.Sevice;

import com.gabrielfems.atv.crud.gerenciamento_pedidos.Entity.Pedido;
import com.gabrielfems.atv.crud.gerenciamento_pedidos.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> exibePedido(Long id) {
        return pedidoRepository.findById(id);
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
