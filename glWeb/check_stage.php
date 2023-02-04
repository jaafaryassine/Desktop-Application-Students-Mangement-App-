<?php
include 'conn.php';
if (!empty($_POST["code_apoge"])) {
    $code_apoge = $_POST["code_apoge"];
    $query = $db->query("SELECT * FROM etudiants WHERE n_apogee='$code_apoge'limit 1");
    $result1 = $query->fetch();

    if ($result1) {
        
        if ($result1["actual_semester"]>=5) {
             ?>
            <script> 
            document.getElementById("name_entreprise").disabled=false ;
            document.getElementById("start_day").disabled=false;
            document.getElementById("end_day").disabled=false ;
            document.getElementById("adresse_entreprise").disabled=false;
            document.getElementById("logo_entreprise").disabled=false;

            </script>
             <?php
            } 
        else {
            echo "<script>document.getElementById('error').innerHTML='Vous ne pouvez pas demander la convention de stage, vous n\'etes pas dans le cycle d\'ingenieur.'</script>";
        }

    }
}
        ?>
