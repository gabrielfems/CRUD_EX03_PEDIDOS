package com.gabrielfems.atv.crud.gerenciamento_pedidos.Repository;

import com.gabrielfems.atv.crud.gerenciamento_pedidos.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findById(Long id);

}
