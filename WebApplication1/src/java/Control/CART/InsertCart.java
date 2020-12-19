/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.CART;

import IO.CART.InserCartIO;
import entity.Cart;
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
@WebServlet(name = "InsertCart", urlPatterns = {"/InsertCart"})
public class InsertCart extends HttpServlet {

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
        Cart c = null;
         
        String mua = request.getParameter("mua"); //lấy của netbeans
        String username = request.getParameter("user"); //lấy của netbeans
        String tensp = request.getParameter("tensp"); //lấy của netbeans
        String soluongmua = request.getParameter("soluongmua"); //lấy của netbeans
        String tonggia = request.getParameter("tongtien"); //lấy của netbeans
    
        InserCartIO insercartIO = new InserCartIO(); // khai báo register
        
        c = insercartIO.checkCart(username, tensp, soluongmua, tonggia); // check a có null không
       
       
        if(c != null)
        {      
            response.sendRedirect("cart.jsp");  
        }else
        {
            if(mua != null)
            {   
                if(session.getAttribute("user") != null && session.getAttribute("Orders") != null) 
                    {
                        session.removeAttribute("Orders");              
                        response.sendRedirect("cart.jsp");
                    } 
            }          
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
