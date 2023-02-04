<?php
include 'conn.php';
if (!empty($_POST["code_apoge"])) {
    $code_apoge = $_POST["code_apoge"];
    $query = $db->query("SELECT * FROM etudiants WHERE n_apogee='$code_apoge' limit 1");
    $result1 = $query->fetch();

    if ($result1) {
       
            if ($result1["actual_semester"] == 1  ) {
            echo "<script>document.getElementById('error').innerHTML='Vous etes dans le premier semestre ,vous ne pouvez pas demander le relevé de notes du premier semestre . '</script>";
            }
            if ($result1["actual_semester"] == 2) {
                 ?>
                <script> 
                document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                </script>
                <?php
            } else if ($result1["actual_semester"] == 3) {
                ?>
                   <script> 
                document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                   </script>
                <?php
            } else if ($result1["actual_semester"] == 4) {
                ?>  
                 <script> 
                   document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                 </script>
                 <?php
            } else if ($result1["actual_semester"] == 5) {
                 ?>
                 <script>
                 document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                document.getElementById("rlv_semestre_4").disabled=false 
                document.getElementById("rlv_semestre_4").style.color="blue";
                </script>
                 <?php
            } else if ($result1["actual_semester"] == 6) {
                 ?>  
                <script> 
                document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                document.getElementById("rlv_semestre_4").disabled=false 
                document.getElementById("rlv_semestre_4").style.color="blue";
                document.getElementById("rlv_semestre_5").disabled=false 
                document.getElementById("rlv_semestre_5").style.color="blue";
                 </script>
                 <?php
            } else if ($result1["actual_semester"] == 7) {
                 ?>  
                <script> 
                document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                document.getElementById("rlv_semestre_4").disabled=false 
                document.getElementById("rlv_semestre_4").style.color="blue";
                document.getElementById("rlv_semestre_5").disabled=false 
                document.getElementById("rlv_semestre_5").style.color="blue";
                document.getElementById("rlv_semestre_6").disabled=false 
                document.getElementById("rlv_semestre_6").style.color="blue";
                </script>
                <?php
            } else if ($result1["actual_semester"] == 8) {
                ?>  
                <script> 
                document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                document.getElementById("rlv_semestre_4").disabled=false 
                document.getElementById("rlv_semestre_4").style.color="blue";
                document.getElementById("rlv_semestre_5").disabled=false 
                document.getElementById("rlv_semestre_5").style.color="blue";
                document.getElementById("rlv_semestre_6").disabled=false 
                document.getElementById("rlv_semestre_6").style.color="blue";
                document.getElementById("rlv_semestre_7").disabled=false 
                document.getElementById("rlv_semestre_7").style.color="blue";
                </script>
                <?php
            } else if ($result1["actual_semester"] == 9) {
                ?>  
                <script> 
                document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                document.getElementById("rlv_semestre_4").disabled=false 
                document.getElementById("rlv_semestre_4").style.color="blue";
                document.getElementById("rlv_semestre_5").disabled=false 
                document.getElementById("rlv_semestre_5").style.color="blue";
                document.getElementById("rlv_semestre_6").disabled=false 
                document.getElementById("rlv_semestre_6").style.color="blue";
                document.getElementById("rlv_semestre_7").disabled=false 
                document.getElementById("rlv_semestre_7").style.color="blue";
                document.getElementById("rlv_semestre_8").disabled=false 
                document.getElementById("rlv_semestre_8").style.color="blue";
                </script>
                <?php
            } else if ($result1["actual_semester"] == 10) {
                ?>  
                <script> 
                document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                document.getElementById("rlv_semestre_4").disabled=false 
                document.getElementById("rlv_semestre_4").style.color="blue";
                document.getElementById("rlv_semestre_5").disabled=false 
                document.getElementById("rlv_semestre_5").style.color="blue";
                document.getElementById("rlv_semestre_6").disabled=false 
                document.getElementById("rlv_semestre_6").style.color="blue";
                document.getElementById("rlv_semestre_7").disabled=false 
                document.getElementById("rlv_semestre_7").style.color="blue";
                document.getElementById("rlv_semestre_8").disabled=false 
                document.getElementById("rlv_semestre_8").style.color="blue";
                document.getElementById("rlv_semestre_9").disabled=false 
                document.getElementById("rlv_semestre_9").style.color="blue";
                </script>
                <?php
            } else if ($result1["actual_semester"] > 10) {
                ?> 
                  <script> 
                  document.getElementById("rlv_semestre_1").disabled=false 
                document.getElementById("rlv_semestre_1").style.color="blue";
                document.getElementById("rlv_semestre_2").disabled=false 
                document.getElementById("rlv_semestre_2").style.color="blue";
                document.getElementById("rlv_semestre_3").disabled=false 
                document.getElementById("rlv_semestre_3").style.color="blue";
                document.getElementById("rlv_semestre_4").disabled=false 
                document.getElementById("rlv_semestre_4").style.color="blue";
                document.getElementById("rlv_semestre_5").disabled=false 
                document.getElementById("rlv_semestre_5").style.color="blue";
                document.getElementById("rlv_semestre_6").disabled=false 
                document.getElementById("rlv_semestre_6").style.color="blue";
                document.getElementById("rlv_semestre_7").disabled=false 
                document.getElementById("rlv_semestre_7").style.color="blue";
                document.getElementById("rlv_semestre_8").disabled=false 
                document.getElementById("rlv_semestre_8").style.color="blue";
                document.getElementById("rlv_semestre_9").disabled=false 
                document.getElementById("rlv_semestre_9").style.color="blue";
                document.getElementById("rlv_semestre_10").disabled=false 
                document.getElementById("rlv_semestre_10").style.color="blue";
                </script>
                <?php
            }
        


    }


}