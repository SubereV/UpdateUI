<%-- 
    Document   : modal
    Created on : Jul 23, 2020, 4:16:32 PM
    Author     : kinvo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="login">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body mx-3">
                    <div class="md-form mb-5">
                        <i class="fa fa-envelope prefix grey-text"></i>
                        <input type="email" name="email" id="defaultForm-email1" class="form-control validate">
                        <label data-error="wrong" data-success="right" for="defaultForm-email1" class="">Your email</label>
                    </div>

                    <div class="md-form mb-4">
                        <i class="fa fa-lock prefix grey-text"></i>
                        <input type="password" name="password" id="defaultForm-pass1" class="form-control validate">
                        <label data-error="wrong" data-success="right" for="defaultForm-pass1">Your password</label>
                    </div>
                    <a data-toggle="modal" data-target="#modalRegisterForm" href="#">
                        Don't have any account?
                    </a>
                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button type="submit" class="btn btn-default waves-effect waves-light">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="signup">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Sign up</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body mx-3">
                    <div class="md-form mb-5">
                        <i class="fa fa-user prefix grey-text"></i>
                        <input type="text" name="name" id="orangeForm-name" class="form-control validate">
                        <label data-error="wrong" data-success="right" for="orangeForm-name">Your name</label>
                    </div>
                    <div class="md-form mb-5">
                        <i class="fa fa-envelope prefix grey-text"></i>
                        <input type="email" name="email" id="orangeForm-email" class="form-control validate">
                        <label data-error="wrong" data-success="right" for="orangeForm-email">Your email</label>
                    </div>

                    <div class="md-form mb-4">
                        <i class="fa fa-lock prefix grey-text"></i>
                        <input type="password" name="password" id="orangeForm-pass" class="form-control validate">
                        <label data-error="wrong" data-success="right" for="orangeForm-pass">Your password</label>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button type="submit" class="btn btn-deep-orange">Sign up</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
            </div>
            <div class="modal-body">
                <form action="editUser" id="myform" method="post">
                    <div class="form-group"><input id='inputName' name="name" class="form-control " type="text" placeholder="Name" value="${u.name}"></div>
                    <div class="form-group">
                        <select id="inputPermission" name="permission" class="form-control">
                            <option value="1" selected="true">Admin</option>
                            <option value="2">User</option>
                        </select></div>
                    <div class="form-group">
                        <input id="inputEmail" name="email" class="form-control " type="text" placeholder="Email" value = "${u.email}">
                    </div>
                    <div class="form-group">
                        <input id="inputPassword" name="password" class="form-control " type="text" placeholder="Password" value = "${u.password}">  </div>
                    <div class="form-group">                                   
                        <input id="inputDescription" name="description" class="form-control " type="text" placeholder="Description" value = "${u.description}">
                    </div>
                    <div class="modal-footer ">
                        <button class="btn btn-warning btn-lg" style="width: 100%;" type="submit"><span class="glyphicon glyphicon-ok-sign">Update</span></button>
                    </div>
                </form>
            </div>
            <!-- /.modal-content --> 
        </div>
        <!-- /.modal-dialog --> 
    </div>
</div>



<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
            </div>
            <div class="modal-body">

                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>
            </div>
            <div class="modal-footer ">
                <a id="deletef" href="#" id="deleteUser"><button type="button"  class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span>Yes</button></a>
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>
            </div>
        </div>
        <!-- /.modal-content --> 
    </div>
    <!-- /.modal-dialog --> 
</div>
