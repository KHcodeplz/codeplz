<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="com.jsp.board.model.vo.*, com.jsp.user.model.vo.*, java.util.*" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width", initial-scale="1">
      <title>코드좀-myPage</title>
      <%@ include file="../common/header.jsp" %>
      
<%
   ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
   String category_name = "";
%>
<script>
   $(function() {
      var $a = $(".mypage-content:LAST-CHILD");
      $a.append("<div style='height: 5px;'></div>");
   });
</script>
<div class="mypage-contains">
   <div class="mypage-wrap">
      <div class="mypage-img">
         <img class="profile-img" src="/codeplz/resources/images/profile.png"/>
      </div>
      <br>
      <div class="mypage-profile">
         <p>닉네임 : <%=user.getUser_nickname() %>
         <a class="message-btn" href="#">
         <span class="glyphicon glyphicon-envelope"></span></a>   
         <span class="badge badge-pill badge-danger new-message">12</span>
         <a class="news-btn" href="#"><span class="glyphicon glyphicon-bell"></span></a>
         <span class="badge badge-pill badge-danger new-news">12</span></p>
            <div class="mypage-portfolio-wrap">
               <p>Tier : <%=user.getUser_tier_index() %></p>
               <p>Exp : </p>
            </div>
           <div class="mypage-portfolio-wrap">
              <button type="button" class="portfolio_btn" onclick="portfolio_open();">포트폴리오</button>
           </div>
      </div>
   </div>
   <hr>
   <div class="mypage-content-btn">   
      <button id="myPostBtn">내가 쓴 글</button>         
      <button id="myContentsBtn">내가 쓴 댓글</button>
      <button id="myPost_join_ContentsBtn">내 글에 답글이 달린 글</button>         
   </div>
   <hr>
      <div class="mypage-content">
         <div class="mypage-content-title-wrap">
            <div class="mypage-content-title">
               <span class="glyphicon glyphicon-tags" style="margin-right:15px;"></span>
                     내가 쓴 글
            </div>
         </div>
      <!--  
         로그 기록 양식
         <div class="mypage-content-body">
            <table>
               <tbody>
                  <tr class="mypage-table-line">
                     <td class="line-name">닉네임</td>
                     <td>님께서</td>
                     <td class="line-day"> / O 일 or O 개월 /</td>
                     <td>전에</td>
                     <td class="line-board">/ 게시판 / </td>
                     <td>에 올림</td>
                  </tr>
               </tbody>
            </table>
            <div class="line-sysday">2018-05-31</div>
         </div>
      -->
      <% for ( Board b : list ) { %>
      <div class="mypage-content-body">
         <table>
            <tbody>
               <tr class="mypage-table-line">
                  <td class="line-name"><%=b.getBoard_writer() %></td>
                  <td>님께서</td>
                  <td class="line-day"> <%=b.getBoard_elapsed_date() %>일</td>
                  <td>전에</td>
                  <td class="line-board"> 
                     <% if ( b.getBoard_category_index()==0 ) {
                           category_name = "공지사항";
                        } else if ( b.getBoard_category_index()==1 ) {
                           category_name = "Q&A";
                        }
                     %>
                     <%=category_name %>
                  </td>
                  <td>에</td>
                  <td class="line-board">
                     <a href="<%=request.getContextPath()%>/board_detail.cp?index=<%=b.getBoard_index()%>">
                        <%=b.getBoard_title() %>
                     </a>
                  </td>
                  <td>올림</td>
               </tr>
            </tbody>
         </table>
         <div class="line-sysday"><%=b.getBoard_inserted_date() %></div>
      </div>
      
      <% } %>
               
      <!--  내가 쓴 댓글 -->
      <div class="mypage-content-body">
         <table>
            <tbody>
               <tr class="mypage-table-line">
                  <td class="line-board">/ 게시판 / </td>
                  <td>에 있는</td>
                  <td class="line-day"> / O 일 or O 개월 /</td>
                  <td>전에 댓글을 남겼습니다.</td>
               </tr>
            </tbody>
         </table>
         <div class="line-sysday">2018-05-31</div>
      </div>
               
      <!--  내 글에 답글 -->
      <div class="mypage-content-body">
         <table>
            <tbody>
               <tr class="mypage-table-line">
                  <td class="line-name">/닉네임/</td>
                  <td>님이</td>
                  <td class="line-board">/ 게시판 / </td>
                  <td>에</td>
                  <td class="line-day"> / O 일 or O 개월 /</td>
                  <td>전에 댓글을 남겼습니다.</td>
               </tr>
            </tbody>
         </table>
         <div class="line-sysday">2018-05-31</div>
      </div>         
   <!--  body 닫는곳 -->
   </div>
</div>
      <%@ include file="../common/footer.jsp" %>