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
 * Servlet implementation class GetShortTree
 */
public class GetShortTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShortTree() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String ifNullReturnEmptyString(String str) {
    	if(str == null )
    		return "";
    	else
    		return str;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html"); 
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();
		 String col1 = ifNullReturnEmptyString(request.getParameter("col1"));
		 String col2 = ifNullReturnEmptyString(request.getParameter("col2"));
		 String col3 = ifNullReturnEmptyString(request.getParameter("col3"));
		 String col4 = ifNullReturnEmptyString(request.getParameter("col4"));
		 String col5 = ifNullReturnEmptyString(request.getParameter("col5"));
		               
		 SymbolInfo element = new SymbolInfo();
		 element.columns[0] = col1;
		 element.columns[1] = col2;
		 element.columns[2] = col3;
		 element.columns[3] = col4;
		 element.columns[4] = col5;
		 
		 String filePath = "symbol.csv";
		 filePath = getServletContext().getRealPath(filePath);		 
		 SymbolReader sr = new SymbolReader(filePath);
		 
		 out.print(
				 SymbolInfo.toJSONSymbolInfoList(
						 sr.getShortTree(element)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
