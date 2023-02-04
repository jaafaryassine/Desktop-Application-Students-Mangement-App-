<?php 
try{
	$db=new PDO('mysql:host=localhost;dbname=gl','root','');
}catch (Exception $e) {
    echo $e->getMessage();
}
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$db->exec("set names utf8");
?>