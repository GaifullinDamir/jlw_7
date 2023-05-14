package com.example.jlw_7_1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;

@WebServlet(name = "ServletAppl", urlPatterns = {"/ServletAppl"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    static String ast;
    static boolean trigger;
    static long counter;
    static int cycle;

    static int[][] results;

    public HelloServlet(){
        HelloServlet.ast = "COUNTER =";
        HelloServlet.counter = 0;
        HelloServlet.trigger = false;
        HelloServlet.cycle = 6;
    }

    public int[] GetSumEvenOddNumbers(String args[]) {
        int sumOddNumbers = 0; //переменная-счетчик для нечетных чисел
        int sumEvenNumbers = 0; //переменная-счетчик для нечетных чисел
        for(String strNum : args){
            var intNum = Integer.parseInt(strNum);
            if ( intNum % 2 == 0) {
                sumEvenNumbers += intNum;
            } else {
                sumOddNumbers += intNum;
            }
        }

        return new int[] {sumOddNumbers, sumEvenNumbers};
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Гайфуллин, 4311</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Лаб. раб 7</h1>");

            //=============I
            HelloServlet.counter++;


            out.println("<h3> " + HelloServlet.ast + " " +HelloServlet.counter + "</h3>");
            out.println("<h3> Размер текста таблицы :" + HelloServlet.cycle + "</h3>");

            String[] paramArr = request.getParameterValues("prmArr");
            String prmSize = request.getParameter("size");
            String fullName = request.getParameter("fname");
            String groupNumber = request.getParameter("gnumber");

            out.println("<h2> Студент: " + fullName + "</h2>");
            out.println("<h2> Группа: " +  groupNumber + "</h2>");

            if(prmSize != "") {
                HelloServlet.cycle = Integer.parseInt(prmSize);
            }

            if(HelloServlet.cycle > 1){
                HelloServlet.cycle --;
            }else{
                out.println("<h2>Дальнейшее увеличение не возможно</h2>");
            }

            int[] result = GetSumEvenOddNumbers(paramArr);

            out.println("<h" + HelloServlet.cycle + ">" +
                    "<tr>" + "<td>" + "Sum of odd numbers: " + result[0] +
                            " Sum of even numbers: " + result[1] + "</td>" + "</tr>" +
                    "</table></h" + HelloServlet.cycle + ">");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}