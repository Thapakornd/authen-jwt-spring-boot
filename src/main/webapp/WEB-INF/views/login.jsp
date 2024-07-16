<html>
<head>
    <title>Welcome</title>
        <link href="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>
    <div class="container mt-5 d-flex justify-content-center">
        <form style="width: 500px; display: flex; gap: 1rem;" class="flex-column" action="signUp" >
            <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
     <script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>