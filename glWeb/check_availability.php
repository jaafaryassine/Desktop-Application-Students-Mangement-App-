

<?php


include 'conn.php';



if (!empty($_POST["code_apoge"]) && !empty($_POST["CIN"]) && !empty($_POST["email"])) {
    $code_apoge = $_POST["code_apoge"];
    $email = $_POST["email"];
    $CIN = $_POST["CIN"];
    $query = $db-> prepare("SELECT * FROM etudiants WHERE n_apogee=? and email=? and cin=? limit 1");
    $query->execute(array($code_apoge,$email,$CIN));
    $result1 = $query->fetch();
    if ($result1) { ?>    

        <script> 
        document.getElementById("list").disabled=false 
        document.getElementById("sendBtn").disabled=false
        document.getElementById("sendBtn").style.backgroundColor="rgb(130, 106, 251)";
        </script>
        
        <?php }
        else{
        echo "<span style='color:red;'>Erreur ! Cet étudiant est introuvable</span>" ;
        ?>
        <script> 
            document.getElementById("list").disabled=true
            document.getElementById("sendBtn").disabled=true
            document.getElementById("sendBtn").style.backgroundColor="grey";

        </script>
        <?php }
}?>
        
                                       
