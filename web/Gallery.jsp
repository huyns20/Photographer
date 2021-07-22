<%-- 
    Document   : Gallery
    Created on : Jun 21, 2021, 21:12:55 AM
    Author     : Nguyen Sy Huy
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${galery.name}</h3>
                    </div>
                    <c:if test="${top1Gallery.imageUrl != null && totalRecord > 0}">
                        <div class="main-img" id="thumbnail">
                            <div id="g-main-img" class="a-main-img">
                                <img class="main-image" id="FImg" src="image/${top1Gallery.imageUrl}" alt="ccc"/>
                            </div>

                            <img id="play" class="play" src="image/play.png" alt="ccc"/> 
                        </div>
                    </c:if>
                    <div class="contentGalery">
                        <ul >
                            <c:forEach items="${listImage}" var="i" varStatus="loop">
                                <li class="span4">
                                    <img id="clickImage" src="image/${i.imageUrl}" onclick="zoomout(this)" alt="image"/>
                                </li>
                            </c:forEach>
                        </ul>    
                        <div class="paging">

                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <a class="${i==index?"active":""}" href="GalleryController?index=${i}&galeryId=${galeryID}">${i}</a>
                                <c:set var="index" value="${index}" />
                            </c:forEach>

                        </div>
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
        <script>
            var index = 1;
            var timeNext;
            document.getElementById('thumbnail').onmouseover = function () {
                playButton.style.opacity = "100";
            }
            document.getElementById('thumbnail').onmouseout = function () {
                playButton.style.opacity = "0";
            }

            var playing = false;
            var playButton = document.getElementById('play');
            function play() {
                playButton.src = "image/pause.png";
                playing = true;
                timeNext = setInterval(changeImage, 1000);
            }
            function pause() {
                playButton.src = "image/play.png";
                playing = false;
                clearInterval(timeNext);
            }
            playButton.onclick = function () {
                if (playing == true) {
                    pause();
                } else {
                    play();
                }
            }
            changeImage = function () {
                var listImage = [];   // list[0]         
            <c:forEach items="${listImage}" var="i">
                listImage.push("${i.imageUrl}");
            </c:forEach>
                // get src of image on thumbnail
                var imageClick = document.getElementById('FImg').src.toString(); 
                // check the user is clicking on any image 
                if (index != 0) {
                    if (imageClick != ("http://localhost:8080/PhotoGrapher/image/" + listImage[index - 1]).toString()) {
                        for (var i = 0; i < listImage.length; i++) {
                            if (imageClick == ("http://localhost:8080/PhotoGrapher/image/" + listImage[i]).toString()) {
                                if (i == (listImage.length - 1)) {
                                    index = 0;
                                    break;
                                } else {
                                    index = i + 1;
                                    break;
                                }
                            }
                        }
                    }
                }
                document.getElementById('FImg').src = "image/" + listImage[index];
                if (index == listImage.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
            function zoomout(image) {
                //  var listImage = [];
                var src = image.src;
                document.getElementById('FImg').src = src;
                clearInterval(timeNext);
                timeNext = setInterval(changeImage, 1000);
            }
        </script>
    </body>
</html>
