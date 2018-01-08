/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruhani
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


public class TSP 
{
	double x[], y[];
	int n;

	public TSP(double x[], double y[], int n) 
	{
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.n = n;

	}

	TSP() {
		this.x = new double[10];
		this.y = new double[10];
		this.n = 10;
	}
	
	private void solve() {
		Route route = new Route(this);
		//route.print();
		

		SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(this, 24, 0.6, 0.3);
		SolutionInfo si = simulatedAnnealing.run();
		
		System.out.println(si.solution.getCost());
		si.solution.print();
	}
	void print()
	{
		System.out.println("Dimension: "+n);
		for (int i = 0; i < n; i++) {
			System.out.println(x[i] + " " + y[i]);
		}
                System.out.println("");
	}
	
	/**
	 * Returns the distance between the node a and b
	 * @param a
	 * @param b
	 * @return
	 */
	public double edgeCost(int a, int b)
	{
	
            double d = Math.sqrt( (x[a]-x[b])*(x[a]-x[b]) + (y[a]-y[b])*(y[a]-y[b]) );
            return d;
	}

	public static void main(String[] args) {
		new TSP().processInput();
	}
	public void processInput()
	{
		try 
		{
			String inputFileName = "/input/test.tsp";
			InputStream inputStream = this.getClass().getResourceAsStream(inputFileName);
			Scanner in = new Scanner(inputStream);
			//Scanner in = new Scanner(new File("H:\\Level 4 Term 2\\CSE 462 Algorithm Engineering Sessional\\Offline 1 TSP\\Starts\\att48.tsp"));
//			Scanner in = new Scanner(new File("\\input\\burma14.tsp"));
			//Scanner in = new Scanner(new File("st70.tsp"));
			//Scanner in = new Scanner(new File("ulysses16.tsp"));
			//Scanner in = new Scanner(new File("ulysses22.tsp"));
			
			String line = "";
			int n;
			
			//three comment lines
			in.nextLine();
			in.nextLine();
			in.nextLine();
			//get n
			line = in.nextLine();
			line = line.substring(11).trim();
			n = Integer.parseInt(line);
			
			//System.out.println("" +n);
			
			//two comment lines
			in.nextLine();
			in.nextLine();
			
			double x[] = new double[n];
			double y[] = new double[n];
			
			for (int i = 0; i < n; i++)
			{
				in.nextInt();
				x[i] = in.nextDouble();
				y[i] = in.nextDouble();
			}
			
			TSP tsp = new TSP (x,y,n);
			//tsp.print();
			tsp.solve();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
