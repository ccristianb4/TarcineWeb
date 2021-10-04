/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.software.ingenieria.tarcine.controlador;

import com.software.ingenieria.tarcine.modelo.Tarjeta;
import com.software.ingenieria.tarcine.modelo.TarjetaCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristian Castro
 */
public class ControladorTarjeta extends HttpServlet {
    private int ident;
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
        
        HttpSession sesion = request.getSession();
        this.ident = (int)sesion.getAttribute("txtId2");
       // int ident = Integer.parseInt(ident2);
        
        if (t.validarTarjeta(ident)) {
            tar = t.getTarjeta(ident);
        } else {
            tar = new Tarjeta(ident, 0);
            Boolean b = t.CrearTarjeta(tar);
            if (b) {
                System.out.println("se ha creado la tarjeta");
            } else {
                System.out.println("no se ha creado la tarjeta");
            }
        }
        sesion.setAttribute("txtId2", tar.getId());
        sesion.setAttribute("txtCod2", tar.getCod());
        sesion.setAttribute("txtSaldo2", tar.getSaldo());
        
        response.sendRedirect("tarjetaTarcine.jsp");
        //request.getRequestDispatcher("tarjetaTarcine.jsp").forward(request, response);

    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
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
        HttpSession sesion = request.getSession();
        
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
