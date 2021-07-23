<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>ENI-Enchères</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
<link href="css/style.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
          crossorigin="anonymous">
</head>

<body>
<form id="createLoginForm" method="post" action="/createLogin" >
	<div class="container-fluid " >

		<div class="row">
			<div class="col-lg-12">
				<h2 class="col-lg-4 align_center">ENI-Enchères</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<h3 class="offset-lg-4 col-lg-4 align_center">Mon Profil</h3>
			</div>
		</div>

		<!-- Debut des lignes a deux colonnes pour les infos utilisateurs  -->
		<!-- Bloc 1 -->
		<div class="form-group-md row ">
			<label class="col-form-label col-2 col-md-1" for="pseudo"> Pseudo:</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="pseudo" id="pseudo" placeholder=" Caractères alphanumériques">
			</div>

			<label class="col-form-label col-2 offset-md-1 col-md-1" for="name">Nom :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="name" id="name" placeholder="Entrez votre nom ici">
			</div>
		</div>
		<!-- Bloc 2 -->
		<div class="form-group-md row">
			<label class="col-form-label col-2 col-md-1" for="firstName"> Pénom :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="firstName" id="firstName" placeholder="Entrez votre prénom ici ">
			</div>

			<label class="col-form-label col-2 offset-md-1 col-md-1" for="email">Email :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="email" id="email" placeholder="Entrez votre email ici">
			</div>
		</div>
		<!-- Bloc 3  -->
		<div class="form-group-md row">
			<label class="col-form-label col-2 col-md-1" for="telephone"> Teléphone :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="telephone" id="telephone" placeholder="Format accepter 0600000000">
			</div>

			<label class="col-form-label col-2 offset-md-1 col-md-1" for="street">Rue :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="street" id="street" placeholder="Rue">
			</div>
		</div>
		<!-- Bloc 4 -->
		<div class="form-group-md row">
			<label class="col-form-label col-2 col-md-1" for="codePostal"> Code&nbsp;postal :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="codePostal" id="codePostal" placeholder="Entrez votre code postal ici">
			</div>

			<label class="col-form-label col-2 offset-md-1 col-md-1" for="town">Ville  :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="town" id="town" placeholder=" Entrez votre ville ici">
			</div>
		</div>
		<!-- Bloc 5 -->
		<div class="form-group-md row">
			<label class="col-form-label col-2 col-md-1" for="password"> Mot&nbsp;de&nbsp;passe :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="password" id="password" placeholder="Entrez votre mot de passe ici">
			</div>

			<label class="col-form-label col-2 offset-md-1 col-md-1" for="confirmPassword">Confirmation :</label>
			<div class="col-md-4 offset-1 offset-md-0 col-9 mb-2 mb-md-0">
				<input required type="text" class="form-control" name="confirmPassword" id="confirmPassword" placeholder=" Confirmer vote mot de passe ici">
			</div>
		</div>
		<!-- Bloc 6 -->
		<div class="row mt-md-5">
			<input class=" offset-1 col-4 offset-md-2 col-md-3 btn btn-success btn-block btn-lg" type="submit" id="submit_button" value="Créer">

			<input class="offset-1 col-4 offset-md-2 col-md-3 btn btn-danger btn-block btn-lg" type="button" id="return_button" value="Annuler">
		</div>

	</div>

</form>
</body>
</html>