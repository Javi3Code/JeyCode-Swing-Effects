package manipulateComponents.pattern.abstractWat.effectsComplete;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.Objects;

import jeycodeutils.constants.JCConstants;
import manipulateComponents.Constants.AlphaValue;
import manipulateComponents.Constants.CardinalPoint;
import manipulateComponents.Constants.Velocity;
import manipulateComponents.Exceptions.ValueOutOfRange;
import manipulateComponents.pattern.abstractWay.ManipulateAnyComponent;

public class ManipulateWindowEffect extends ManipulateAnyComponent
{

      private int road;
      private CardinalPoint orientation;
      private int walked = JCConstants.ZERO;
      private int x;
      private int y;
      private boolean visible = false;
      private boolean simple = false;
      private float alpha = JCConstants.ZERO_FLOAT;
      private float alphaValue;
      private Window windowToMove;

      private ManipulateWindowEffect()
      {
            super();
      }

      private ManipulateWindowEffect(Window windowToMove,Velocity gear,int road,CardinalPoint orientation,boolean visible,AlphaValue ALPHA)
      {
            super(windowToMove,gear);
            this.road = road;
            this.orientation = orientation;
            alphaValue = ALPHA.getValue();
            x = windowToMove.getX();
            y = windowToMove.getY();
            this.visible = visible;
            if (visible)
            {
                  alpha = 1f;
            }
            this.windowToMove = windowToMove;

      }

      private ManipulateWindowEffect(Window windowToMove,Velocity gear,int road,CardinalPoint orientation)
      {
            super(windowToMove,gear);
            this.road = road;
            this.orientation = orientation;
            x = windowToMove.getX();
            y = windowToMove.getY();
            simple = true;
            this.windowToMove = windowToMove;
      }

      public static void push(Window windowToMove,Velocity gear,int road,CardinalPoint orientation,boolean visible,AlphaValue ALPHA)
                              throws ValueOutOfRange
      {
            if (Objects.isNull(orientation))
            {
                  throw new ValueOutOfRange("Orientation value can't be null!!");
            }
            if (Objects.isNull(ALPHA))
            {
                  throw new ValueOutOfRange("Alpha value can't be null!!");
            }
            final var mnpt = new ManipulateWindowEffect(windowToMove,gear,road,orientation,visible,ALPHA);
            mnpt.start();
      }

      public static void pushSimple(Window windowToMove,Velocity gear,int road,CardinalPoint orientation) throws ValueOutOfRange
      {
            if (Objects.isNull(orientation))
            {
                  throw new ValueOutOfRange("Orientation value can't be null!!");
            }
            final var mnpt = new ManipulateWindowEffect(windowToMove,gear,road,orientation);
            mnpt.start();
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
            if (walked >= road)
            {
                  stop();
                  if (!simple)
                  {
                        setOpacityValue();
                  }
            }
            else
            {
                  walked += getSpeed();
                  if (!simple)
                  {
                        setOpacityValue();
                  }
                  filter();
            }
      }

      private void setOpacityValue()
      {
            if (!visible)
            {
                  alpha += alphaValue;
                  if (alpha > 1f)
                  {
                        alpha = 1f;
                  }
                  windowToMove.setOpacity(alpha);
            }
            else
            {
                  alpha -= alphaValue;
                  if (alpha < 0f)
                  {
                        alpha = 0f;
                        stopThis();
                  }
                  windowToMove.setOpacity(alpha);
            }
      }

      private void stopThis()
      {
            stop();
            if (visible)
            {
                  windowToMove.dispose();
            }
      }

      private void filter()
      {
            switch (orientation)
            {
                  case NORTH:
                        windowToMove.setLocation(x,y -= getSpeed());
                        break;
                  case SOUTH:
                        windowToMove.setLocation(x,y += getSpeed());
                        break;
                  case EAST:
                        windowToMove.setLocation(x += getSpeed(),y);
                        break;
                  case WEST:
                        windowToMove.setLocation(x -= getSpeed(),y);
                        break;
            }
      }

}
