

<?php
include 'conn.php';
if (!empty($_POST["code_apoge"])) {
    $code_apoge = $_POST["code_apoge"];
    $query = $db->query("SELECT * FROM etudiants WHERE n_apogee='$code_apoge'limit 1");
    $result1 = $query->fetch();
    if ($result1) {
       
        if($result1["actual_semester"]<=2){
            echo "<script>document.getElementById('error').innerHTML='Vous êtes en première année, vous ne pouvez pas demander l\'attestatation de reussite.'</script>";
            
           
            echo "<span style='color:red;'> </span>";
        }
        else if( $result1["actual_semester"]<=3){
            ?>
            <script> 
            document.getElementById("atr_1").disabled=false 
            document.getElementById("atr_1").style.color="blue";
            </script>
            <?php
              }
           else if ($result1["actual_semester"]<=5) {
            ?>
               <script> 
            document.getElementById("atr_1").style.color="blue";
            document.getElementById("atr_1").disabled=false  
            document.getElementById("atr_2").disabled=false
            document.getElementById("atr_2").style.color="blue";
               </script>
            <?php
            }
            else if( $result1["actual_semester"]<=7){
             ?>  
             <script> 
            document.getElementById("atr_1").style.color="blue";
             document.getElementById("atr_1").disabled=false 
             document.getElementById("atr_2").disabled=false 
             document.getElementById("atr_2").style.color="blue";
             document.getElementById("atr_3").disabled=false 
             document.getElementById("atr_3").style.color="blue";
             </script>

             <?php 
             }
             else if( $result1["actual_semester"]<=9){
             ?>
             <script>
             document.getElementById("atr_1").disabled=false 
             document.getElementById("atr_1").style.color="blue";
            document.getElementById("atr_2").disabled=false 
            document.getElementById("atr_2").style.color="blue";
             document.getElementById("atr_3").disabled=false 
             document.getElementById("atr_3").style.color="blue";
             document.getElementById("atr_4").disabled=false
             document.getElementById("atr_4").style.color="blue";
            </script>
             <?php 
             }
             else if( $result1["actual_semester"]>10){
             ?> 
              <script> 
             document.getElementById("atr_1").disabled=false 
             document.getElementById("atr_1").style.color="blue";
           document.getElementById("atr_2").disabled=false 
           document.getElementById("atr_2").style.color="blue";
            document.getElementById("atr_3").disabled=false 
            document.getElementById("atr_3").style.color="blue";
            document.getElementById("atr_4").disabled=false 
            document.getElementById("atr_4").style.color="blue";
           document.getElementById("atr_5").disabled=false
           document.getElementById("atr_5").style.color="blue";
            </script>
            <?php 
             }
             }








        }

?>    
        

