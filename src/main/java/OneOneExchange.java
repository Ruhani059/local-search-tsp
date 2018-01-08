
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruhani
 */
import java.util.Random;
public class OneOneExchange {
	private static Random random = new Random(System.currentTimeMillis());
	public static Route apply(Route rt) 
	{
		
		Route route = new Route (rt);
                int n = route.n;
                int ran,ran2;
                ran = random.nextInt(rt.n);
                do {                
                    ran2  = random.nextInt(rt.n);
                } while (ran == ran2);
//                System.out.println("n = "+n+"  ran = "+ran+"  ran2 = "+ran2);
                int pos1element = route.route.remove(ran);
                route.route.add(ran2,pos1element);
                int pos2element = route.route.remove(ran2);
                route.route.add(ran, pos2element);
                                
		route.updateCost();
		return route;
	}
}
