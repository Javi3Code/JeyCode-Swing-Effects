package manipulateComponents.staticMethods;

import java.awt.Component;

import manipulateComponents.Constants.RGBA;
import manipulateComponents.Constants.Velocity;
import manipulateComponents.pattern.abstractWay.backgroud.ManipulateColor;

/**
 * 
 * @author Javier P�rez Alonso
 *
 *         28 may. 2020
 *
 */
public final class StaticManipulateComponentEvents
{

      private final static float VALUE_ADJUST = 0.5f;
      private final static int VALUE_DIVISOR = 255;

      /**
       * 
       * Builder
       *
       */
      private StaticManipulateComponentEvents()
      {}

      /**
       * 
       * Method getRed
       *
       * @param actor
       * @return float
       */
      public static float getRed(final Component actor)
      {
            return (actor.getBackground()
                         .getRed() - VALUE_ADJUST) / VALUE_DIVISOR;
      }

      /**
       * 
       * Method getGreen
       *
       * @param actor
       * @return float
       */
      public static float getGreen(final Component actor)
      {
            return (actor.getBackground()
                         .getGreen() - VALUE_ADJUST) / VALUE_DIVISOR;
      }

      /**
       * 
       * Method getBlue
       *
       * @param actor
       * @return float
       */
      public static float getBlue(final Component actor)
      {
            return (actor.getBackground()
                         .getBlue() - VALUE_ADJUST) / VALUE_DIVISOR;
      }

      /**
       * 
       * Method getAlpha
       *
       * @param actor
       * @return float
       */
      public static float getAlpha(final Component actor)
      {
            return (actor.getBackground()
                         .getAlpha() - VALUE_ADJUST) / VALUE_DIVISOR;
      }

      /**
       * 
       * Method manipulateRGBA
       *
       * @param actor
       * @param gear
       * @param mnptColor
       * @param limit
       */
      public static void manipulateRGBA(final Component actor,final Velocity gear,final RGBA mnptColor,final float limit)
      {
            new ManipulateColor(actor,gear,mnptColor,limit).start();
      }
}
