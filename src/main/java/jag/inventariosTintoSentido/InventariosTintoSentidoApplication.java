package jag.inventariosTintoSentido;

import jag.inventariosTintoSentido.modelo.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventariosTintoSentidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventariosTintoSentidoApplication.class, args);

//		// Prueba de lombok: Crear un objeto Producto y usar el toString()
//		Producto producto = new Producto();
//		producto.setIdProducto(1);
//		producto.setDescripcionProducto("Cafe Castillo");
//		producto.setPrecioProducto(25000.0);
//		producto.setExistenciaProducto(50);
//
//		// Imprimir el objeto usando el toString() de lombok
//		System.out.println(producto);
//
//		// Probar los getters y setters generados por lombok
//		producto.setDescripcionProducto("Tostadora Prisma");
//		producto.setPrecioProducto(98000.0);
//		System.out.println("Descripcion nueva: " + producto.getDescripcionProducto());
//		System.out.println("Precio Nuevo: " + producto.getPrecioProducto());

	}

}
