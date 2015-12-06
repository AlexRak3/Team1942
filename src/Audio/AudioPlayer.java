package Audio;

import java.io.InputStream;

import javax.sound.sampled.*;

public class AudioPlayer {
private Clip clip;

	public AudioPlayer(String s){
		try{
			AudioInputStream ais =
					AudioSystem.getAudioInputStream(
							getClass().getResourceAsStream(s));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
			AudioFormat.Encoding.PCM_SIGNED,
			baseFormat.getSampleRate(),
			16,
			baseFormat.getChannels(),
			baseFormat.getChannels() * 2,
			baseFormat.getSampleRate(),
			false
			);
			AudioInputStream dais = 
					AudioSystem.getAudioInputStream(
							decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			
		}catch(Exception e ){
			e.printStackTrace();
		}
	}//end of audioPlayer
	/**
	 * plays the clip
	 */
	public void play(){
		if(clip == null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}//end of play
	/**
	 * stop playing the clip
	 */
	public void stop(){
		if(clip.isRunning()) clip.stop();
	}
	/**
	 * closes the clip
	 */
	public void close(){
		stop();
		clip.close();
	}
}//end of class
