import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        new MainClass().processInput();
    }

    public void processInput()
    {
        try
        {
			String inputFileName = "/input/burma14.tsp";
			InputStream inputStream = this.getClass().getResourceAsStream(inputFileName);
			Scanner in = new Scanner(inputStream);
            //Scanner in = new Scanner(new File("H:\\Level 4 Term 2\\CSE 462 Algorithm Engineering Sessional\\Offline 1 TSP\\Starts\\att48.tsp"));
//            Scanner in = new Scanner(new File("src\\main\\resources\\input\\burma14.tsp"));
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

			for (int i = 0; i<x.length; i++) {
				System.out.println(x[i]);
			}
			System.out.println(x.length);
            TSP tsp = new TSP (x,y,n);
//			tsp.print();
//            tsp.solve();
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
