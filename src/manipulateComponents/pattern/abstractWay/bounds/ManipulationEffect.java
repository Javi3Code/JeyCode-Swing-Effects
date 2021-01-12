package manipulateComponents.pattern.abstractWay.bounds;

import java.awt.Component;
import java.awt.event.ActionEvent;

import jeycodeutils.exceptions.JPAOMRuntimeException;
import manipulateComponents.Constants.ManipulateBounds;
import manipulateComponents.Constants.Velocity;
import manipulateComponents.pattern.abstractWay.ManipulateAnyComponent;

/**
 * 
 * @author Javier Pérez Alonso
 *
 *         12 may. 2020
 *
 */
public final class ManipulationEffect extends ManipulateAnyComponent
{

      private static final String INCOMPATIBLE_VALUE = "Incompatible value of this ManipulateBounds.option";
      private int initial;
      private int finish;
      private int initial2;
      private int finish2;
      private boolean increase;
      private boolean increase2;
      private ManipulateBounds option;
      private final boolean isDual;

      private ManipulationEffect(final Component actor,final Velocity gear,boolean dual)
      {
            super(actor,gear);
            isDual = dual;
      }

      public static ManipulationEffectBuilderSimple simple(final Component actor,final Velocity gear)
      {
            return new ManipulationEffectBuilderSimple(new ManipulationEffect(actor,gear,false));

      }

      public static ManipulationEffectBuilderDual dual(final Component actor,final Velocity gear)
      {
            return new ManipulationEffectBuilderDual(new ManipulationEffect(actor,gear,true));
      }

      @Override
      public void actionPerformed(final ActionEvent e)
      {
            initial = control(initial,finish,increase);
            if (isDual)
            {
                  initial2 = control(initial2,finish2,increase2);
            }
            whenIsFinishedStopAnimation();
            modify();
      }

      private int control(int value,final int finalValue,final boolean increment)
      {
            var jump = getSpeed();
            jump = prepareBrake(jump,value,finalValue);
            value += increment ? jump : -jump;
            return value;
      }

      private int prepareBrake(final int jump,final int value,final int finalValue)
      {
            final var difference = value - finalValue;
            return jump > Math.abs(difference) ? Math.abs(difference) : jump;
      }

      private void whenIsFinishedStopAnimation()
      {

            if (initial == finish)
            {
                  if (!isDual)
                  {
                        stop();
                  }
                  if (initial2 == finish2)
                  {
                        stop();
                  }
            }

      }

      private void modify()
      {
            switch (option)
            {
                  case AXIS_Y:
                        getActor().setLocation(getActor().getX(),initial);
                        break;
                  case X_AXIS:
                        getActor().setLocation(initial,getActor().getY());
                        break;
                  case X_AXIS__AXIS_Y:
                        getActor().setLocation(initial,initial2);
                        break;
                  case WIDTH:
                        getActor().setSize(initial,getActor().getHeight());
                        break;
                  case HEIGHT:
                        getActor().setSize(getActor().getWidth(),initial);
                        break;
                  case WIDTH__HEIGHT:
                        getActor().setSize(initial,initial2);
                        break;
            }
      }

      // if this object is reused, this method should'be set before setFinish
      public void setOption(ManipulateBounds option)
      {
            this.option = option;
            updateInitialValues();
      }

      public void updateInitialValues()
      {
            if (isDual)
            {
                  initializeDual();
            }
            else
            {
                  initializeSimple();
            }
      }

      public void setFinish(int finish)
      {
            this.finish = finish;
            increase = finish > initial;
      }

      public void setFinish2(int finish2)
      {
            this.finish2 = finish2;
            increase2 = finish2 > initial2;
      }

      private void initializeDual()
      {
            if (!option.equals(ManipulateBounds.WIDTH__HEIGHT) && !option.equals(ManipulateBounds.X_AXIS__AXIS_Y))
            {
                  throw new JPAOMRuntimeException(ManipulationEffect.INCOMPATIBLE_VALUE);
            }
            initial = option.equals(ManipulateBounds.WIDTH__HEIGHT) ? getActor().getWidth() : getActor().getX();
            initial2 = option.equals(ManipulateBounds.WIDTH__HEIGHT) ? getActor().getHeight() : getActor().getY();
      }

      private void initializeSimple()
      {
            switch (option)
            {
                  case WIDTH:
                        initial = getActor().getWidth();
                        break;
                  case HEIGHT:
                        initial = getActor().getHeight();
                        break;
                  case X_AXIS:
                        initial = getActor().getX();
                        break;
                  case AXIS_Y:
                        initial = getActor().getY();
                        break;
                  default:
                        throw new JPAOMRuntimeException(ManipulationEffect.INCOMPATIBLE_VALUE);
            }
      }
}
