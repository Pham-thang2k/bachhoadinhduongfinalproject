<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <head>
        <jsp:include page="/includes/headerProduct.jsp" />
        <link rel="stylesheet" href="css/product-detail.css" type="text/css">
    </head>
    <body>
        
        <main role="main">
        <div class="container mt-4">
            <div id="thongbao" class="alert alert-danger d-none face" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="noidung">
               <div class="card" id="nd">
                  <div class="container-fliud">
                          <div class="wrapper row">
                              <div class="preview col-md-6">
                                  <div class="preview-pic tab-content">
                                      <div class="tab-pane" id="pic-1">
                                          <img class ="hinh1" src="images/${product.getIdtype()}/${product.getId()}/1.jpg">
                                      </div>
                                      <div class="tab-pane" id="pic-2">
                                          <img src="images/${product.getIdtype()}/${product.getId()}/2.jpg">
                                      </div>
                                      <div class="tab-pane active col-sm-10" id="pic-3">
                                          <img src="images/${product.getIdtype()}/${product.getId()}/3.jpg">
                                      </div>
                                  </div>
                                  <ul class="preview-thumbnail nav nav-tabs">
                                      <li class="active">
                                          <a data-target="#pic-1" data-toggle="tab" class="">
                                              <img src="images/${product.getIdtype()}/${product.getId()}/1.jpg">
                                          </a>
                                      </li>
                                      <li class="">
                                          <a data-target="#pic-2" data-toggle="tab" class="">
                                              <img src="images/${product.getIdtype()}/${product.getId()}/2.jpg">
                                          </a>
                                      </li>
                                      <li class="">
                                          <a data-target="#pic-3" data-toggle="tab" class="active">
                                              <img src="images/${product.getIdtype()}/${product.getId()}/3.jpg">
                                          </a>
                                      </li>
                                  </ul>
                              </div>
                              <div class="details col-md-6">
                                  <h3 class="product-title">${product.getName()}</h3>
                                  <div class="rating">
                                      <div class="stars">
                                          <span class="fa fa-star ${star1}"></span>
                                          <span class="fa fa-star ${star2}"></span>
                                          <span class="fa fa-star ${star3}"></span>
                                          <span class="fa fa-star ${star4}"></span>
                                          <span class="fa fa-star ${star5}"></span>
                                      </div>
                                      <span class="review-no">${product.getNumreview()} reviews</span>
                                  </div>
                                  <p class="product-description">1 ${product.getNotenum()} of ${product.getName()}</p>
                                  <small class="text-muted">old price: <s><span>${product.getPrice()} vnd</span></s></small>
                                  <h4 class="price">present price: <span>${salePrice} vnd</span></h4>
                                  <p class="vote"><strong>100%</strong> product <strong> Quality </strong>, Guaranteed<strong>, Reputation</strong>!</p>
                                <form method="GET" action="product">  
                                      <div class="form-group">
                                            <input type="hidden" name="idProduct" id="sp_ma" value=${product.getId()}>
                                            <label for="soluong">Order quantity :</label>
                                            <input type="number" class="form-control" id="soluong" name="numProduct" min="1" max="100" value = "${(numProduct == null)? 0 : numProduct}">
                                       
                                      </div>
                                  <div class="action">
                                    <input class="add-to-cart btn btn-default" type ="submit" id="btnThemVaoGioHang" value="ADD CART">                                        
                                </form>
                                    <div class="like btn btn-default">
                                    <form action="product" method="POST">
                                        <input type="hidden" name="idProduct" value="${product.getId()}">
                                        <input type="hidden" name="numReview" value="${product.getNumreview()+1}">
                                        <button type="submit" name="numStar" class="heart" value="${product.getNumstar()+1}"><span class="fa fa-heart"></span></button>
                                        <button type="submit" name="numStar" class="heart" value="${product.getNumstar()+2}"><span class="fa fa-heart"></span></button>
                                        <button type="submit" name="numStar" class="heart" value="${product.getNumstar()+3}"><span class="fa fa-heart"></span></button> 
                                        <button type="submit" name="numStar" class="heart" value="${product.getNumstar()+4}"><span class="fa fa-heart"></span></button> 
                                        <button type="submit" name="numStar" class="heart" value="${product.getNumstar()+5}"><span class="fa fa-heart"></span></button> 
                                        </form>
                                    </div>
                                    </div>
                                  </div>
                                  </div>
                                  </div>
                                  </div>
                              </div>
  
                          </div>
                     
                  </div>
              </div>
  
              <div class="card">
                  <div class="container-fluid">
                      <h3>The information of product:</h3>
                      <div class="row">
                          <div class="col">
                          ${product.getDescription()}
             </div>
                      </div>
                  </div>
              </div>
            </div>            
        </div>
        <!-- End block content -->
    </main>
     
        
    </body>
     <!-- fashion section start -->
     <footer>
         <jsp:include page="/includes/footer.jsp" />
     </footer>
</html>