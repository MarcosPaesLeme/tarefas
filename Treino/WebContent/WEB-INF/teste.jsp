<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale = 1.0">
	<meta name="description" content="Inspired by Google Nexus website and Codrops tutorial, here in Queness we are going through step-by-step to learn how to replicate the same Google Nexus navigation menu with CSS3 animation and jQuery library." />
	<title>Recreate Google Nexus Menu with jQuery and CSS3</title>
	<link href='http://fonts.googleapis.com/css?family=Roboto:300,400' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/normalize.css" />
	<link rel="stylesheet" href="css/main.css" />	
	<script type="text/javascript" src="js/jquery.1.10.2.min.js"></script>
	<script type="text/javascript" src="js/gnmenu.js"></script>
	<script type="text/javascript" src="http://www.queness.com/js/bsa.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<!-- HTML Markup for Top Navigation Menu -->	
	<nav>
		<ul>
			<li><a href="#" class="icon icon-menu" id="btn-menu">Menu</a></li>
			<li><a href="http://www.queness.com">Queness</a></li>
			<li><a href="http://www.queness.com/post/14666/recreate-google-nexus-menu">Read Tutorial</a></li>
		</ul>
	</nav>

	<!-- HTML Markup for Sidebar Slide Out Menu -->
	<div id="sideNav">
		<ul>
			<li class="searchForm"><a href="#" class="icon icon-search"><span><input type="text" placeholder="Search" class="search" /></span></a></li>
			<li><a href="#" class="icon icon-home"><span>Home</span></a></li>
			<li><a href="#" class="icon icon-articles"><span>Articles</span></a>
				<ul>
					<li><a href="#"><span>Web Design</span></a></li>
					<li><a href="#"><span>Web Development</span></a></li>
				</ul>
			</li>
			<li><a href="#" class="icon icon-social"><span>Social Media</span></a>
				<ul>
				<li><a href="#"><span>Facebook</span></a></li>
				<li><a href="#"><span>Twitter</span></a></li>								
				</ul>			
			</li>
		</ul>	
	</div>	
	
	<!-- Demo Page Description -->
	<div class="container">
		
		<h1>Google Nexus Menu</h1>
		<p>Replica of <a href="http://www.google.com/nexus/" target="_blank">Google Nexus</a> Menu. Inspired by <a href="http://tympanus.net/Tutorials/GoogleNexusWebsiteMenu/" target="_blank">Codrops</a>.<br/>Created by Kevin Liew from <a href="http://www.queness.com/post/14666/recreate-google-nexus-menu" target="_blank">Queness</a>.</p>
		
	</div>
	
	
</body>
</html>