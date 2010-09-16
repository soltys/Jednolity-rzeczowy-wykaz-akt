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
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html"); 
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();
		 String searchLine = request.getParameter("searchLine");
		 if(searchLine == null || searchLine.isEmpty())		 
			 return;
		  
		 String filePath = getServletContext().getRealPath(SymbolReader.getFILENAME());		 
		 SymbolReader sr = new SymbolReader(filePath);		 
		 
		 out.print(SymbolInfo.toJSONSymbolInfoList(sr.findSimilar(searchLine)));
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
