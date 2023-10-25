package Controlador;

import java.io.IOException;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.TblUsuariocl2;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("user");
        String password = request.getParameter("password");

        try {
        	EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPIIFloresTambraccCL2");
			EntityManager entimanaUsuario=conex.createEntityManager();
			Query consulta=entimanaUsuario.createNativeQuery("select * from TblUsuario u where u.usuariocl2=:x and u.passwordcl2=:y",TblUsuariocl2.class);
			consulta.setParameter("x",username);
            consulta.setParameter("y",password);
            TblUsuariocl2 u;

            if (username.equals("user") && password.equals("password")) {
                response.sendRedirect("GestionProducto.jsp");
            } else {
                response.sendRedirect("GestionProducto.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Logueo.jsp?error=true");
        }
        
   }

}
