/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientws;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.ArrayOftTopGoalScorer;
import eu.dataaccess.footballpool.TCountryInfo;
import java.util.List;

/**
 *
 * @author entrar
 */
public class ClientWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("tarjetas amarillas: "+yellowCardsTotal());// TODO code application logic here
        System.out.println("top goleadores: "+ topGoalScorers(1));
        //Scanner teclado= new Scanner(System.in);
        //String pais = teclado.next();
        //System.out.println("defensas de cada pais: "+pais+":" allDefenders(pais).getString());
        
        //3 ejercicio 
        List<TCountryInfo> tcountryinfo=(countryNames(true).getTCountryInfo());
        for(TCountryInfo tcountryinfo1: tcountryinfo){
            System.out.println(tcountryinfo1.getSName());
            String country = tcountryinfo1.getSName();
            System.out.println(country + ": " +(allDefenders(country).getString()));
        }
    }

    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOftTopGoalScorer topGoalScorers(int iTopN) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.topGoalScorers(iTopN);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }
    
}
