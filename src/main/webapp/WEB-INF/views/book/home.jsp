<%@ include file="../include/header.jsp" %>
<style>
	.bx-wrapper {
		margin:0 auto;
	}
	#notice {
		width:500px;
		float:left;
	}
	#noticeMenu {
		margin-bottom:10px;
	}
	#noticeMenu .selected{
		background:#EAEAEA;
	}
	#noticeMenu span {
		font-size:20px;
		color:black;   
		text-decoration: none;
		padding:10px;
	}
	#noticeContent {
		background-color:#EAEAEA;
		list-style:none;
		margin:0;
		padding:0;
		width:500px;
	}
	#noticeContent li {
		width:480px;
		padding:10px;  
	}
	#noticeContent li a {
		text-overflow: ellipsis;
    	-o-text-overflow: ellipsis;
    	overflow: hidden;
    	white-space: nowrap;
    	word-wrap: normal !important;
    	font-size:14px;
		color:black;
		display:inline-block;
		width:350px;
	}
	#noticeContent li span {
		font-size:14px;
		float:right;	
	}
	
	#subEvent {
		width:1000px;
		height:300px;
		margin:0 auto;
	}
	#mainEvent #calendar {
		width:300px;
		height:250px;
		float:left;
		margin-left:30px;
		position:relative;
	}
	#mainEvent #year{
		font-size:20px;
		margin-left:5px;
	}
	#mainEvent #calendar table {
		margin-top:10px;
		border-top:2px solid #EAEAEA;
		border-bottom:2px solid #EAEAEA;
		padding:10px 0;
	}
	#mainEvent #calendar table td, #mainEvent #calendar table th {
		text-align:center;
		padding:5px;
	}
	#mainEvent #calendar .lastMonth, #mainEvent #calendar .nextMonth {
		color:#BDBDBD;
	}
	#mainEvent #calendar .restDay {
		color:#ee2375;
	}
	#mainEvent #calendar .eventDay {
		color:#23c2ee;
	}
	#mainEvent #calendar #colorMean {
		width:150px;
		height:250px;
		position:absolute;
		top: 120px;
    	right: -170px;
	}
	#colorMean img {
		margin-right:5px;
	}
	
	#bookEvent {
		margin:0 auto;
		width:48%;
		height:280px;
	}

	#bookEvent #eventMenu span {
		font-size:20px;
		color:black;   
		text-decoration: none;
		padding:10px;
	}
	
	#bookEvent #eventMenu .selected {
		border:2px solid #EAEAEA;
		border-bottom:none;
	}
	
	#bookRanking {
		width:100%;
		height:100%;
		margin-top:10px;
		border:2px solid #EAEAEA;
	}
	.bookBox {
		float:left;
		margin:13px;
		text-align:center;
	}
	.bookBox img{
		text-align:center;
		width:150px;
		height:200px;
	}
	.bookBox p {
		font-size:14px;
		margin:0;
		text-align:center;
		width:130px;
		text-overflow: ellipsis;
    	-o-text-overflow: ellipsis;
    	overflow: hidden;
    	white-space: nowrap;
    	word-wrap: normal !important;
	}
	.bookBox span {
		color:gray;
		font-size:12px;
		display:block;   
		text-align:center;
	}
	
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
<script>
	$(function(){
		$('.bxslider').bxSlider({
		  auto: true,
		  autoControls: true,
		  stopAutoOnClick: true,
		  captions: false,
		  pager: true,
		  pause:6000,
		  speed:700,
		  slideWidth:900,
		  slideHeight:450,
		  slideMargin:20
		})
	})
</script>
	 	<div id="container">
	 		<div id="mainEvent">
	 			<div class="bxslider">
					<div>
						<img src="${pageContext.request.contextPath}/resources/image/main_bg1.jpg">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/image/main_bg2.jpg">
					</div>
					<div>
						<img src="${pageContext.request.contextPath}/resources/image/main_bg3.jpg">
					</div>
				</div>
				<div id="subEvent">
				<div id="notice">
	 				<div id="noticeMenu">
	 					<span class="selected">Notice</span>
	 					<span>Event</span>
	 				</div>
	 				<ul id="noticeContent">
	 					<li>
	 						<a href="#">Year 2020, new Books list</a>
	 						<span>2020-01-10</span>
	 					</li>
	 					<li>
	 						<a href="#">Year 2020, best books list</a>
	 						<span>2020-01-10</span>
	 					</li>
	 					<li>
	 						<a href="#">We find NEW recruits!</a>
	 						<span>2020-01-10</span>
	 					</li>
	 					<li>
	 						<a href="#">12th Novel BookContest</a>
	 						<span>2020-01-10</span>
	 					</li>
	 					<li>
	 						<a href="#">Library Cafe is open!</a>
	 						<span>2020-01-10</span>
	 					</li>
	 				</ul>
	 			</div>
	 			
	 			<div id="calendar">
	 				<span id="year">2020.01.</span>
					<table>
						<tr>
							<th>Sun</th>
							<th>Mon</th>
							<th>Tues</th>
							<th>Wed</th>
							<th>Thur</th>
							<th>Fri</th>
							<th>Sat</th>
						</tr>
						<tr>
							<td class="lastMonth">29</td>
							<td class="lastMonth">30</td>
							<td class="lastMonth">31</td>
							<td class="restDay">1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
						</tr>
						<tr>
							<td>5</td>
							<td class="restDay">6</td>
							<td>7</td>
							<td>8</td>
							<td>9</td>
							<td class="eventDay">10</td>
							<td>11</td>
						</tr>
						<tr>
							<td>12</td>
							<td class="restDay">13</td>
							<td>14</td>
							<td>15</td>
							<td>16</td>
							<td>17</td>
							<td>18</td>
						</tr>
						<tr>
							<td>19</td>
							<td class="restDay">20</td>
							<td>21</td>
							<td class="eventDay">22</td>
							<td>23</td>
							<td class="restDay">24</td>
							<td class="restDay">25</td>
						</tr>
						<tr>
							<td class="restDay">26</td>
							<td class="restDay">27</td>
							<td>28</td>
							<td>29</td>
							<td>30</td>
							<td>31</td>
							<td class="nextMonth">1</td>
						</tr>
					</table>
					<div id="colorMean">
						<div><img src="${pageContext.request.contextPath}/resources/image/restDay.png"><span>Rest Day</span></div>
						<div><img src="${pageContext.request.contextPath}/resources/image/eventDay.png"><span>Event Day</span></div>
					</div> 	
	 			</div>
	 		</div>
	 		<div id="bookEvent">
	 			<div id="eventMenu">
	 				<span class="selected">New Books</span>
		 			<span>Loan Best</span>
				</div>
				<div id="bookRanking">		
					<div class="bookBox">
						<img src="${pagContext.request.contextPath}/resources/image/sample1.jpg">
						<p>JSP & Servlet</p>
						<span>DJ Jung</span>
					</div>
					<div class="bookBox">
						<img src="${pagContext.request.contextPath}/resources/image/sample2.jpg">
						<p>Namiya Store's Miracle</p>
						<span>Higasino Geigo</span>
					</div>
					<div class="bookBox">
						<img src="${pagContext.request.contextPath}/resources/image/sample3.jpg">
						<p>Singapore</p>
						<span>Someone</span>
					</div>
					<div class="bookBox">
						<img src="${pagContext.request.contextPath}/resources/image/sample4.jpg">
						<p>Mermaid Sleep in House</p>
						<span>Higasino Geigo</span>
					</div>
					<div class="bookBox">
						<img src="${pagContext.request.contextPath}/resources/image/sample5.jpg">
						<p>Travels reason</p>
						<span>YH Kim</span>
					</div>
				</div>	
			</div>
 		</div>
 	</div>
<%@ include file="../include/footer.jsp" %>