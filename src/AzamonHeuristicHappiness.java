import aima.search.framework.HeuristicFunction;

/**
 * Created by Javier Lopez on 24/10/16.
 */
public class AzamonHeuristicHappiness implements HeuristicFunction{
    public AzamonHeuristicHappiness(){}

    @Override
    public double getHeuristicValue(Object o) {
        AzamonState azamonState = (AzamonState) o;
        double response = azamonState.getA() * azamonState.coste();
        double precioDia = 0.25;
        int nPaq = azamonState.getPaqueteEnOferta().length, j;
        for(int i = 0; i < nPaq; ++i){
            j = azamonState.getPaqueteEnOferta()[i];
            response -= (azamonState.getB() * precioDia * azamonState.calcDiasFelicidad(i, j));
        }
        return response;
    }
}
