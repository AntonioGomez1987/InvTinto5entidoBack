package jag.inventariosTintoSentido.repositorio;

import jag.inventariosTintoSentido.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
