<!DOCTYPE html>
<html lang="fr">
<head>
   
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire demande d'un document</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="Form.css">

</head>
<body>
    <div class="wrapper">
        <div class="two">
          <h1>ENSATé Docs 
            <span>obtenez vos documents en un seul clique !</span>
          </h1>
        </div>

        <form class= "form" method="post" enctype="multipart/form-data"> 
            <div class="input_field"> 
                <input  id="email" name="email" type="text" placeholder="Saisir votre email institutionnelle " value="<?php if(isset($_POST['email'])) { echo htmlentities($_POST['email']);}?>" /> 
                <input id="CIN" name="CIN" type="text" placeholder="Saisir votre CIN"  value="<?php if(isset($_POST['CIN'])) { echo htmlentities($_POST['CIN']);}?>" />
                <input  id="n_apogee"  type="text" name="code_apoge"  placeholder="Saisir votre code apogee"  value="<?php if(isset($_POST['code_apoge'])) { echo htmlentities($_POST['code_apoge']);}?>"/>
                <span id="availability"></span>
            </div>
            
            
            <div class="column">
                <div class="select-box">
                    <select id="list" name="choix_document" onchange="getSelectValue();" disabled>
                        <label for=""></label>
                        <option hidden value="" > Appuyer pour choisir votre document</option>
                        <option value="attestation de réussite"> Attestation de reussite</option>
                        <option value="attestation de scolarité">Attestation de scolarite</option>
                        <option value="convention de stage">Convention de stage</option>
                        <option value="relevé de notes">Releve de notes</option>
                    </select>
                        
                        <script>
                           function getSelectValue(){
                                var getSelectValue= document.getElementById("list").value ;
                                switch (getSelectValue) {
                                    case 'attestation de scolarité':
                                        document.getElementById('atr').style.display="none";
                                        document.getElementById('cvs').style.display="none";
                                        document.getElementById('releve').style.display="none";
                                        document.getElementById('submitBtn').style.marginTop="30px";
                                        break;
                                    case 'attestation de réussite':
                                        document.getElementById('atr').style.display="block";
                                        document.getElementById('cvs').style.display="none";
                                        document.getElementById('releve').style.display="none";
                                        document.getElementById('submitBtn').style.marginTop="120px";
                                        break;
                                    case 'convention de stage':
                                        document.getElementById('cvs').style.display="block";
                                        document.getElementById('atr').style.display="none";
                                        document.getElementById('releve').style.display="none";
                                        document.getElementById('submitBtn').style.marginTop="220px";
                                        break;
                                    case 'relevé de notes':
                                        document.getElementById('releve').style.display="block";
                                        document.getElementById('atr').style.display="none";
                                        document.getElementById('cvs').style.display="none";
                                        document.getElementById('submitBtn').style.marginTop="260px";
                                        break;
                                    default:
                                        break;
                                }
                            }
                            
                           
                        </script>

                        <div id="atr">
                            
                                <div class="select_field">
                                    <select id="list-année" name="atr_annee">
                                        <label for="">Année de l'Attestation</label>
                                        <option hidden value="">Choisissez quelle année ?</option>
                                        <option value="1" id="atr_1" disabled style="color:gray;">2ap1</option>
                                        <option value="2" id="atr_2" disabled style="color:gray;">2ap2</option>
                                        <option value="3" id="atr_3" disabled style="color:gray;">CI1</option>
                                        <option value="4" id="atr_4" disabled style="color:gray;">CI2</option>
                                        <option value="5" id="atr_5" disabled style="color:gray;">CI3</option>
                                    </select>
                                    <span id="non_att"></span>
                                </div>
                           
                        </div>

 
                        <div id="cvs" class="cvs" enctype="multipart/form-data">
                            <div class="input-field" >
                                <input id="name_entreprise" name="name_entreprise" type="text" placeholder="Entrer le nom de l'entreprise où vous allez passer le stage" disabled/> 
                            </div>

                            <div class="input-field">
                                <label>Date de début </label>
                                <input  id="start_day" name="start_day"  class="date" type="date" placeholder="Entrer la date  de début de votre stage" name="start_date" disabled/> 
                            </div>
                            <div class="input-field">
                                <label>Date de fin  </label>
                                <input type="date"  id="end_day" class="date" name="end_day" placeholder="Entrer la date  de fin de votre stage" name="end_date" disabled/> 
                            </div>
                            <div class="input-field">
                                <input type="text"  id="adresse_entreprise" name="adresse_entreprise" placeholder="Entrer l'adresse de l'entreprise " name="address_company" disabled/> 
                            </div>
                             <div class="input-field">
                                <input type="file"  id="logo_entreprise" name="logo_company" disabled/> 
                            </div>

                        </div>
                        <span id="non_stage"></span>

                        <div id="releve">
                            <label> Type du relevé </label>
                            <div class="column">
                                <div class="select-box">
                                <select id="typeReleve" name="typeReleve" onchange="getTypeReleve();">
                                    <label for=""></label>
                                    <option hidden value=""> Choisissez type du relevé</option>
                                    <option value="year"> Année</option>
                                    <option value="semester">Semestre</option>
                                </select>

                                <div id="yearSection">
                                    <label> Année du relevé</label>
                                    <div class="column">
                                        <div class="select-box">
                                    <select id="year" name="releve_year">
                                        <label for=""></label>
                                        <option hidden value=""> Choisissez quelle année</option>
                                        <option value="1" id="rlv_year_1" disabled style="color:gray;"  > 2ap1</option>
                                        <option value="2" id="rlv_year_2" disabled style="color:gray;"> 2ap2</option>
                                        <option value="3"  id="rlv_year_3" disabled style="color:gray;"> Ci1</option>
                                        <option value="4"  id="rlv_year_4" disabled style="color:gray;"> Ci2</option>
                                        <option value="5" id="rlv_year_5" disabled style="color:gray;"> Ci3</option>
                                        
                                    </select>
                                    <span id="non_year"></span>
                                        </div>
                                    
                                    </div>
                                </div>
        
                                <div id="semesterSection">
                                    <label> Semestre du relevé </label>
                                    <div class="column">
                                        <div class="select-box">
                                    <select id="semester" name="releve_semester">
                                        <label for=""></label>
                                        <option hidden> Choisissez quel semestre</option>
                                        <option value="1"  id="rlv_semestre_1" disabled style="color:gray;"> S1</option>
                                        <option value="2" id="rlv_semestre_2" disabled style="color:gray;"> S2</option>
                                        <option value="3" id="rlv_semestre_3" disabled style="color:gray;"> S3</option>
                                        <option value="4" id="rlv_semestre_4" disabled style="color:gray;"> S4</option>
                                        <option value="5" id="rlv_semestre_5" disabled style="color:gray;"> S5</option>
                                        <option value="6" id="rlv_semestre_6" disabled style="color:gray;"> S6</option>
                                        <option value="7" id="rlv_semestre_7" disabled style="color:gray;"> S7</option>
                                        <option value="8" id="rlv_semestre_8" disabled style="color:gray;"> S8</option>
                                        <option value="9"  id="rlv_semestre_9" disabled style="color:gray;"> S9</option>
                                    </select>
                                    <span id="non_semester"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <span id="error"></span>
            <input type="submit" id="sendBtn" class="botton_submit" name="submit_form" value="Envoyez votre demande" disabled>
        </form>
</script>


 <script>
     
      </script>

  <script>
           $(document).ready(function(){
            $("#CIN").blur(function(){
                var email = document.getElementById("email").value;
                var code_apoge= document.getElementById("n_apogee").value;
                var CIN= $(this).val();
                console.log(CIN);
                $.ajax({
                    url:"check_availability.php",
                    method:"POST",
                    data:{code_apoge:code_apoge,email:email,CIN:CIN},
                    success:function(data){
                       $('#availability').html(data);
                       
                    }
                })
            })
        })
        
       $(document).ready(function(){
            $("#email").blur(function(){
                var CIN= document.getElementById("CIN").value;
                var code_apoge= document.getElementById("n_apogee").value;
                var email= $(this).val();
                $.ajax({
                    url:"check_availability.php",
                    method:"POST",
                    data:{code_apoge:code_apoge,email:email,CIN:CIN},
                    success:function(data){
                       $('#availability').html(data);
                       
                    }
                })
            })
        })
        
    $(document).ready(function(){
    $("#n_apogee").blur(function(){
        var email = document.getElementById("email").value;
        var CIN= document.getElementById("CIN").value;
        var code_apoge= $(this).val();
        console.log(code_apoge);
        $.ajax({
            url:"check_availability.php",
            method:"POST",
            data:{code_apoge:code_apoge,email:email,CIN:CIN},
            success:function(data){
               $('#availability').html(data);
               
            }
        })
    })
})

</script>
<script>
    $(document).ready(function(){
    $("#list").blur(function(){
        var code_apoge= document.getElementById("n_apogee").value;
        var type= document.getElementById("list").value;
        console.log(type + " type")
        var code_apoge= document.getElementById("n_apogee").value;
        switch (type) {
            case 'attestation de scolarité': 
                document.getElementById("error").innerHTML="";
                break;
            case 'attestation de réussite':
                document.getElementById("error").innerHTML="";
                    $.ajax({
                    url:"check_annee_att.php",
                    method:"POST",
                    data:{code_apoge:code_apoge},
                    success:function(data){
                    $('#non_att').html(data);
                    }
                    })
                break;
            case 'convention de stage':
            document.getElementById("error").innerHTML="";
                    $.ajax({
                    url:"check_stage.php",
                    method:"POST",
                    data:{code_apoge:code_apoge},
                    success:function(data){
                    $('#availability').html(data);
                     }
                    })
                break;
             case 'relevé de notes':
            document.getElementById("error").innerHTML="";
             $(document).ready(function(){
                $("#typeReleve").blur(function(){
                    var typeReleve = document.getElementById("typeReleve").value;
                    var code_apoge= document.getElementById("n_apogee").value;
                    document.getElementById("error").innerHTML="";
                    console.log(typeReleve);
                    switch(typeReleve){
                    case 'semester':
                    $.ajax({
                    url:"check_releve_semester.php",
                    method:"POST",
                    data:{code_apoge:code_apoge},
                    success:function(data){
                    $('#non_semester').html(data);
                     }
                    })
                    break;
                    case 'year':
                        console.log("je suis year " + code_apoge);
                    $.ajax({
                    url:"check_releve_year.php",
                    method:"POST",
                    data:{code_apoge:code_apoge},
                    success:function(data){
                    $('#non_year').html(data);
                     }
                    })
                    break;

                }
                        })
                    })
                break;
        }
        
    })
})

    


</script>
    
</body>
</html>

<script>
                            
    function getTypeReleve(){
         var getTypeReleve= document.getElementById("typeReleve").value ;
         switch (getTypeReleve) {
             case 'year':
                 document.getElementById('yearSection').style.display="block";
                 document.getElementById('semesterSection').style.display="none";
                 break;
             case 'semester':
                 document.getElementById('semesterSection').style.display="block";
                 document.getElementById('yearSection').style.display="none";
                 break;
             default:
                 break;
         }
     }
     
    </script>

<?php
include 'conn.php';

   if(isset($_POST['submit_form'])){
    if(isset($_POST['email']) && isset($_POST['CIN']) && isset($_POST['code_apoge']) ){
      if(!empty($_POST['email']) && !empty($_POST['CIN']) && !empty($_POST['code_apoge'])  ){
        $email=htmlspecialchars($_POST['email']);
        $cin=htmlspecialchars($_POST['CIN']);
        $codeApoge=htmlspecialchars($_POST['code_apoge']);

        $req1=$db->query("SELECT * FROM etudiants WHERE email= '$email'");
        $res1=$req1->fetch();
        if($res1){
          $req2=$db->query("SELECT * FROM etudiants WHERE email= '$email' AND cin='$cin' ");
          $res2=$req2->fetch();
          if($res2){
            $req3=$db->query("SELECT * FROM etudiants WHERE email= '$email' AND cin='$cin' AND n_apogee = '$codeApoge' ");
            $res3=$req3->fetch();
            if($res3){
              if(!empty($_POST['choix_document'])){
                $selected_doc = $_POST['choix_document'];
                // cas attestation de reussite -----------------------------------------------
                if($selected_doc=='attestation de réussite'){
                    if(!empty($_POST['atr_annee']) && isset($_POST['atr_annee'])){
                        $atr_annee=$_POST['atr_annee'];
                        $req4=$db->query("SELECT  actual_semester FROM etudiants WHERE email= '$email' ");
                        $res4=$req4->fetch();
                        $actual_year= (int)($res4['actual_semester']/2 + 1);
                        if($res4){
                        if($atr_annee<$actual_year ){
                            echo '<script > swal("Demande envoyée avec succès! ", "Votre demande a été bien enregistrer", "success"); </script>';
                             $insert=$db->query("INSERT INTO documents (type ,n_apogee, statut) VALUES ('$selected_doc', '$codeApoge' , 'n_traite')");
                             $LAST_ID = $db->lastInsertId();
                             $insert=$db->query("INSERT INTO atr (id_doc ,year) VALUES ( $LAST_ID , $atr_annee )");

                            }
                        else 
                        echo '<script > swal("Erreur !", "Vous êtes en '. $actual_year .'ème année. Vous n\'avez pas le droit d avoir l\'attestation du '. $atr_annee .'ème année" , "error"); </script>';

                        }
                        else echo '<script > swal("Erreur  ","une erreur est survenue ", "error"); </script>';
                    }
                    else echo '<script > swal("Erreur  ","vous devez obligatoirement  préciser l\'année de l\'attestation de réussite desirée !", "error"); </script> ';
                    
                }
                // attestation de scolarité -----------------------------------------------
                else if($selected_doc=='attestation de scolarité'){
                    $insert=$db->query("INSERT INTO documents (type ,n_apogee, statut) VALUES ('$selected_doc', '$codeApoge' , 'n_traite')");
                    $LAST_ID = $db->lastInsertId();
                    echo '<script > swal("Demande envoyée avec succès! ", "Votre demande a été bien enregistrer", "success"); </script>';
                }

                // cas convention de stage  -----------------------------------------------
                else if($selected_doc=='convention de stage'){
                    if(!empty($_POST['name_entreprise']) && !empty($_POST['start_day']) && !empty($_POST['end_day']) &&!empty($_POST['adresse_entreprise'])  && 
                     isset($_POST['name_entreprise'])  && isset($_POST['start_day']) && isset($_POST['end_day'])  && isset($_POST['adresse_entreprise'])){
                        $company_name=$_POST['name_entreprise'];
                        $start_date =$_POST['start_day'] ;
                        $end_date = $_POST['end_day'] ;
                        $adresse_entreprise = $_POST['adresse_entreprise'] ;
                        $logo_company=$_FILES['logo_company']['name'];
                        $req5=$db->query("SELECT actual_semester FROM etudiants WHERE email= '$email' ");
                        $res5=$req5->fetch();
                        $actual_year= (int)($res5['actual_semester']/2 + 1);
                        if($res5['actual_semester']>=5){
                                $extension_valides=array('jpg','jpeg','png','gif');
                                $extension=strtolower(substr(strrchr($logo_company,'.'),1));
                            if (in_array($extension,$extension_valides)) {
                                echo '<script > swal("Demande envoyée avec succès! ", "Votre demande a été bien enregistrée", "success"); </script>';
                                $insert=$db->query("INSERT INTO documents (type ,n_apogee, statut) VALUES ('$selected_doc', '$codeApoge' , 'n_traite')");
                                $LAST_ID = $db->lastInsertId();
                                $insert=$db->query("INSERT INTO cvs (id_doc ,company_name ,start_date ,end_date , address_company ) VALUES ( $LAST_ID ,'$company_name' ,'$start_date' ,'$end_date' ,'$adresse_entreprise' )");
                                $upload="logo_company/".$LAST_ID.".png";
                                move_uploaded_file($_FILES['logo_company']['tmp_name'],$upload);
                            
                           }
                           else echo ' <script > swal("Erreur !", "Le format du logo doit etre png,jpg,jpeg ou gif !" , "error"); </script> ';

                    }
                        else echo ' <script > swal("Erreur !", "Vous êtes en '. $actual_year .'ème année.  Vous n\'avez pas le droit d\'avoir une convention de stage !" , "error"); </script> ';

                     }
                    else  echo ' <script > swal("Erreur  ","Vous devez remplir obligatoirement les données concernant votre stage !", "error"); </script> ';
                }
                
                // -Relevé de notes ------------------------------------------------------------------------------
                else if ($selected_doc=='relevé de notes'){
                    if(!empty($_POST['releve_year']) && isset($_POST['releve_year'])){
                        $req6=$db->query("SELECT actual_semester, start_year FROM etudiants WHERE email= '$email' ");
                        $res6=$req6->fetch();
                        $start_year=$res6['start_year'];
                        $releve_year=$_POST['releve_year'];
                        $actual_year= (int)($res6['actual_semester']/2 + 1);
                        if($releve_year < $actual_year ){
                            if( $releve_year<3 && $start_year==1){
                                echo ' <script > swal("Erreur !", "Vous avez accedé à l\'ENSA à travers le CNC . Vous n\'avez pas le relevé de notes des deux années préparatoires " , "error"); </script>';
                            }
                            else {
                            echo '<script > swal("Demande envoyée avec succès! ", "Votre demande a été bien enregistrer", "success"); </script>';
                            $insert=$db->query("INSERT INTO documents (type ,n_apogee, statut) VALUES ('$selected_doc', '$codeApoge' , 'n_traite')");
                            $LAST_ID = $db->lastInsertId();
                            $insert=$db->query("INSERT INTO releve (id_doc ,year , semester ) VALUES ( $LAST_ID , $releve_year  , -1)");
                            }
                            
                        }
                        else echo ' <script > swal("Erreur !", "Vous êtes en '.$actual_year.'ème année. Vous n\'avez pas le droit d\'avoir le relevé de notes du '.$releve_year.'ème année!" , "error"); </script> ';



                    }
                    else if(!empty($_POST['releve_semester']) && isset($_POST['releve_semester'])){
                        $req7=$db->query("SELECT  actual_semester, start_year FROM etudiants WHERE email= '$email' ");
                        $res7=$req7->fetch();
                        $start_year=$res7['start_year'];
                        $releve_semester=$_POST['releve_semester'];
                        if($_POST['releve_semester']<$res7['actual_semester'] ){
                            if( $releve_semester<5 && $start_year==1){
                                echo ' <script > swal("Erreur !", "Vous êtes accedé à l\'ENSA à travers le CNC . Vous n\'avez pas le relevé de notes des deux années préparatoires" , "error"); </script>';
                            }
                            else {
                            echo '<script > swal("Demande envoyée avec succès! ", "Votre demande a été bien enregistrer", "success"); </script>';
                            $insert=$db->query("INSERT INTO documents (type ,n_apogee, statut) VALUES ('$selected_doc', '$codeApoge' , 'n_traite')");
                            $LAST_ID = $db->lastInsertId();
                            $insert=$db->query("INSERT INTO releve (id_doc ,year , semester ) VALUES ( $LAST_ID , -1 ,$releve_semester)");
                         
                           }
                        }
                        else echo ' <script > swal("Erreur !", "Vous êtes en S'.$res7['actual_semester'] .'. Vous n\'avez pas le droit d\'avoir le relevé de notes du S'.$releve_semester.'" , "error"); </script>';




                    }
                    else echo '<script > swal("Erreur !","Vous devez obligatoirement selectionner soit l\'année ou le semestre !", "error"); </script> ';
                }
            }
            else echo '<script > swal("Erreur !","Vous devez obligatoirement selectionner quel document vous souhaitez obtenir !", "error"); </script> ';
        }
           
                else echo '<script > swal("Erreur !","Vos donnees est invalide , Ressayez !", "error"); </script> ';
          }
          else echo '<script > swal("Erreur !"," l\'adresse email et le CIN ne se coincide pas !! , Ressayez !", "error"); </script> ';
          
        }
        else echo ' <script > swal("Erreur !","Cette adresse email n\'exite pas !!, Ressayez !", "error"); </script> ';
      }
      else echo '<script > swal("Erreur !","Remplissez tous les champs avant d\'envoyer votre demande !!", "error"); </script> ';
    }
}

  
  ?>