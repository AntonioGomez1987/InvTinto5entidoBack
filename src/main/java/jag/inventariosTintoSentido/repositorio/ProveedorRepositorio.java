package jag.inventariosTintoSentido.repositorio;

import jag.inventariosTintoSentido.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
}
