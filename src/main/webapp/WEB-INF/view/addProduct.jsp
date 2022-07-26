<html>
    <head>
<!------ Include the above in your HEAD tag ---------->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

 <link rel="stylesheet" type="text/css" href="reg.css">	
 <title>Add Product</title>
 </head>
 <body> 
    <h4 style="color:red">${msg}</h4>
 <form action="addProduct" method="post" onsubmit="" name="myForm">

<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <!-- <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/> -->
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
                                <h3 class="register-heading">Add Product</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <!-- <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product Id *" value="" />
                                        </div> -->
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product Id *" value="" name="procudtId" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product Name *" value="" name="productName"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product Price *" value="" name="productPrice"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Product Expiry Date *" value="" name="productExpiryDate"/>
                                        </div> 
                                        
                                       
                                    </div>
                                    <div class="col-md-6">
                                         
                                        <!-- <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control" placeholder="Your Phone *" value="" />
                                        </div> -->
                                        
                                       
                                        <input type="submit" class="btnRegister"  value="Add Product"/>
                                    </div>
                                </div>
                            </div>
                             
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
 </form>
 </body>
</html>