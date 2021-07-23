<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ENI-Enchères</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<h1>ENI-Enchères</h1>
			<h2>Détail vente</h2>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<img class="offset-lg-3 col-lg-9 space_after_menu_bar" src="img/no_image.jpg">
			</div>
			<div class="col-lg-6">
				<label class="offset-lg-1 col-lg-11 space_after_menu_bar"></label><br><br>
				<label class="offset-lg-1 col-lg-3 align_with_textarea">Description : </label>
				<label class="col-lg-4"></label><br><br>
				<label class="offset-lg-1 col-lg-3">Catégorie</label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-3">Meilleure offre : </label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-3">Mise à prix : </label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-3">Retrait : </label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-3">Vendeur : </label>
				<label class="col-lg-3"></label><br><br>
				<label class="offset-lg-1 col-lg-3">Ma poposition : </label>
				<input class="col-lg-1" type="number" id="nouvelle_proposition">
				<input type="submit" id="bouton_encherir" value="Enchérir">

			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>