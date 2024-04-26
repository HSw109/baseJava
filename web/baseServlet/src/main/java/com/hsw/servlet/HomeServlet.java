package com.hsw.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/home/index") //Setting route
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String s = req.getParameter("name");
        String m = "";
        OracleConn oracle = new OracleConn();
        Connection conn = null;
		try {
			conn = oracle.makeConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String query = "SELECT * FROM EMPLOYEES";
		try {
			m = oracle.getData(conn, query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m);
        req.setAttribute("message", "Hello, Have a good day! " + s + "\n" + m);
        req.getRequestDispatcher("/views/index.jsp").forward(req, res);
    

    }
}
