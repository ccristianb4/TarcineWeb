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

/**
 *
 * @author Cristian Castro
 */
public class ControladorRegister extends HttpServlet {

    UsuarioCrud c = new UsuarioCrud();
    Usuario u = new Usuario();
    boolean v;

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
        PrintWriter out = response.getWriter();

        String boton = request.getParameter("btnRegistrar");

        if (boton.equals("Registrar")) {
            u.setNombre(request.getParameter("txtNombre"));
            u.setUserName(request.getParameter("txtUserName"));
            u.setCorreo(request.getParameter("txtCorreo"));
            u.setPassword(request.getParameter("txtContrasena"));
            v = c.agregar(u);
            if (v) {
                request.getRequestDispatcher("index.html").forward(request, response);
            } else {
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
        /* TODO output your page here. You may use following sample code. */
 /*
        u.setNombre(request.getParameter("txtNombre"));
        u.setUserName(request.getParameter("txtUserName"));
        u.setCorreo(request.getParameter("txtCorreo"));
        u.setPassword(request.getParameter("txtContrasena"));*/

 /*out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<script>");
        boolean v = c.agregar(u);
        if(v){
            out.print("alert('el usuario de ha registrado con exito')");
            out.print("location='index.html'");
        }else{
            out.print("alert('el usuario no se ha registrado con exito')");
            out.print("location='index.html'");
        }
        
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");*/
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
