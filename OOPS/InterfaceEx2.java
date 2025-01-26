interface Camera {
    void takePhoto();

    void recordVideoes();

    // Default Method
    default void cameraInfo() {
        System.out.println("This device has a 12 MP camera.");
    }
}

interface MusicPlayer {
    void playMusic();

    void stopMusic();

    // Static Method
    static void musicInfo() {
        System.out.println("Supports MP3 and WAV formats.");
    }
}

class OperatingSystem {
    public void Os() {
        System.out.println("Operating System is: IOS");
    }
}

class SmartPhone extends OperatingSystem implements Camera, MusicPlayer {

    @Override
    public void playMusic() {
        System.out.println("Playing music on the smartphone...");
    }

    @Override
    public void stopMusic() {
        System.out.println("Music playback stopped.");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking a photo using the smartphone camera...");
    }

    @Override
    public void recordVideoes() {
        System.out.println("Recording video using the smartphone camera...");
    }
}

/*
 * Used Interface Not Class
 */
public interface InterfaceEx2 {
    public static void main(String[] args) {
        SmartPhone smartphone = new SmartPhone();
        smartphone.Os();
        smartphone.playMusic();
        smartphone.stopMusic();
        smartphone.takePhoto();
        smartphone.recordVideoes();

        // Using default and static methods
        smartphone.cameraInfo();
        MusicPlayer.musicInfo();
    }
}
