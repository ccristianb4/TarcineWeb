/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.software.ingenieria.tarcine.controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.software.ingenieria.tarcine.modelo.Usuario;
import com.software.ingenieria.tarcine.modelo.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author Cristian Castro
 */
@WebServlet(name = "facturaPDF", urlPatterns = {"/factura"})
public class facturaPDF extends HttpServlet {
    UsuarioCrud crud = new UsuarioCrud();
    TarjetaCRUD crudt = new TarjetaCRUD();
    
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
        response.setContentType("application/pdf");
        OutputStream salida = response.getOutputStream();
        HttpSession sesion = request.getSession();
        int i = Integer.parseInt(String.valueOf(sesion.getAttribute("txtId2")));
        Usuario usu = crud.getUsuario(i);
        Tarjeta tar = crudt.getTarjeta(i);
        crudt.reserva(i);
        long saldo = crudt.getSaldo(tar.getCod());
        sesion.setAttribute("txtSaldo2", saldo);
        
        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, salida);
            documento.open();
            Paragraph  par1 = new Paragraph();
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
            par1.add(new Phrase("Factura de reserva",fontTitulo));
            par1.setAlignment(Element.ALIGN_CENTER);
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));
            documento.add(par1);
            
            String factura = "Datos Personales"+ "\n\n id : "+i+"\n nombre Completo : "+usu.getNombre()+"\n UserName : "+usu.getUserName()
                    +"\n Correo Electronico : "+usu.getCorreo()+
                    "\n\n Datos Tarjeta Tarcine"+"\n\n Codigo Tarjeta : "+tar.getCod()+"\n Saldo : "+saldo;
            Paragraph  par2 = new Paragraph();
            Font fontDescripcion = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
            par2.add(new Phrase(factura,fontDescripcion));
            par2.setAlignment(Element.ALIGN_JUSTIFIED);
            par2.add(new Phrase(Chunk.NEWLINE));
            par2.add(new Phrase(Chunk.NEWLINE));
            documento.add(par2);
            documento.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
