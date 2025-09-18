package jag.inventariosTintoSentido.controlador;

import jag.inventariosTintoSentido.excepcion.RecursoNoEncontradoExcepcion;
import jag.inventariosTintoSentido.modelo.Producto;
import jag.inventariosTintoSentido.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto) {
        logger.info("Producto agregar: " + producto);
        return this.productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id
    ){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto != null){
            return ResponseEntity.ok(producto);
        } else{
            throw new RecursoNoEncontradoExcepcion("Nose encontro producto con el id: " + id);
        }
    }


}
