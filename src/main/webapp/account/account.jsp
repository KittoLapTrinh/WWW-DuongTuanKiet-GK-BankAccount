<%@ page import="com.example.duongtuankiet.models.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/26/2024
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Account</title>
</head>
<body>
    <h1>List Account</h1>

    <h2>Filter Accounts by Amount</h2>
    <form action="page" method="post">
        <input type="hidden" name="action" value="filterAmount">
        <label for="minAmount">Minimum Amount: </label>
        <input type="number" id="minAmount" name="minAmount" required><br><br>

        <label for="maxAmount">Maximum Amount: </label>
        <input type="number" id="maxAmount" name="maxAmount" required><br><br>

        <button type="submit">Filter</button>
    </form>

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
    <form action="page?action=account" method="post">
        <label for="accountNumber">Account Number: </label>
        <input type="text" id="accountNumber" name="accountNumber" required><br><br>

        <label for="ownerName">Owner Name: </label>
        <input type="text" id="ownerName" name="ownerName"><br><br>

        <label for="cardNumber">cardNumber: </label>
        <input type="text" id="cardNumber" name="cardNumber"><br><br>

        <label for="ownerAddress">ownerAddress: </label>
        <input type="text" id="ownerAddress" name="ownerAddress"><br><br>

        <label for="amount">Amount: </label>
        <input type="text" id="amount" name="amount"><br><br>

        <button type="submit">Submit</button>
    </form>

</body>
</html>
