package manipulateComponents.pattern;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import manipulateComponents.Constants.Velocity;

/**
 * 
 * @author Javier Perez Alonso
 *
 *         12 may. 2020
 *
 */
public interface Manipulable<T> extends ActionListener
{

      int getSpeed();

      void setVelocity(Velocity vel);

      void setSpeed(int speed);

      int getDelay();

      void setDelay(int delay);

      void start();

      void stop();

      Timer getTimer();

      void setActor(T actor);

      T getActor();

}