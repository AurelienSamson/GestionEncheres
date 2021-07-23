<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ENI-Enchères</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="CSS/style.css" rel="stylesheet" type="text/css"/>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<h1>ENI-Enchères</h1>
		</div>
		<div class="row">
			<h2>jojo44 a remporté l'enchère</h2>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<img class="offset-lg-3 col-lg-9" src="img/no_image.jpg">
			</div>
			<div class="col-lg-6">
				<label class="offset-lg-1 col-lg-11"></label><br><br>
				<label class="offset-lg-1 col-lg-3 align_with_textarea">Description : </label>
				<label class="col-lg-7"></label><br><br>
				<label class="offset-lg-1 col-lg-2">Meilleure offre : </label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-2">Mise à prix : </label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-2">Fin de l'enchère : </label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-1">Retrait : </label>
				<label class="offset-lg-1 col-lg-8"></label>
				<label class="offset-lg-3 col-lg-8">&nbsp;</label><br><br>
				<label class="offset-lg-1 col-lg-2">Vendeur : </label>
				<label class="col-lg-8"></label><br><br><br>
				<input class="offset-lg-1 col-lg-2" type="button" id="enchere_effectue_button" value="Retrait effectué">
			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>