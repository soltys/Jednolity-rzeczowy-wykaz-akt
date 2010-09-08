package com.urzad.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urzad.util.SymbolInfo;
import com.urzad.util.SymbolReader;
/**
 * Servlet implementation class Symbol
 */
public class Startup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Startup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
		 request.setCharacterEncoding("UTF-16");
		 response.setCharacterEncoding("UTF-16");
		 PrintWriter out = response.getWriter();
	
		 String filePath = "symbol.csv";
		 filePath = getServletContext().getRealPath(filePath);		 
		 SymbolReader sr = new SymbolReader(filePath);
		 
		 out.print(SymbolInfo.toJSONSymbolInfoList(sr.getTopLevel()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
