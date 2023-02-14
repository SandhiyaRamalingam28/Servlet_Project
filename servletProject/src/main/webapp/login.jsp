<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script type="text/javascript"></script>
</head>
<body>
    <form action="LoginServlet" method="post">
    <div class="container">

   <label for="username"><b>Username</b></label>
   <input type="text" placeholder="Please enter your email" name="username" id = "username" required>
   <br><br>


   <label for="password"><b>Password</b></label>
   <input type="password" placeholder="Please enter Password" name="password" id="password" required>
   <br><br>
        
   <button type="submit">login</button>
   <button type="button" class="cancelbutton">Cancel</button>
   <button type="button" class="registerbutton">Register</button>
   <label>
     <input type="checkbox" checked="checked" name="rememberme"> Remember me
     
   </label>
 </div>

 <!-- <div class="container" style="background-color:#f1f1f1">
   <button type="button" class="cancelbutton">Cancel</button>
   <span class="psw">Forgot <a href="<%=request.getContextPath()%>/forgotpassword.jsp">password?</a></span>
 </div> -->
   </form>
</body>
</html>