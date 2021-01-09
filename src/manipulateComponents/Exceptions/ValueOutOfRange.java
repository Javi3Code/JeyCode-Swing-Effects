package manipulateComponents.Exceptions;

/**
 * 
 * @author Javier P�rez Alonso
 *
 *         12 may. 2020
 *
 */
public final class ValueOutOfRange extends RuntimeException
{

      /**
      * 
      */
      private static final long serialVersionUID = 4857918725363318785L;

      /**
       * 
       * Builder
       *
       * @param m
       */
      public ValueOutOfRange(final String m)
      {
            super(m);
      }

}
