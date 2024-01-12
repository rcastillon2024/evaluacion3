package Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.LoginDao;

/**
 * Servlet implementation class ValidadorServlet
 */
@WebServlet("/ValidadorServlet")
public class ValidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String usuario, password, msg="";
		
		//1: recibir parametro
		usuario = request.getParameter("usuario");
		password = request.getParameter("password");
		
		//2: validar
		try {
			if(LoginDao.validar(usuario, password)>0) {
				msg = "Usuario y Contraseña correctos";
			}else {
				msg = "Revise su Usuario o Contraseña";
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		//3: ejecuta logica de Negocio
		msg = msg.toUpperCase();
		
		//4: selccionar proxima vista
		RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
		
		//5: preparar los datos para vista seleccionada
		request.setAttribute("mensaje",msg);
		
		//6: despachar
		despachador.forward(request, response);
		
		
	
	}

}
