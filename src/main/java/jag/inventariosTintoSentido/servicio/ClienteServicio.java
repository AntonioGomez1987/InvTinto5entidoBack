package jag.inventariosTintoSentido.servicio;

import jag.inventariosTintoSentido.modelo.Cliente;
import jag.inventariosTintoSentido.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return this.clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        Cliente cliente = this.clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return this.clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer idCliente) {
        this.clienteRepositorio.deleteById(idCliente);
    }
}
