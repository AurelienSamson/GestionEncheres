<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
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
			<div class="col-lg-12">
				<h1 class="col-lg-3 align_center">ENI-Encheres</h1>
				<a class="offset-lg-9 col-lg-1 align_center" href="#">S'inscrire - Se connecter</a>
			</div>
		</div>
		<div class="row">
			<h2>Liste des enchères</h2>
		</div>
		<div class="row">
			<div class="offset-lg-1 col-lg-4">
				<label class="col-lg-12" id="filtre_label">Filtres :</label>
				<input class="col-lg-12" type="text" id="search_bar">
				<label class="col-lg-2 align_center">Catégorie : </label>
				<select class="col-lg-10" name="categorie" id="categorie_select"></select>
			</div>
			<div class="offset-lg-2 col-lg-4 offset-lg-1 button_alignement">
				<input class="col-lg-12" type="submit" id="search_button" value="Rechercher">
			</div>
		</div>
	</div>
		
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>