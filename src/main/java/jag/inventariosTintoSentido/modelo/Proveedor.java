package jag.inventariosTintoSentido.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProveedor;
    Integer nitProveedor;
    String nombreProveedor;
    String contactoProveedor;
    String telefonoProveedor;
    String direccionProveedor;
    String correoProveedor;
    String ciudadProveedor;
    String sitioWebProveedor;
//    String facturaProveedor;
}
