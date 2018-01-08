/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruhani
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Or_Opt 
{

	/**
	 * improves the route by repeatedly applying the first better 2-opt move
	 * @param individual
	 * @param period
	 * @param vehicle
	 * @return false if cost is not decreased
 	 */
	public static Route apply(Route rt)
	{
            int [] chain = new int[3];
            Route tmp_route = new Route(rt);
            int n = rt.n;
            for(int chain_size = 3; chain_size>=1 ;chain_size--)
            {
                for (int i = 0; i + chain_size - 1 <= n; i++) 
                {
                    //remove chain from tmp_route 
                    for(int pos = 0;pos<chain_size;pos++)
                    {
                        chain[pos]  = tmp_route.route.remove(i);
                    }
                    int tmp_route_len = tmp_route.route.size();

                    for(int new_pos = 0; new_pos < tmp_route_len; new_pos++)
                    {
                        //inserting cutted route at new_pos
                        Route new_route = new Route(tmp_route);
                        for(int pos = 0;pos<chain_size;pos++)
                        {
                            new_route.route.add(new_pos+pos, chain[pos]);
                        }
                        new_route.updateCost();
                        rt.updateCost();
                        if (new_route.getCost()< rt.getCost()) {
                            new_route.n = new_route.route.size();
                            return new_route;
                        }
                        
                    }
                                        
                }
            }
            return rt;
	}
		
}
