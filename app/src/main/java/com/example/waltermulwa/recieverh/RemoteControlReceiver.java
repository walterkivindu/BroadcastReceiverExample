package com.example.waltermulwa.recieverh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import com.example.waltermulwa.recieverh.RecieverH;

/**
 * Created by Walter Mulwa on 2/15/2018.
 */

public class RemoteControlReceiver extends BroadcastReceiver {

    RecieverH rc;



    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            /* handle media button intent here by reading contents */
            /* of EXTRA_KEY_EVENT to know which key was pressed    */


            KeyEvent event = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);

            if (event == null) {
                return;
            } else {
                Log.e("Message:", "**************************Button Pressed*******************");
                Toast.makeText(context,"Button Pressed",Toast.LENGTH_LONG).show();
                //AudioManager audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

                //audioManager.setMode(AudioManager.STREAM_MUSIC);
               // audioManager.setSpeakerphoneOn(true);
                String path = "/sdcard/harmo.mp3";
                MediaPlayer mp;
                //mp = MediaPlayer.create(context, Uri.parse(path));

                mp = new MediaPlayer();
                mp = MediaPlayer.create(context, R.raw.beep1);
                if(! mp.isPlaying()){
                    mp.start();
                }



            }

        }
    }
}