package jag.inventariosTintoSentido.servicio;

import jag.inventariosTintoSentido.modelo.Proveedor;
import jag.inventariosTintoSentido.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio  implements IProveedorServicio{

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Override
    public List<Proveedor> listarProveedores() {
        return this.proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor buscarProveedorPorId(Integer idProveedor) {
        Proveedor proveedor = this.proveedorRepositorio.findById(idProveedor).orElse(null);
        return proveedor;
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return this.proveedorRepositorio.save(proveedor);
    }

    @Override
    public void eliminarProveedorPorId(Integer idProveedor) {
        this.proveedorRepositorio.deleteById(idProveedor);
    }
}
