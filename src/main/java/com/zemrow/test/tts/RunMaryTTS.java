package com.zemrow.test.tts;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.util.data.audio.AudioPlayer;

import javax.sound.sampled.AudioInputStream;
import java.util.Locale;

public class RunMaryTTS {
    public static void main(String[] args) throws Exception {
        final MaryInterface marytts = new LocalMaryInterface();
        for (String voice : marytts.getAvailableVoices()) {
            marytts.setVoice(voice);
            System.out.println("voice " + voice + ", location " + marytts.getLocale().getDisplayName());
            for (String text : TestText.array) {
                System.out.println("text " + text);
                final AudioInputStream audio = marytts.generateAudio(text);
                AudioPlayer audioPlayer = new AudioPlayer();
                audioPlayer.setAudio(audio);
                audioPlayer.start();
                audioPlayer.join();
            }
        }
    }
}
