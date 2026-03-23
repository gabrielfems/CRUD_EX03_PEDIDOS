package com.gabrielfems.atv.crud.gerenciamento_pedidos.Controller;

import com.gabrielfems.atv.crud.gerenciamento_pedidos.Entity.Pedido;
import com.gabrielfems.atv.crud.gerenciamento_pedidos.Sevice.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> exibePedido(@PathVariable Long id){
        Optional<Pedido> pedido = pedidoService.exibePedido(id);
        return ResponseEntity.ok().body(pedido.get());
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido request = pedidoService.criarPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletarPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
        return ResponseEntity.noContent().build();
    }
}
