package com.zemrow.test.tts;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class RunFreeTTS {
    public static void main(String[] args) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        for (final Voice voice : VoiceManager.getInstance().getVoices()) {
            System.out.println("voice "+voice.getName()+", location "+voice.getLocale().getDisplayName());
            voice.allocate();
            for (String text : TestText.array) {
                System.out.println("text "+text);
                voice.speak(text);
            }
        }
    }
}
