package net.javaguides.demo.repository;

import net.javaguides.demo.model.EstatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatusRepository extends JpaRepository<EstatusPedido, Integer> {
    // No necesitas agregar métodos manuales para lo que buscas
}