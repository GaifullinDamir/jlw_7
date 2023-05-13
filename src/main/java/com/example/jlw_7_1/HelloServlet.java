package com.example.jlw_7_1;
//
//import java.io.*;
//
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//public class HelloServlet extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }
//
//    public void destroy() {
//    }
//}

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;

//@WebServlet("/hello")
//public class HelloServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Hello!");
//        printWriter.close();
//    }
//}

@WebServlet(name = "ServletAppl", urlPatterns = {"/ServletAppl"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    static String ast;
    static boolean b;
    static long counter;
    static int cycle;

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */

    public HelloServlet(){
        HelloServlet.ast = "a static var c=";
        HelloServlet.b = false;
        HelloServlet.counter = 0;
        HelloServlet.cycle = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Здесь должны быть ФИО и № группы</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ServletAppl" + request.getServletPath() + "</h1>");
            //=============I

            if (HelloServlet.b) HelloServlet.b = false;
            else HelloServlet.b = true;
            HelloServlet.counter++;
            if(HelloServlet.cycle < 5){
                HelloServlet.cycle ++;
            }else{
                HelloServlet.cycle = 1;
            }

            out.println("<h3> Servlet1.ast + Servlet1.b :" + HelloServlet.ast + HelloServlet.b + "</h3>");
            out.println("<h3> Servlet1.counter : " + HelloServlet.counter + "</h3>");
            out.println("<h3> Servlet1.cycle :" + HelloServlet.cycle + "</h3>");

            String[][] tbl = new String[3][3];
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    tbl[i][j] = Integer.toString(i+1) + "&" + Integer.toString(j+1);
                }
            }

            String prm1 = request.getParameter("prm1");
            String prm2 = request.getParameter("prm2");
            String prm3 = request.getParameter("prm3");


            out.println("<h" + HelloServlet.cycle + "><table border>"+
                    "<tr>" + "<td>" + tbl[0][0] + "</td>" + "<td>prm1=" + prm1 + "</td>" + "<td>1.3</td>" +
                    "<tr>" + "<td>prm2=" + prm2 + "</td>" + "<td>pr2</td>" + "<td>2.3</td>" +
                    "<tr>" + "<td>prm3=" + prm3 + "</td>" + "<td>3.2</td>" + "<td>" + tbl[2][2] + "</td>" +
                    "</tr>"
                    + "</table></h" + HelloServlet.cycle + ">");

            //=============II
            out.println("</body>");
            out.println("</html>");
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