<?php
include 'conn.php';
if (!empty($_POST["code_apoge"])) {
    $code_apoge = $_POST["code_apoge"];
    $query = $db->query("SELECT * FROM etudiants WHERE n_apogee='$code_apoge' limit 1");
    $result1 = $query->fetch();
  

    if ($result1) {
    
    
        if($result1["actual_semester"]<2){
            echo "<script>document.getElementById('error').innerHTML='Vous etes dans la premiere année ,vous ne pouvez pas demander le relevé de notes de la première année.'</script>";
        }
        if( $result1["actual_semester"]<=3  && $result1["start_year"]==0){
            ?>
            <script> 
            document.getElementById("rlv_year_1").disabled=false 
            document.getElementById("rlv_year_1").style.color="blue";
            </script>
            <?php
              }
           else if ($result1["actual_semester"]<=5) {
            ?>
               <script> 
            document.getElementById("rlv_year_1").style.color="blue";
            document.getElementById("rlv_year_1").disabled=false  
            document.getElementById("rlv_year_2").disabled=false
            document.getElementById("rlv_year_2").style.color="blue";
               </script>
            <?php
            }
            else if( $result1["actual_semester"]<=7){
             ?>  
             <script> 
            document.getElementById("rlv_year_1").style.color="blue";
             document.getElementById("rlv_year_1").disabled=false 
             document.getElementById("rlv_year_2").disabled=false 
             document.getElementById("rlv_year_2").style.color="blue";
             document.getElementById("rlv_year_3").disabled=false 
             document.getElementById("rlv_year_3").style.color="blue";
             </script>

             <?php 
             }
             else if( $result1["actual_semester"]<=9){
             ?>
             <script>
             document.getElementById("rlv_year_1").disabled=false 
             document.getElementById("rlv_year_1").style.color="blue";
            document.getElementById("rlv_year_2").disabled=false 
            document.getElementById("rlv_year_2").style.color="blue";
             document.getElementById("rlv_year_3").disabled=false 
             document.getElementById("rlv_year_3").style.color="blue";
             document.getElementById("rlv_year_4").disabled=false
             document.getElementById("rlv_year_4").style.color="blue";
            </script>
             <?php 
             }
             else if( $result1["actual_semester"]>10){
             ?> 
              <script> 
             document.getElementById("rlv_year_1").disabled=false 
             document.getElementById("rlv_year_1").style.color="blue";
           document.getElementById("rlv_year_2").disabled=false 
           document.getElementById("rlv_year_2").style.color="blue";
            document.getElementById("rlv_year_3").disabled=false 
            document.getElementById("rlv_year_3").style.color="blue";
            document.getElementById("rlv_year_4").disabled=false 
            document.getElementById("rlv_year_4").style.color="blue";
           document.getElementById("rlv_year_5").disabled=false
           document.getElementById("rlv_year_5").style.color="blue";
            </script>
            <?php 
             }
             }




}