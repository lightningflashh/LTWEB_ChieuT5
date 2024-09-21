<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<div class="main">
    <div class="container">
        <!-- BEGIN CONTENT -->
        <div class="col-md-9 col-sm-9">
            <h1>Login</h1>
            <div class="content-form-page">
                <div class="row">
                    <div class="col-md-7 col-sm-7">
                        <form action="/ltwebct5/login" method="post" class="form-horizontal form-without-legend" role="form">
                            <!-- Username Field -->
                            <div class="form-group">
                                <label for="username" class="col-lg-4 control-label">Username
                                    <span class="require">*</span>
                                </label>
                                <div class="col-lg-8">
                                    <input type="text" class="form-control" id="username" name="username" required>
                                </div>
                            </div>
                            <!-- Password Field -->
                            <div class="form-group">
                                <label for="password" class="col-lg-4 control-label">Password
                                    <span class="require">*</span>
                                </label>
                                <div class="col-lg-8">
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div>
                            </div>
                            <!-- Forgot Password Link -->
                            <div class="row">
                                <div class="col-lg-8 col-md-offset-4 padding-left-0">
                                    <a href="page-forgotton-password.html">Forget Password?</a>
                                </div>
                            </div>
                            <!-- Login Button -->
                            <div class="row">
                                <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </div>
                            </div>
                            <!-- Social Login -->
                            <div class="row">
                                <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                                    <hr>
                                    <div class="login-socio">
                                        <p class="text-muted">or login using:</p>
                                        <ul class="social-icons">
                                            <li><a href="#" class="facebook" title="Facebook"></a></li>
                                            <li><a href="#" class="twitter" title="Twitter"></a></li>
                                            <li><a href="#" class="googleplus" title="Google Plus"></a></li>
                                            <li><a href="#" class="linkedin" title="LinkedIn"></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- Additional Info -->
                    <div class="col-md-4 col-sm-4 pull-right">
                        <div class="form-info">
                            <h2><em>Important</em> Information</h2>
                            <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>
                            <button type="button" class="btn btn-default">More details</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</div>
