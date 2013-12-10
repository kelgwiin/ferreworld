package com.ferreworld.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ferreworld.dao.DBConnector;
import com.ferreworld.logic.CategoriaServer;
import com.ferreworld.model.Categoria;

/**
 * Servlet implementation class ListadoCategoriaServlet
 */
public class ListadoCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoCategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
//		RequestDispatcher rd = 
//				request.getRequestDispatcher("/jsp/categ/list-categorias.jsp");
//		rd.forward(request, response);
		
		try {
			con = (new DBConnector()).openConnection();
			CategoriaServer server = new CategoriaServer(con);
			
			List<Categoria> lista = server.findCategoriaByActivo(true);
			
			//Colcamos la lista disponible para los demas componentes web
			request.setAttribute("lista", lista);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/jsp/categ/list-categorias.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
