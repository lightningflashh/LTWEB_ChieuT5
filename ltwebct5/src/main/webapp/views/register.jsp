<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<div class="main">
	<div class="container">
		          <div class="col-md-9 col-sm-9">
            <h1>Create an account</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form action="/ltwebct5/register" method="post" class="form-horizontal" role="form">
                 	<div class="col">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
					</div>
                    <fieldset>
                      <legend>Your personal details</legend>
                      <div class="form-group">
                        <label for="fullName" class="col-lg-4 control-label">Full Name <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="fullName" class="form-control" id="fullName">
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <label for="username" class="col-lg-4 control-label">Username <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="username" class="form-control" id="username">
                        </div>
                      </div>
              
                      <div class="form-group">
                        <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="email" class="form-control" id="email">
                        </div>
                      </div>
                      
                       <div class="form-group">
                        <label for="phone" class="col-lg-4 control-label">Phone <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="phone" class="form-control" id="phone">
                        </div>
                      </div>
                    </fieldset>
                    <fieldset>
                      <legend>Your password</legend>
                     </fieldset>
                      <div class="form-group">
                        <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="password" class="form-control" id="password">
                        </div>
                      </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">                        
                        <button type="submit" class="btn btn-primary">Create an account</button>
                        <button type="button" class="btn btn-default">Cancel</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed sit nonumy nibh sed euismod ut laoreet dolore magna aliquarm erat sit volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl aliquip  commodo quat.</p>

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

