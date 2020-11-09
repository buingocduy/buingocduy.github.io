/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.PD;

import IO.PD.InsertDPIO;
import entity.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BND6699
 */
@WebServlet(name = "InsertDPControl", urlPatterns = {"/InsertDPControl"})
public class InsertDPControl extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");         
        HttpSession session = request.getSession();
        Product pd = null;
        
        
        String id = request.getParameter("id"); //lấy của netbeans
        String tensp = request.getParameter("name"); //lấy của netbeans
        String gia = request.getParameter("price"); //lấy của netbeans
        String hinhanh = request.getParameter("image"); //lấy của netbeans
        String kichthuoc = request.getParameter("LWH"); //lấy của netbeans
        
        String chieucaoyen = request.getParameter("seat"); //lấy của netbeans
        String sizebanh = request.getParameter("tire"); //lấy của netbeans
        String engine = request.getParameter("engine"); //lấy của netbeans
        String CC = request.getParameter("cc"); //lấy của netbeans
        String congsuat = request.getParameter("power"); //lấy của netbeans
        
        String CCnhot = request.getParameter("oil"); //lấy của netbeans
        String CCxang = request.getParameter("gasoline"); //lấy của netbeans
        String phanh = request.getParameter("brake"); //lấy của netbeans
        String gear = request.getParameter("gearbox"); //lấy của netbeans
        
        InsertDPIO insertdpIO = new InsertDPIO(); // khai báo register
        
        if(session.getAttribute("user1") != null){
        pd = insertdpIO.checkInsert(id, tensp, gia, hinhanh, kichthuoc, chieucaoyen, sizebanh, engine, CC, congsuat, CCnhot, CCxang, phanh, gear); // check a có null không
       
        if(pd != null)
        {   
            response.sendRedirect("IPD.jsp");               
        }else{            
           response.sendRedirect("product.jsp");  
        }
        }else{
           response.sendRedirect("Login.html");
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
