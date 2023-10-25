package TestEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.*;

public class TestProductos {

	public static void main(String[] args) {
		EntityManagerFactory facto = Persistence.createEntityManagerFactory("LPIIFloresTambraccCL2");
		EntityManager emanager = facto.createEntityManager();
			
		emanager.getTransaction().begin();
		TblProductocl2 producto = new TblProductocl2();
			
		producto.setNombrecl2("zapato");
		producto.setPrecioventacl2(12.30);
		producto.setPreciocompcl2(14.20);
		producto.setEstadocl2("grande");
		producto.setDescripcl2("talla 43");
		
		emanager.persist(producto);
		System.out.println("Dato(s) registrado(s)");
		emanager.getTransaction().commit();
		emanager.close();

	}
}
