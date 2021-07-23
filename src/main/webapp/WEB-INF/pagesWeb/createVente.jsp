<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
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
			<div class="col-lg-12">
				<h1 class="col-lg-4 align_center">ENI-Enchères</h1>
				<h2 class="offset-lg-4 col-lg-4 align_center">Nouvelle vente</h2>
			</div>
		</div>
		<div class="row">
				<div class="col-lg-4">
					<img class="offset-lg-3 col-lg-9" src="img/no_image.jpg">
				</div>
				<div class="col-lg-6">
					<form method="GET">
						<label class="offset-lg-1 col-lg-3 space_after_menu_bar">Articles : </label>
						<input class="col-lg-4" type="text" id="article_edit_text"><br><br>

						<label class="offset-lg-1 col-lg-3 align_with_textarea">Description : </label>
						<textarea class="col-lg-4 no_resize" rows="4" cols="40" ></textarea><br><br>

						<label class="offset-lg-1 col-lg-3">Catégorie </label>
						<select class="offset-lg-1 col-lg-3" name="categorie" id="categorie_select_on_create"></select><br><br>

						<label class="offset-lg-1 col-lg-3">Photo de l'article </label>
						<input class="offset-lg-1 col-lg-3" type="file" id="upload_photo"  name="uploader" accept="image/png, image/jpeg"><br><br>

						<label class="offset-lg-1 col-lg-3">Mise à prix : </label>
						<input class="offset-lg-1 col-lg-3" type="number" id="mise_a_prix"><br><br>

						<label class="offset-lg-1 col-lg-3">Début de l'enchère : </label>
						<input class="offset-lg-1 col-lg-3" type="date" id="date_debut_enchere"><br><br>

						<label class="offset-lg-1 col-lg-3">Fin de l'enchère : </label>
						<input class="offset-lg-1 col-lg-3" type="date" id="fin_enchere"><br><br>

						<fieldset class="offset-lg-1 col-lg-7 border_fieldset">
							<legend class="col-lg-2 legend_restyled">Retrait</legend>

							<label class="col-lg-2">Rue : </label>
							<input class="offset-lg-3 col-lg-6" type="text" id="no_rue"><br><br>

							<label class="col-lg-4">Code postal : </label>
							<input class="offset-lg-1 col-lg-6" type="text" id="code_postal"><br><br>

							<label class="col-lg-2">Ville : </label>
							<input class="offset-lg-3 col-lg-6" type="text" id="ville">
						</fieldset><br>

						<input class="offset-lg-1 col-lg-2 button_vente_form shadow" type="submit" id="submit_button" value="Enregistrer">

						<input class="offset-lg-1 col-lg-2 button_vente_form shadow" type="button" id="return_button" value="Annuler">
					</form>
				</div>
		</div>
		
		
	</div>
		
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>