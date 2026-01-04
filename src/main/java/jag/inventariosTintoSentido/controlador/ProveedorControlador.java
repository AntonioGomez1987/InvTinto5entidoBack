package jag.inventariosTintoSentido.controlador;


import jag.inventariosTintoSentido.excepcion.RecursoNoEncontradoExcepcion;
import jag.inventariosTintoSentido.modelo.Proveedor;
import jag.inventariosTintoSentido.servicio.ProveedorServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/proveedores")
    public Proveedor agregarproveedor(@RequestBody Proveedor proveedor) {
        logger.info("Proveedor agregar: " + proveedor);
        return this.proveedorServicio.guardarProveedor(proveedor);
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable int id){
        Proveedor proveedor = this.proveedorServicio.buscarProveedorPorId(id);
        if (proveedor != null){
            return ResponseEntity.ok(proveedor);
        } else {
            throw new RecursoNoEncontradoExcepcion("Proveedor no encontrado con el id " + id);
        }
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(
            @PathVariable int id,
            @RequestBody Proveedor proveedorRecibido
    ){
        Proveedor proveedor = this.proveedorServicio.buscarProveedorPorId(id);
        proveedor.setCiudadProveedor(proveedorRecibido.getCiudadProveedor());
        proveedor.setNombreProveedor(proveedorRecibido.getNombreProveedor());
        proveedor.setDireccionProveedor(proveedorRecibido.getDireccionProveedor());
        proveedor.setCorreoProveedor(proveedorRecibido.getCorreoProveedor());
        proveedor.setContactoProveedor(proveedorRecibido.getContactoProveedor());
        proveedor.setNitProveedor(proveedorRecibido.getNitProveedor());
        proveedor.setTelefonoProveedor(proveedorRecibido.getTelefonoProveedor());
        proveedor.setDireccionProveedor(proveedorRecibido.getDireccionProveedor());

        // Guardamos la informacion
        this.proveedorServicio.guardarProveedor(proveedor);
        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProveedorPorId(@PathVariable int id){
        Proveedor proveedor =this.proveedorServicio.buscarProveedorPorId(id);
        if (proveedor == null) {
            throw new RecursoNoEncontradoExcepcion("Proveedor no encontrado con el id " + id);
        }
        this.proveedorServicio.eliminarProveedorPorId(proveedor.getIdProveedor());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
