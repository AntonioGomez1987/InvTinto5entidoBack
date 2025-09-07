package jag.inventariosTintoSentido.controlador;

import jag.inventariosTintoSentido.modelo.Producto;
import jag.inventariosTintoSentido.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventarioTintoSentido-app") // http://localhost:8080/inventarioTintoSentido-app
@CrossOrigin(value = "http://localhost:4200") // Puerto por default de Angular
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos") //http:localhost:8080/inventarioTintoSentido-app/productos
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos Obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

}
