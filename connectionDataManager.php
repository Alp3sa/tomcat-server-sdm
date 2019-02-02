<?php 
include("connection.php");

function sanitizeInput($connection,$input) {
	$input=htmlentities(stripslashes($input), ENT_QUOTES);
	$input= mysqli_real_escape_string($connection,$input);
	return $input;
}

if(isset($_POST['order']) && $_POST['order']==="login"){
	$user=null;
	$pass=null;
	$user=null;
	$nombre=null;
	$primerApellido=null;
	$segundoApellido=null;
	$edad=null;
	$dni=null;
	$genero=null;
	$tipoDeMiembro=null;
	$pass=null;
		
	if($connection){
		$username=sanitizeInput($connection,$_POST['username']);
		$password=sanitizeInput($connection,$_POST['password']);
		
		$consulta = "SELECT * FROM user WHERE nombreUsuario like '$username'";
		$result = mysqli_query($connection,$consulta);
		$resultArray=mysqli_fetch_array($result);
		
		if(mysqli_num_rows($result)>0 && password_verify($password,$resultArray['password'])){
			$user=html_entity_decode($resultArray['nombreUsuario']);
			$nombre=html_entity_decode($resultArray['nombre']);
			$primerApellido=html_entity_decode($resultArray['primerApellido']);
			$segundoApellido=html_entity_decode($resultArray['segundoApellido']);
			$edad=$resultArray['edad'];
			$dni=html_entity_decode($resultArray['dni']);
			$genero=$resultArray['genero'];
			$tipoDeMiembro=$resultArray['tipoDeMiembro'];
			$pass=$resultArray['password'];
			//$res=(object)['0' => 1,'1' => $user,'2' => $pass];
			$res=(object)['0' => 1,'1' => $user,'2' => $nombre,'3' => $primerApellido,'4' => $segundoApellido,'5' => $edad,'6' => $dni,'7' => $genero,'8' => $tipoDeMiembro,'9' => $pass];
		}
		else{
			$res=(object)['0' => 0,'1' => $user,'2' => $nombre,'3' => $primerApellido,'4' => $segundoApellido,'5' => $edad,'6' => $dni,'7' => $genero,'8' => $tipoDeMiembro,'9' => $pass];
		}
	}
	else{
		$res=(object)['0' => -1,'1' => $user,'2' => $nombre,'3' => $primerApellido,'4' => $segundoApellido,'5' => $edad,'6' => $dni,'7' => $genero,'8' => $tipoDeMiembro,'9' => $pass];
	}
	echo json_encode($res);
}
else if(isset($_POST['order']) && $_POST['order']==="signUp"){
    $nombreUsuario=sanitizeInput($connection,$_POST['nombreUsuario']);
	$nombre=sanitizeInput($connection,$_POST['nombre']);
	$primerApellido=sanitizeInput($connection,$_POST['primerApellido']);
	$segundoApellido=sanitizeInput($connection,$_POST['segundoApellido']);
	$edad=sanitizeInput($connection,$_POST['edad']);
	$dni=sanitizeInput($connection,$_POST['dni']);
	$tipoDeMiembro=sanitizeInput($connection,$_POST['tipoDeMiembro']);
	$genero=sanitizeInput($connection,$_POST['genero']);
	$pass=password_hash(sanitizeInput($connection,$_POST['password']),PASSWORD_DEFAULT);
	
	if($connection){
		$consulta = "INSERT INTO user (nombreUsuario,nombre,primerApellido,segundoApellido,edad,dni,genero,tipoDeMiembro,password) VALUES ('".$nombreUsuario."','".$nombre."','".$primerApellido."','".$segundoApellido."','".$edad."','".$dni."','".$genero."','".$tipoDeMiembro."','".$pass."')";
		mysqli_query($connection,$consulta) or die(mysqli_error($connection));
		
		$res=(object)['0' => 1,'1' => html_entity_decode($nombreUsuario),'2' => html_entity_decode($nombre),'3' => html_entity_decode($primerApellido),'4' => html_entity_decode($segundoApellido),'5' => $edad,'6' => html_entity_decode($dni),'7' => $genero,'8' => $tipoDeMiembro,'9' => $pass];
		
	}
	else{
		$res=(object)['0' => -1,'1' => $nombreUsuario,'2' => $nombre,'3' => $primerApellido,'4' => $segundoApellido,'5' => $edad,'6' => $dni,'7' => $genero,'8' => $tipoDeMiembro,'9' => $pass];
	}
	echo json_encode($res);
}

mysqli_close($connection);
?>