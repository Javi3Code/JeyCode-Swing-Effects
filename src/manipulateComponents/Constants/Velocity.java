package manipulateComponents.Constants;

/**
 * 
 * @author Javier Perez Alonso
 *
 *         11 may. 2020
 *
 */
public enum Velocity
{

 GEARALPHA(1,100),
 GEARZERO(1,40),
 GEARFIRST(1,15),
 GEARSECOND(1,10),
 GEARTHIRD(1,3),
 PERFECTGEAR(1,1),
 GEARFOURTH(2,1),
 GEARFIFTH(3,1),
 GEARSIXTH(6,1),
 ULTRAGEAR(15,1),
 FLASH(45,1),
 QUICKSILVER(80,1),
 TELEPORT(140,1);

      private int speed;
      private int delay;

      /**
       * 
       * Builder
       *
       * @param velocitY
       * @param timE
       */
      Velocity(final int speed,final int delay)
      {
            this.speed = speed;
            this.delay = delay;
      }

      public int getSpeed()
      {
            return speed;
      }

      public int getDelay()
      {
            return delay;
      }
}