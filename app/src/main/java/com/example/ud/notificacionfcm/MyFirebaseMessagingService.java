package com.example.ud.notificacionfcm;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if(remoteMessage.getData().size() > 0){
            Log.e("MFC",remoteMessage.getData().toString());
            Log.e("MFC",remoteMessage.getData().get("MyTitle"));
            Log.e("MFC",remoteMessage.getData().get("MyMessage"));
        }
        if(remoteMessage.getNotification()!= null){
            Log.e("Titulo: ",remoteMessage.getNotification().getTitle());
            Log.e("Mensaje: ",remoteMessage.getNotification().getBody());
        }
    }

    /*
    public void notificar(RemoteMessage remoteMessage){
        String ns = Context.NOTIFICATION_SERVICE;
        String CHANNEL_ID = "ud.com.ANDROID";
        NotificationManager notManager = (NotificationManager) getSystemService(ns);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "ANDROID CHANNEL";
            String descripcion = "Canal de Notificaciones de ANDROID para la UD";
            int  Importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,Importance);
            channel.setDescription(descripcion);
            notManager.createNotificationChannel(channel);
        }
        int icono = android.R.drawable.stat_sys_warning;
        CharSequence textEstado = "Atencion!!!";
        CharSequence titulo = remoteMessage.getNotification().getTitle();
        CharSequence descripcion = remoteMessage.getNotification().getBody();
        long hora = System.currentTimeMillis();
        Context contexto = getApplicationContext();
        Intent notIntent = new Intent(contexto, MainActivity.class);
        PendingIntent conIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);

        NotificationCompat.Builder nBuilder = (NotificationCompat.Builder)
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(icono)
                        .setLargeIcon((((BitmapDrawable)getResources().getDrawable(R.drawable.info)).getBitmap()))
                        .setContentTitle(titulo)
                        .setContentText(descripcion)
                        .setContentInfo(textEstado)
                        .setWhen(hora)
                        .setContentIntent(conIntent)
                        .setAutoCancel(true)
                        .setColor(getResources().getColor(R.color.common_google_signin_btn_text_dark))
                        .setVibrate(new long[]{100,250,100,500})
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        notManager.notify(1, nBuilder.build());
    }// cierre metodo noti04
*/




    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.e("Mi token es: ",s);
    }
}//MyFirebaseMessagingService