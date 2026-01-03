package jag.inventariosTintoSentido.controlador;

import jag.inventariosTintoSentido.modelo.Cliente;
import jag.inventariosTintoSentido.servicio.ClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventarioTintoSentido-app")
@CrossOrigin(value = "http://localhost:4200")
public class ClienteControlador {
    private static final Logger logger = LoggerFactory.getLogger(ClienteControlador.class);

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = this.clienteServicio.listarClientes();
        logger.info("Clientes Obtenidos: ");
        clientes.forEach(cliente -> logger.info(cliente.toString()));
        return clientes;
    }

}
