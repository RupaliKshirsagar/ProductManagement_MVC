<html>
    <head>
<!------ Include the above in your HEAD tag ---------->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

 <link rel="stylesheet" type="text/css" href="reg.css">	 
 <title>Add User</title>
 </head>
<body>
 <h4 style="color:red">${msg}</h4>
 <form action="addUser" method="post" onsubmit="" name="myForm">
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="images/logo.jpg" alt=""/>
                        <h3>Welcome</h3>
                        
                        
                    </div>
                    <div class="col-md-9 register-right">
                        <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                            <!-- <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Employee</a>
                            </li> -->
                            <!-- <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Hirer</a>
                            </li> -->
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Add User</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Username *" value="" name="username" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Password *" value="" name="password"/>
                                        </div>
                                        
                                        
                                        
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="female">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        
                                        <!-- <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control" placeholder="Your Phone *" value="" />
                                        </div> -->
                                       
                                        <div class="form-group">
                                            <select class="form-control" name="role">
                                                <option class="hidden"  selected disabled>Select Role </option>
                                                <option>Admin</option>
                                                <option>User</option>
                                            </select><br>
                                       
                                        <div class="form-group">
                                            <select class="form-control" name="question">
                                                <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                                <option>What is your Birthdate?</option>
                                                <option>What is Your old Phone Number</option>
                                                <option>What is your Pet Name?</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Enter Your Answer *" value="" name="answer" />
                                        </div>
                                        <input type="submit" class="btnRegister"  value="Add User"/>
                                    </div>
                                </div>
                            </div>
                            
                                    <!-- <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="password" class="form-control" placeholder="Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" placeholder="Confirm Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <select class="form-control">
                                                <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                                <option>What is your Birthdate?</option>
                                                <option>What is Your old Phone Number</option>
                                                <option>What is your Pet Name?</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Answer *" value="" />
                                         </div> 
                                        <input type="submit" class="btnRegister"  value="ADD USER"/>
                                    </div> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </form>
    </body>
    </html>
