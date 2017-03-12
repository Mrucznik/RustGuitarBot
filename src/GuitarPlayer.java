import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

class GuitarPlayer {
    private Robot robot;
    private int width;
    private int height;

    GuitarPlayer() {
        try {
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            width = gd.getDisplayMode().getWidth();
            height = gd.getDisplayMode().getHeight();
            robot = new Robot();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void Play()
    {
        try {
            Mariachi();
            Mariachi();
            MariachiSolo();
            MariachiSolo();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void PlayNote(char note, boolean sharp, int delay) throws InterruptedException {
        MoveToNote(note, sharp);
        TimeUnit.MILLISECONDS.sleep(50);
        HitNote();
        TimeUnit.MILLISECONDS.sleep(delay);
    }

    private void PlayChord(char note, boolean sharp, int delay) throws InterruptedException {
        MoveToNote(note, sharp);
        TimeUnit.MILLISECONDS.sleep(50);
        HitChord();
        TimeUnit.MILLISECONDS.sleep(delay);
    }

    private void PlayAll(char note, boolean sharp, int delay) throws InterruptedException {
        MoveToNote(note, sharp);
        TimeUnit.MILLISECONDS.sleep(50);
        HitAll();
        TimeUnit.MILLISECONDS.sleep(delay);
    }

    private void MoveToNote(char note, boolean sharp) throws InterruptedException {
        Move(10000);
        TimeUnit.MILLISECONDS.sleep(50);
        switch(note)
        {
            case 'd':
                if(sharp)
                    Move(-200);
                break;
            case 'e':
                if(!sharp)
                    Move(-300);
                else
                    Move(-380);
                break;
            case 'f':
                if(!sharp)
                    Move(-380);
                else
                    Move(-452);
                break;
            case 'g':
                if(!sharp)
                    Move(-530);
                else
                    Move(-595);
                break;
            case 'a':
                if(!sharp)
                    Move(-660);
                else
                    Move(-727);
                break;
            case 'h':
                if(!sharp)
                    Move(-800);
                else
                    Move(-880);
                break;
            case 'c':
                if(!sharp)
                    Move(-880);
                else
                    Move(-960);
                break;
            case 'D':
                if(!sharp)
                    Move(-1055);
                else
                    Move(-1165);
                break;
            case 'E':
                Move(-1320);
                break;
        }
    }

    private void HitNote() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(50);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        TimeUnit.MILLISECONDS.sleep(50);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    private void HitChord() throws InterruptedException {
        Thread.sleep(50);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(50);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    private void HitAll() throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(50);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        TimeUnit.MILLISECONDS.sleep(50);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    private void Move(int x) throws InterruptedException {
        robot.mouseMove( width/2,height/2+x);
    }

    private void Mariachi() throws InterruptedException {

        PlayAll('e', false, 50);
        PlayNote('g', false, 50);
        PlayNote('a', false, 50);
        PlayAll('h', false, 100);
        PlayNote('h', false, 0);
        PlayNote('h', false, 100);
        PlayNote('c', false, 0);
        PlayAll('h', false, 100);
        PlayNote('h', false, 0);
        PlayNote('h', false, 100);
        PlayNote('c', false, 0);
        PlayAll('h', false, 100);
        PlayNote('h', false, 0);
        PlayNote('h', false, 100);
        PlayNote('g', false, 0);
        PlayAll('a', false, 300);


        PlayNote('e', false, 50);
        PlayNote('f', true, 50);
        PlayNote('g', false, 50);
        PlayAll('a', false, 100);
        PlayNote('a', false, 0);
        PlayNote('a', false, 100);
        PlayNote('h', false, 0);
        PlayAll('a', false, 100);
        PlayNote('a', false, 0);
        PlayNote('a', false, 100);
        PlayNote('h', false, 0);
        PlayAll('a', false, 100);
        PlayNote('a', false, 0);
        PlayNote('a', false, 100);
        PlayNote('f', true, 0);
        PlayAll('g', false, 300);
    }

    private void MariachiSolo() throws InterruptedException {

        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('E', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('E', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);

        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('D', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('D', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);


        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('E', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('E', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);

        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('D', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('h', false, 0);
        PlayNote('D', false, 0);
        PlayNote('h', false, 0);
        PlayNote('g', false, 0);
    }

    private void PlayDisMoll() throws InterruptedException {
        PlayNote('d', true, 0);
        PlayNote('e', true, 0);
        PlayNote('f', true, 0);
        PlayNote('g', true, 0);
        PlayNote('a', true, 0);
        PlayNote('h', false, 0);
        PlayNote('D', false, 0);
        PlayNote('D', true, 0);
        PlayNote('D', true, 0);
        PlayNote('D', false, 0);
        PlayNote('h', false, 0);
        PlayNote('a', true, 0);
        PlayNote('g', true, 0);
        PlayNote('f', true, 0);
        PlayNote('e', true, 0);
        PlayNote('d', true, 0);
    }

    private void PlayDisDur() throws InterruptedException {
        PlayNote('d', true, 0);
        PlayNote('e', true, 0);
        PlayNote('g', false, 0);
        PlayNote('g', true, 0);
        PlayNote('a', true, 0);
        PlayNote('h', true, 0);
        PlayNote('D', false, 0);
        PlayNote('D', true, 0);
        PlayNote('D', true, 0);
        PlayNote('D', false, 0);
        PlayNote('h', true, 0);
        PlayNote('a', true, 0);
        PlayNote('g', true, 0);
        PlayNote('g', false, 0);
        PlayNote('e', true, 0);
        PlayNote('d', true, 0);
    }
}
