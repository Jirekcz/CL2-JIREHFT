package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProductoable;
import model.TblProductocl2;;

public class ClassCrudProdImp implements IProductoable{

	@Override
	public void RegistrarProducto(TblProductocl2 tblpro) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LPIIFloresTambraccCL2");
		EntityManager emanager = factory.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tblpro);
		emanager.getTransaction().commit();
		emanager.close();
		
	}

	@Override
	public List<TblProductocl2> ListadoProducto() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LPIIFloresTambraccCL2");
		EntityManager emanager = factory.createEntityManager();
		emanager.getTransaction().begin();
		List<TblProductocl2> ListaProducto = emanager.createNativeQuery("select * from tbl_productocl2", TblProductocl2.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		//
		return ListaProducto;
	}


}
