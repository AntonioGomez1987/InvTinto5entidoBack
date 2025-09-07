package jag.inventariosTintoSentido.servicio;

import jag.inventariosTintoSentido.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> listarProductos();
    Producto buscarProductoPorId(Integer idProducto);
    void guardarProducto(Producto producto);
    void eliminarProducto(Integer idProducto);
}
