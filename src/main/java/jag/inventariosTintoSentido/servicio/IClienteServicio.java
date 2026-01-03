package jag.inventariosTintoSentido.servicio;

import jag.inventariosTintoSentido.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    List<Cliente> listarClientes();
    Cliente buscarClientePorId(Integer idCliente);
    Cliente guardarCliente(Cliente cliente);
    void eliminarCliente(Integer idCliente);
}
