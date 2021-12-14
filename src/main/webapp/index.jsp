<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.finalproject.Database.typeDB"%>
<%@page import="com.finalproject.Database.productDB"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <head>
        <jsp:include page="/includes/header.jsp" />
    </head>
    <body>
        
        <div class="fashion_section">
         <div id="main_slider" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
               <div class="carousel-item active">
                   <%String name = typeDB.selectType().get(0).getType();%>
                   <% int id = typeDB.selectType().get(0).getId();%>
                   
                  <div class="container">     
                    <h1 class="fashion_taital"><%= name %></h1>
                    <div class="fashion_section_2">
                        <div class="row">
                            
                            <%for(int i = 0; i < 3; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="tshirt_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                          String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <h1 class="fashion_taital"><%= name %></h1>
                     <div class="fashion_section_2">
                        <div class="row">
                           
                            <%for(int i = 3; i < 6; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="tshirt_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <h1 class="fashion_taital"><%= name %></h1>
                     <div class="fashion_section_2">
                        <div class="row">
                                
                            <%for(int i = 6; i < 9; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(typeDB.selectType().get(0).getId()).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(typeDB.selectType().get(0).getId()).get(i).getPrice() + "/" + productDB.selectProduct(typeDB.selectType().get(0).getId()).get(i).getNotenum()  %></span></p>
                                    <div class="tshirt_img">
                                        <%String image = "images/" + String.valueOf(typeDB.selectType().get(0).getId()) + "/" + String.valueOf(productDB.selectProduct(typeDB.selectType().get(0).getId()).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <a class="carousel-control-next" href="#main_slider" role="button" data-slide="next">
            <i class="fa fa-angle-right"></i>
            </a>
            <a class="carousel-control-prev" href="#main_slider" role="button" data-slide="prev">
            <i class="fa fa-angle-left"></i>
            </a>
         </div>
      </div>
      <!-- fashion section end -->
      <!-- electronic section start -->
      <div class="fashion_section">
         <div id="electronic_main_slider" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
               <div class="carousel-item active">
                   <% name = typeDB.selectType().get(1).getType();%>
                   <% id = typeDB.selectType().get(1).getId();%>
                   
                  <div class="container">
                     <h1 class="fashion_taital"><%= name%></h1>
                     <div class="fashion_section_2">
                        <div class="row">
                           
                             <%for(int i = 0; i < 3; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="electronic_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>                
               <div class="carousel-item">
                  <div class="container">
                     <h1 class="fashion_taital"><%= name %></h1>
                     <div class="fashion_section_2">
                        <div class="row">

                            <%for(int i = 3; i < 6; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="electronic_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <h1 class="fashion_taital"><%= name %></h1>
                     <div class="fashion_section_2">
                        <div class="row">
                           
                            <%for(int i = 6; i < 9; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="electronic_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <a class="carousel-control-next" href="#electronic_main_slider" role="button" data-slide="next">
            <i class="fa fa-angle-right"></i>
            </a>
            <a class="carousel-control-prev" href="#electronic_main_slider" role="button" data-slide="prev">
            <i class="fa fa-angle-left"></i>
            </a>
         </div>
      </div>
      <!-- electronic section end -->
      <!-- jewellery  section start -->
      <div class="jewellery_section">
         <div id="jewellery_main_slider" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
               <div class="carousel-item active">
                   <% name = typeDB.selectType().get(2).getType();%>
                   <% id = typeDB.selectType().get(2).getId();%>
                  <div class="container">
                     <h1 class="fashion_taital"><%= name %></h1>
                     <div class="fashion_section_2">
                        <div class="row">
                           
                            <%for(int i = 0; i < 3; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="electronic_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <h1 class="fashion_taital"><%= name %></h1>
                     <div class="fashion_section_2">
                        <div class="row">
                            
                            <%for(int i = 3; i < 6; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="electronic_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
               <div class="carousel-item">
                  <div class="container">
                     <h1 class="fashion_taital"><%= name %></h1>
                     <div class="fashion_section_2">
                        <div class="row">
                           
                            <%for(int i = 6; i < 9; i+=1) {%>
                                <div class="col-lg-4 col-sm-4">
                                <div class="box_main">
                                    <h4 class="shirt_text"><%= productDB.selectProduct(id).get(i).getName() %></h4>
                                    <p class="price_text">Giá<span style="color: #262626;">
                                            <%= productDB.selectProduct(id).get(i).getPrice() + "/" + productDB.selectProduct(id).get(i).getNotenum()  %></span></p>
                                    <div class="electronic_img">
                                        <%String image = "images/" + String.valueOf(id) + "/" + String.valueOf(productDB.selectProduct(id).get(i).getId()) + "/1.jpg";
                                        String url = "product?idProduct="+ String.valueOf(productDB.selectProduct(id).get(i).getId());
                                        %>
                                        <img src=<%=image%>></div>
                                   <div class="btn_main">
                                       <div class="buy_bt"><a href=<%=url%>>Buy Now</a></div>
                                   </div>
                                </div>
                             </div>
                            <%};%>
                            
                        </div>
                     </div>
                  </div>
               </div>
            </div><br><br><br><br><br>
            <a class="carousel-control-prev narrow" href="#jewellery_main_slider" role="button" data-slide="prev">
            <i class="fa fa-angle-left"></i>
            </a>
            <a class="carousel-control-next narrow" href="#jewellery_main_slider" role="button" data-slide="next">
            <i class="fa fa-angle-right"></i>
            </a>
            
         </div>
      </div>
      <div class="footing"><jsp:include page="/includes/footer.jsp" /></div>
      
    </body>    
     <!-- fashion section start -->
</html>