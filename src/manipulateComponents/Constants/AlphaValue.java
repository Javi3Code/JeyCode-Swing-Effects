/**
 * 
 */
package manipulateComponents.Constants;

/**
 * @author Javier Perez Alonso
 *
 *         3 jul. 2020
 *
 */
public enum AlphaValue
{

 ALPHA_WindowEffects(0.50f),
 ALPHA20(0.2f),
 ALPHA18(0.18f),
 ALPHA16(0.16f),
 ALPHA14(0.14f),
 ALPHA12(0.12f),
 ALPHA10(0.1f),
 ALPHA9(0.09f),
 ALPHA8(0.08f),
 ALPHA7(0.07f),
 ALPHA6(0.06f),
 ALPHA5(0.05f),
 ALPHA4(0.04f),
 ALPHA3(0.03f),
 ALPHA2(0.02f);

      private float value;

      AlphaValue(final float value)
      {
            this.value = value;
      }

      /**
       * Method getValue
       *
       * @return the value
       */
      public float getValue()
      {
            return value;
      }

}
