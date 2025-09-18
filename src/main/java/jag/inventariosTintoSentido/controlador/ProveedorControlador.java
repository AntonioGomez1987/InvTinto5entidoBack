package jag.inventariosTintoSentido.controlador;


import jag.inventariosTintoSentido.modelo.Proveedor;
import jag.inventariosTintoSentido.servicio.ProveedorServicio;
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
public class ProveedorControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProveedorControlador.class);

    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/proveedores")
    public List<Proveedor> obtenerProveedores() {
        List<Proveedor> proveedores  = this.proveedorServicio.listarProveedores();
        logger.info("Proveedores Obtenidos" + proveedores);
        proveedores.forEach(proveedor -> logger.info(proveedor.toString()));
        return proveedores;
    }
}
