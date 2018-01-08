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

public class SimulatedAnnealing {
	TSP tsp;
	double T0;
        double eta;
        double k;
	
	public SimulatedAnnealing(TSP tsp, double T0, double eta, double k) 
	{
		// TODO Auto-generated constructor stub
		this.tsp = tsp;
                this.T0 = T0;
                this.eta = eta;
                this.k = k;
	}
	
	/**
	 * Main loop of your local search algorithm. 
	 * After the search is complete, create a SolutionInfo Object 
	 * with related information and return to the caller to generate aggregated results
	 * @return
	 */
	public SolutionInfo run() 
	{
		//Main loop of your local search algorithm. 
		Route current=new Route(this.tsp);
                Route next=null;
                int count=0;
                Random random = new Random();
                double ran=0,delE,T;
                for(int t=0;;t++){
                    T=schedule(t);
                    if(T<=0){
                        next=current;
                        count=t;
                        break;
                    }
            
                    ran=random.nextDouble();
                    if(ran<0.5){
                        
                        next=OneOneExchange.apply(current);//heuristic1 1-1 exchange;
                    }
                    else {
                        next=Or_Opt.apply(current);//heuristic2 or-opt
                        //next=current;
                    }
                    delE = next.getCost()-current.getCost();

                    if(delE < 0) current=next;
                    else{
                        double probability = Math.exp((-delE)/(T*k));
                        if(ran >= probability)current = next;
                    }
                }

	
		SolutionInfo si = new SolutionInfo(next,count);	
		return si;
	}
        
        public double schedule (int t)
        {
            return T0-eta*t;
        }
	
	
	
	
	
    
}
