<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-touch-fullscreen" content="yes" />
    <title></title>

    <style type="text/css">
        body, div, canvas
        {
            image-rendering: optimizeSpeed;
            -webkit-image-rendering: optimizeSpeed;
            -webkit-interpolation-mode: nearest-neighbor;
        }

        body{padding:0; margin:0;font-size:12px;background-color:#000;}
        body, html{height: 100%;}
        #outer{height:100%; overflow:hidden; position:relative; width:100%;}
        #outer[id]{display:table; position:static;}
        #middle{position:absolute; top:50%;} /* for ie only*/
        #middle[id]{display:table-cell; vertical-align:middle; position:static;}
    	
    	#bgImg{ position:absolute; top: 0; left: 0;width:100% ;height:100%;}
    	#submitBtn{position:absolute; display:inline-block;}
    	#codeDiv{position:absolute;padding:12px 10px; text-align:center;color:#fff;font-size:2em;}
    </style>

    <script type="text/javascript" src="game/js/jquery.js"></script>
	<script type="text/javascript" src="game/js/input-mobile.js"></script>

</head>

<body>
<div id="outer">
	<img id="bgImg" src="game/images/exchange-code.png"/>
	<div id="codeDiv" >231231123123</div>
	<a id="submitBtn" href="javascript:void(0)"></a>    
    
</div>

<script>
var docWidth = $(document).width();
var docHeight = $(document).height();
var submitBtn = $('#submitBtn');
submitBtn.css('top',0.8523*docHeight + 'px'); 
submitBtn.css('left',0.1867*docWidth + 'px');
submitBtn.css('width',0.65*docWidth + 'px');
submitBtn.css('height',0.04911*docHeight + 'px');

submitBtn.on('click',function(){
	//location = 'exchange-code';	
	location = 'input-mobile';
});


var codeDiv = $('#codeDiv');
codeDiv.css('top',0.6934*docHeight + 'px'); 
codeDiv.css('left',0.13125*docWidth + 'px');
codeDiv.css('width',0.7218*docWidth + 'px');
codeDiv.css('height',0.03161*docHeight + 'px');

</script>
</html>