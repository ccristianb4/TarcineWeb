/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.software.ingenieria.tarcine.controlador;

import com.software.ingenieria.tarcine.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.font.TrueTypeFont;

/**
 *
 * @author Cristian Castro
 */
public class CotroladorLogin extends HttpServlet {

    UsuarioCrud c = new UsuarioCrud();
    Usuario u = new Usuario();

    int r;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("iniciar");
            if (accion.equals("Iniciar Sesion")) {
                System.out.println("hola sdnfjsfjsfd");
                String user = request.getParameter("txtUsuario");
                String pass = request.getParameter("txtContrasena");
                u.setUserName(user);
                u.setPassword(pass);
                r = c.validar(u);
                if (r == 1) {
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("nombre", user);
                    sesion.setAttribute("txtcorreo", c.getCorreo(user));
                    int ident = c.getID(user);
                    sesion.setAttribute("txtId2", ident);
                    sesion.setAttribute("txtNombreC", c.getNombreC(user));
                    sesion.setAttribute("txtPass", pass);
                    System.out.println(ident);
//                try (PrintWriter out = response.getWriter()) {
//                    /* TODO output your page here. You may use following sample code. */
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Servlet prueba</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    //out.println("<h1>Servlet prueba at " + request.getContextPath() + "</h1>");
//                    out.println("</body>");
//                    out.println("<script src=\"js/alertas.js\"></script>");
//                    out.println("</html>");
//                }
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<script src=\"js/alertas.js\"></script>");
                    out.println("</html>");
                    request.getRequestDispatcher("tarcinePrincipal.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.html").forward(request, response);
                }
            }
        }
//l
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
