<?php 
$host="localhost";
$master="";
$pass="";
$database="gestor_datos";
$connection = mysqli_connect($host, $master, $pass, $database);
mysqli_set_charset($connection,"utf8");
?>
