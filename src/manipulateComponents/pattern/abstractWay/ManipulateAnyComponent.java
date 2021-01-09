package manipulateComponents.pattern.abstractWay;

import java.awt.Component;
import java.util.Objects;

import javax.swing.Timer;

import manipulateComponents.Constants.Velocity;
import manipulateComponents.pattern.Manipulable;

/**
 * 
 * @author Javier P�rez Alonso
 *
 *         6 may. 2020
 *
 */
/**
 * @author Javier P�rez Alonso
 *
 *         26 may. 2020
 *
 */
public abstract class ManipulateAnyComponent implements Manipulable<Component>
{

      private int speed;
      private Component actor;
      private Timer timer;

      /**
       * 
       * Builder
       *
       */
      protected ManipulateAnyComponent()
      {}

      protected ManipulateAnyComponent(final Component actor,final Velocity gear)
      {
            this.actor = actor;
            speed = gear.getSpeed();
            timer = new Timer(gear.getDelay(),this);
      }

      @Override
      public int getSpeed()
      {
            return speed;
      }

      @Override
      public int getDelay()
      {
            return timer.getDelay();
      }

      @Override
      public void setVelocity(Velocity vel)
      {
            setSpeed(vel.getSpeed());
            setDelay(vel.getDelay());
      }

      @Override
      public void setDelay(final int delay)
      {
            timer.setDelay(delay);
      }

      @Override
      public void setSpeed(final int speed)
      {
            this.speed = speed;
      }

      @Override
      public void start()
      {
            if (Objects.nonNull(timer))
            {
                  timer.start();
            }
      }

      @Override
      public void stop()
      {
            if (Objects.nonNull(timer))
            {
                  timer.stop();
            }
      }

      @Override
      public Timer getTimer()
      {
            return timer;
      }

      @Override
      public Component getActor()
      {
            return actor;
      }

      @Override
      public void setActor(final Component actor)
      {
            this.actor = actor;
      }
}
