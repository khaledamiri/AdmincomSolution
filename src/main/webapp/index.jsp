<html>
<head>
<meta charset="UTF-8">
<title>Banque</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resources/css/myStyle.css" />
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

</head>
<body ng-app="myBanqueApp" ng-controller="myBanqueController as ctr" class="container">


	<div class="container">
		<h2>Taxes</h2>
		<p>The .table-striped class adds zebra-stripes to a table:</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Numero</th>
					<th>Titre</th>
					<th>Date</th>
					<th>Type</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="taxe in taxes">
					<td>{{taxe.numero}}</td>
					<td>{{taxe.titre}}</td>
					<td>{{taxe.date}}</td>
					<td>{{taxe.type}}</td>
				</tr>
			</tbody>
		</table>


	</div>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/angular/angular.min.js"></script>
<script type="text/javascript" src="resources/js/myApp/myApp.js"></script>

</html>