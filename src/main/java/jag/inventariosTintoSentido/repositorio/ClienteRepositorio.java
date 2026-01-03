package jag.inventariosTintoSentido.repositorio;

import jag.inventariosTintoSentido.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
