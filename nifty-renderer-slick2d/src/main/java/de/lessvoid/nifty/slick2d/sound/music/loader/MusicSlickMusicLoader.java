package de.lessvoid.nifty.slick2d.sound.music.loader;

import de.lessvoid.nifty.slick2d.sound.music.MusicSlickMusicHandle;
import de.lessvoid.nifty.slick2d.sound.music.SlickLoadMusicException;
import de.lessvoid.nifty.slick2d.sound.music.SlickMusicHandle;
import de.lessvoid.nifty.sound.SoundSystem;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import javax.annotation.Nonnull;

/**
 * The Slick music loader that uses Slick music objects for playing the music.
 *
 * @author Martin Karing &lt;nitram@illarion.org&gt;
 */
public final class MusicSlickMusicLoader implements SlickMusicLoader {
  /**
   * Load the music.
   */
  @Nonnull
  @Override
  public SlickMusicHandle loadMusic(
      final SoundSystem soundSystem, final String filename) throws SlickLoadMusicException {

    try {
      return new MusicSlickMusicHandle(soundSystem, new Music(filename, true));
    } catch (@Nonnull final SlickException e) {
      throw new SlickLoadMusicException("Loading the music \"" + filename + "\" failed.", e);
    }
  }

}
