/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.exemplo.primeira.aula;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "CalculadoraController", urlPatterns = {"/calculadora"})
public class CalculadoraController extends HttpServlet {

    private Calculadora calculadora = new Calculadora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // tratar a rquisicao
        // converter os valores String
        // executar a classe de servico
        // exibir o resultado 
        String primeiro = convertToString(request, "primeiro");
        String segundo = convertToString(request, "segundo");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Soma:" + somar(primeiro, segundo) + "</h1>");
            out.println("<h1>Substração:" + subtrair(primeiro, segundo) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private String convertToString(HttpServletRequest request,
            String parametro) {
        return request.getParameter(parametro);
    }

    private int convertToInt(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Erro na conversão");
        }
        return 0;
    }

    private int somar(String primeiro, String segundo) {
        int primeiroValor = convertToInt(primeiro);
        int segundoValor = convertToInt(segundo);
        return this.calculadora.somar(primeiroValor, segundoValor);
    }

    private int subtrair(String primeiro, String segundo) {
        int primeiroValor = convertToInt(primeiro);
        int segundoValor = convertToInt(segundo);
        return this.calculadora.subtrair(primeiroValor, segundoValor);
    }

}
