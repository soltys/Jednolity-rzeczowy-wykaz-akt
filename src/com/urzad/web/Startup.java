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
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 String filePath = getServletContext().getRealPath(SymbolReader.getFILENAME());		 
		 SymbolReader sr = new SymbolReader(filePath);
		 
		 out.print(SymbolInfo.toJSONSymbolInfoList(sr.getTopLevel()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
