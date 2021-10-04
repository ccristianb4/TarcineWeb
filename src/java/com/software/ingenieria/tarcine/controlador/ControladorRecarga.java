/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.software.ingenieria.tarcine.controlador;

import com.software.ingenieria.tarcine.modelo.Tarjeta;
import com.software.ingenieria.tarcine.modelo.TarjetaCRUD;
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
public class ControladorRecarga extends HttpServlet {

    TarjetaCRUD t = new TarjetaCRUD();
    Tarjeta tar;

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
        String accion = request.getParameter("Recargar");
        if (accion.equals("Recargar")) {
            HttpSession sesion = request.getSession();
            System.out.println(sesion.getAttribute("txtId2"));
            int valor = Integer.parseInt(request.getParameter("txtValor"));
            String cod = String.valueOf(sesion.getAttribute("txtCod2"));
            boolean n = t.recargarTarjeta(cod, valor);
            if (n) {
                System.out.println("recarga exitosa");
            } else {
                System.out.println("recarga fallida");
            }
            int id = Integer.parseInt(String.valueOf(sesion.getAttribute("txtId2")));
            tar = t.getTarjeta(id);
            sesion.setAttribute("txtId2", tar.getId());
            sesion.setAttribute("txtCod2", tar.getCod());
            sesion.setAttribute("txtSaldo2", tar.getSaldo());
            response.sendRedirect("tarjetaTarcine.jsp");
        }
        // try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */

 /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRecarga</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRecarga at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        //}
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
