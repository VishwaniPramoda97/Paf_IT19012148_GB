package com;

import model.ResearchManagement;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResearchAPI
 */
@WebServlet("/ResearchAPI")
public class ResearchAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResearchManagement research = new ResearchManagement();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResearchAPI() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static Map getParasMap(HttpServletRequest request)
    {
	    Map<String, String> map = new HashMap<String, String>();
	    try
	    {
		    Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
		    String queryString = scanner.hasNext() ?
		    scanner.useDelimiter("\\A").next() : "";
		    scanner.close();
		    String[] params = queryString.split("&");
		    for (String param : params)
		    {
		    	String[] p = param.split("=");
		    	map.put(p[0], p[1]);
		    }
		}
	    catch (Exception e)
	    {		    
	    	
	    }
		return map;
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
		String output = research.insertResearch(request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("projectTitle"),
				request.getParameter("totalCost"),
				request.getParameter("duration"),
				request.getParameter("catogary"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = research.updateResearch(paras.get("rid").toString(),
				paras.get("name").toString(),
				paras.get("email").toString(),
				paras.get("projectTitle").toString(),
				paras.get("totalCost").toString(),
				paras.get("duration").toString(),
				paras.get("catogary").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = research.deleteResearch(paras.get("rid").toString());
		response.getWriter().write(output);
	}

}
