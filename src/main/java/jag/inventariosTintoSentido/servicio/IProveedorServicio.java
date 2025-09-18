package jag.inventariosTintoSentido.servicio;

import jag.inventariosTintoSentido.modelo.Proveedor;

import java.util.List;

public interface IProveedorServicio {
    List<Proveedor> listarProveedores();
    Proveedor buscarProveedorPorId(Integer idProveedor);
    Proveedor guardarProveedor(Proveedor proveedor);
    void eliminarProveedor(Integer idProveedor);
}
