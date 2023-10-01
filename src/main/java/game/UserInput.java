package game;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInput implements NativeKeyListener {

    public void startListening() {
        // turn of the disgusting logger
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            System.err.println("problem registering the native hook.");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(this);

    }

    public void nativeKeyPressed(NativeKeyEvent e) {

        String keyPressed = NativeKeyEvent.getKeyText(e.getKeyCode());
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if(keyPressed.toLowerCase().equals("r")){
            if(!Field.getInstance().isChecking()) {
                Field.getInstance().getActivePiece().rotate();
            }
        }

        if(keyPressed.toLowerCase().equals("a")){
            Field.getInstance().getActivePiece().moveToLeft();

        }


        if(keyPressed.toLowerCase().equals("d")){
            Field.getInstance().getActivePiece().moveToRight();

        }


    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        // Empty Implementation
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        // Empty Implementation
    }

}
