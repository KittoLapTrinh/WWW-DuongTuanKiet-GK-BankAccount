package com.example.duongtuankiet;

import com.example.duongtuankiet.models.Account;
import com.example.duongtuankiet.services.AccountService;
import com.example.duongtuankiet.services.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "pageServlet", value = "/page")
public class PageServlet extends HttpServlet {
    private String message;
    public void init(){
        message = "Hello world!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try{
            String action = req.getParameter("action");
            if(action == null){
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action){
                case "home":{
                    PrintWriter out = resp.getWriter();
                    out.println("<html><body>");
                    out.println("<h1>Home</h1>");
                    out.println("</body></html>");
                }
                case "account":
                    handleActionAccount(req, resp);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void handleActionAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService service = new AccountServiceImpl();
        List<Account> accounts = service.getAllAccount();
        req.setAttribute("accounts", accounts);
        String page = "/account/account.jsp";
        forwardToPage(page, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if(action == null){
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h1>"+message+"</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action){
                case "account":
                    handleInsertCandidate(req, resp);
                    break;
                case "filterAmount":
                    handleFilterAmount(req, resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void handleFilterAmount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy tham số từ yêu cầu
        double minAmount = Double.parseDouble(req.getParameter("minAmount"));
        double maxAmount = Double.parseDouble(req.getParameter("maxAmount"));

        // Sử dụng AccountService để lọc tài khoản theo amount
        AccountService service = new AccountServiceImpl();
        List<Account> accounts = service.filterAmount(minAmount, maxAmount);

        // Lưu danh sách tài khoản vào thuộc tính yêu cầu
        req.setAttribute("accounts", accounts);

        // Chuyển hướng đến trang hiển thị tài khoản
        String page = "/account/account.jsp"; // Đảm bảo trang này có thể hiển thị danh sách tài khoản
        forwardToPage(page, req, resp);
    }

    private void handleInsertCandidate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String accountNumber = req.getParameter("accountNumber");
        String ownerName = req.getParameter("ownerName");
        String cardNumber = req.getParameter("cardNumber");
        String ownerAddress = req.getParameter("ownerAddress");
        double amount = Double.parseDouble(req.getParameter("amount"));

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setOwnerName(ownerName);
        account.setCardNumber(cardNumber);
        account.setOwnerAddress(ownerAddress);
        account.setAmount(amount);

        AccountService service = new AccountServiceImpl();
        service.insert(account);

        resp.sendRedirect("page?action=account");
    }

    private void forwardToPage(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher(page).include(req, resp);
    }

    public void destroy(){

    }
}
