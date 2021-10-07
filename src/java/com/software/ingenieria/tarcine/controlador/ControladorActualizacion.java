/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.software.ingenieria.tarcine.controlador;

import com.software.ingenieria.tarcine.modelo.Usuario;
import com.software.ingenieria.tarcine.modelo.UsuarioCrud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristian Castro
 */
public class ControladorActualizacion extends HttpServlet {
    Usuario usu;
    UsuarioCrud crud = new UsuarioCrud();
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
        HttpSession session = request.getSession();
        String accion = request.getParameter("Actualizar");
        if (accion.equals("Actualizar")) {
            String nombreC = request.getParameter("txtNombreA");
            String userName = request.getParameter("txtUserNameA");
            String email = request.getParameter("txtCorreoA");
            String pass = request.getParameter("txtContrasenaA");
            usu = new Usuario(nombreC, userName, email, pass);
            int i = Integer.parseInt(String.valueOf(session.getAttribute("txtId2")));
            usu.setIden(i);
            System.out.println("i : "+usu.getIden());
            crud.actualizarDatos(usu);
            session.setAttribute("txtId2", i);
            session.setAttribute("txtNombreC", nombreC);
            session.setAttribute("nombre", userName);
            session.setAttribute("txtcorreo", email);
            session.setAttribute("txtPass", pass);
            response.sendRedirect("tarcinePrincipal.jsp");
        }

        //response.sendRedirect("actualizarDatos.jsp");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControladorActualizacion</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControladorActualizacion at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
