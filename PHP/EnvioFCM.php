<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        define('API_ACCESS_KEY','AAAAypFFEys:APA91bFU7KGBUSn4Z3DgtWGfxUg09TG0NAwn6-RH1U292Vjz_GMvmbGZSRPucveV-Ymrf4k7MxKzxQk189SznGgQPG8ESoQJZbRzV1yW6yKVcyjULdj5wP3IJXxRz48C6GiWdiTMIQD8');
        $registrationIds=["fCOMOfC7RGm-VmOm0v9liS:APA91bHpqoEOycGKHxmNbP1eQQNPpNY_jzBTmFO3Kv1tU__K1QKqwkzEK0VvsxciaoICtyzHLfxutBd6RRXBPXnPFKH5GEUq3zhBpNLjCw3zsBaQ8sY5GYUnswA_Cq7vdJbLEPCSOWIC"];
        $msg=[
            'title' => 'Programacion en Android',
            'body'=> 'Prueba 2'
        ];
		$headers = [
			'Authorization: key=' .API_ACCESS_KEY,
			'Content-Type: application/json'
		];
        $fields = [
            'registration_ids' => $registrationIds,
            'body'=> $msg
        ];
        $fields = json_encode($fields);
        $ch = curl_init();
        curl_setopt($ch,CURLOPT_URL,'https://fcm.googleapis.com/fcm/send');
        curl_setopt($ch,CURLOPT_POST,true);
        curl_setopt($ch,CURLOPT_HTTPHEADER,$headers);
        curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
        curl_setopt($ch,CURLOPT_SSL_VERIFYPEER,false);
        curl_setopt($ch,CURLOPT_POSTFIELDS,$fields);
        $result = curl_exec($ch);
        curl_close($ch);
        echo $result;
        echo 'Envio de mensaje satisfactorio';
        ?>
    </body>
</html>
