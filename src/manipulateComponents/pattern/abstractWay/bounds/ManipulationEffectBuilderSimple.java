/**
 * 
 */
package manipulateComponents.pattern.abstractWay.bounds;

import manipulateComponents.Constants.ManipulateBounds;

/**
 * @author Javier Pérez Alonso
 *
 *         8 sept. 2020
 *
 */
public final class ManipulationEffectBuilderSimple
{

      private final ManipulationEffect model;

      public ManipulationEffectBuilderSimple(ManipulationEffect model)
      {
            this.model = model;
      }

      public ManipulationEffectBuilderSimple params(ManipulateBounds option,int finish)
      {
            model.setOption(option);
            model.setFinish(finish);
            return this;
      }

      public ManipulationEffect create()
      {
            return model;
      }

}
