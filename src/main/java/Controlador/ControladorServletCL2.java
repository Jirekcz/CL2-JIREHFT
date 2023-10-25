package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClassCrudProdImp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorServletCL2
 */
public class ControladorServletCL2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServletCL2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("/GestionProducto.jsp").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		double precioven = Double.parseDouble(request.getParameter("precioven"));
		double precio = Double.parseDouble(request.getParameter("preciocomp"));
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descrip");
		//
		TblProductocl2 tblpro = new TblProductocl2();
		ClassCrudProdImp crud = new ClassCrudProdImp();
		//
		tblpro.setNombrecl2(nombre);
		tblpro.setPrecioventacl2(precioven);
		tblpro.setPreciocompcl2(precio);
		tblpro.setEstadocl2(estado);
		tblpro.setDescripcl2(descripcion);
		//
		crud.RegistrarProducto(tblpro);
		List<TblProductocl2> listadoprod = crud.ListadoProducto();
		request.setAttribute("listado", listadoprod);
		request.getRequestDispatcher("/GestionProducto.jsp").forward(request, response);
	}

}
