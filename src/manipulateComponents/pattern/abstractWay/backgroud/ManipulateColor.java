package manipulateComponents.pattern.abstractWay.backgroud;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import jeycodeutils.checkmethods.CheckIf;
import manipulateComponents.Constants.RGBA;
import manipulateComponents.Constants.Velocity;
import manipulateComponents.pattern.abstractWay.ManipulateAnyComponent;

/**
 * 
 * @author Javier Pérez Alonso
 *
 *         11 may. 2020
 *
 */
public class ManipulateColor extends ManipulateAnyComponent
{

      private boolean dispel;
      private float limit;
      private float r;
      private float g;
      private float b;
      private float alpha;
      public RGBA mnptColor;
      private float change;

      /**
       * 
       * Builder
       *
       */
      public ManipulateColor()
      {
            super();
      }

      /**
       * 
       * Builder
       *
       * @param actor
       * @param gear
       * @param mnptColor
       * @param limit
       */
      public ManipulateColor(final Component actor,final Velocity gear,final RGBA mnptColor,final float limit)
      {
            super(actor,gear);
            alpha = (actor.getBackground()
                          .getAlpha() - 0.5f) / 255;
            r = (actor.getBackground()
                      .getRed() - 0.5f) / 255;
            g = (actor.getBackground()
                      .getGreen() - 0.5f) / 255;
            b = (actor.getBackground()
                      .getBlue() - 0.5f) / 255;
            this.mnptColor = mnptColor;
            this.limit = limit;
            selectChange();
      }

      @Override
      public void actionPerformed(final ActionEvent e)
      {
            controlOfProcess();
            changeColor();
      }

      /**
       * 
       * Method selectChange
       *
       */
      private void selectChange()
      {
            switch (mnptColor)
            {
                  case ALPHA:
                        change = Math.round(alpha * 100);
                        dispel = alpha > limit;
                        break;
                  case RED:
                        change = Math.round(r * 100);
                        dispel = r > limit;
                        break;
                  case GREEN:
                        change = Math.round(g * 100);
                        dispel = g > limit;
                        break;
                  case BLUE:
                        change = Math.round(b * 100);
                        dispel = b > limit;
                        break;
            }
      }

      /**
       * 
       * Method changeColor
       *
       */
      private void changeColor()
      {
            switch (mnptColor)
            {
                  case ALPHA:
                        getActor().setBackground(new Color(r,g,b,change / 100));
                        break;
                  case RED:
                        getActor().setBackground(new Color(change / 100,g,b,alpha));
                        break;
                  case GREEN:
                        getActor().setBackground(new Color(r,change / 100,b,alpha));
                        break;
                  case BLUE:
                        getActor().setBackground(new Color(r,g,change / 100,alpha));
                        break;
            }

      }

      /**
       * 
       * Method controlOfProcess
       *
       */
      private void controlOfProcess()
      {
            change += !dispel ? CheckIf.isLargest(limit,change) ? getSpeed() : limit : CheckIf.isLargest(change,limit) ? -getSpeed() :
                       limit;
            if (change == limit)
            {
                  stop();
            }
      }
}
