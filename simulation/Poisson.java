// $Id: Poisson.java 1905 2011-01-10 14:18:29Z phil $

package simulation;

import java.util.*;

/**
 * Classe permettant de générer des nombres aléatoires suivant une loi 
 * de Poisson
 * @author laroque@u-cergy.fr
 * @version $Rev: 1905 $
 */
public class Poisson {
  /**
   * pour obtenir des nombres entre 0 et 1
   */
  protected static Random r = new Random(new Date().getTime());

  //////////////////////////////////////////////////////////////
  /**
   * obtient le prochain nombre aléatoire
   * @param m la valeur moyenne souhaitée
   * @return un nombre réel positif
   */
  public static double next(double m) {
    return -m * Math.log(r.nextDouble());
  }
    

  //////////////////////////////////////////////////////////////
  /**
   * obtient le prochain nombre aléatoire (centré sur 1)
   * @return un nombre réel positif
   */
  public static double next() { return next(1.0); }
  
  /** test du générateur. Paramètres: <ul>
   * <li> N le nombre de valeurs à générer
   * <li> m la valeur moyenne souhaitée </ul>
   */
  public static void main(String args[]) {
    int N=1000;
    double moy = 1;
    //pl.base.Help.usage("pl.simulation.Poisson",args,"<nbIter> <avgValue>");
    try {
      N = Integer.parseInt(args[0]);
      moy = Double.parseDouble(args[1]);
    } catch (Exception e) {}


    System.err.println("Running " + N + " iterations on average value "
                       + moy);

    double res = 0;

    for (int i = 0; i < N; i++) 
      res += Poisson.next(moy);

    System.out.println(res/N);
  }
}
