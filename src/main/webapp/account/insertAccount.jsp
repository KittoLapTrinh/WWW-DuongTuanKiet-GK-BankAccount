<%@ page import="com.example.duongtuankiet.models.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/26/2024
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Insert Account</h1>
    <table border="1">
        <thead>
        <tr>
            <th>Account Number</th>
            <th>Owner Name</th>
            <th>Card Number</th>
            <th>Owner Address</th>
            <th>Amount</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Account> accounts = (List<Account>) request.getAttribute("accounts");
            if(accounts != null)
                for(Account a : accounts){
        %>
        <tr>
            <td><%=a.getAccountNumber()%></td>
            <td><%=a.getOwnerName()%></td>
            <td><%=a.getCardNumber()%></td>
            <td><%=a.getOwnerAddress()%></td>
            <td><%=a.getAmount()%></td>
        </tr>
        <%
                }
        %>
        </tbody>
    </table>
    <form action="page?action=insertAccount" method="post">
        <label for="accountNumber">Account Number: </label>
        <input type="text" id="accountNumber" name="accountNumber" required><br>

        <label for="ownerName">Owner Name: </label>
        <input type="text" id="ownerName" name="ownerName"><br>

        <label for="cardNumber">cardNumber: </label>
        <input type="text" id="cardNumber" name="cardNumber"><br>

        <label for="ownerAddress">ownerAddress: </label>
        <input type="text" id="ownerAddress" name="ownerAddress"><br>

        <label for="amount">Amount: </label>
        <input type="text" id="amount" name="amount"><br>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
