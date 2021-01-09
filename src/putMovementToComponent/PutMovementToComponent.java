package putMovementToComponent;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Javier P�rez Alonso
 *
 *         6 may. 2020
 *
 */
public final class PutMovementToComponent
{

      private int x,y = 0;

      private PutMovementToComponent()
      {}

      public static PutMovementToComponent newInstance()
      {
            return new PutMovementToComponent();
      }

      /**
       * 
       * @param c
       */
      public void giveMovementToTheWindow(final Window c,final float alpha)
      {
            c.addMouseListener(new MouseAdapter()
            {

                  @Override
                  public void mousePressed(MouseEvent e)
                  {
                        x = e.getX();
                        y = e.getY();
                  }

                  @Override
                  public void mouseReleased(MouseEvent e)
                  {
                        c.setOpacity(1f);
                  }

            });
            c.addMouseMotionListener(new MouseAdapter()
            {

                  @Override
                  public void mouseDragged(MouseEvent e)
                  {
                        c.setLocation(c.getLocation().x + e.getX() - x,c.getLocation().y + e.getY() - y);
                        c.setOpacity(alpha);
                  }
            });
      }

      /**
       *
       * @param c
       */
      public void giveMovementToTheComponent(final Component c)
      {

            c.addMouseListener(new MouseAdapter()
            {

                  @Override
                  public void mousePressed(final MouseEvent e)
                  {
                        x = e.getX();
                        y = e.getY();
                  }
            });
            c.addMouseMotionListener(new MouseAdapter()
            {

                  @Override
                  public void mouseDragged(final MouseEvent e)
                  {
                        c.setLocation(c.getLocation().x + e.getX() - x,c.getLocation().y + e.getY() - y);
                  }
            });
      }

}