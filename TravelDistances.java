import java.util.Arrays;
import java.util.Scanner;

/*******
 * TravelDistances
 ********
 * asks the user to enter two strings, one containing city abbreviations and the second containing the distances between them
 * the method will then search the array of cities to get the city that is associated with this distance and will place the cities
 * found into alphabetical order
 *____________
 * Miles Marshall
 * 10/24/19
 * CMSC 255 Section 003
 *********/

public class TravelDistances {
    private static long[] tokens;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		/**
		* call the getCity method at args 0 from the cities string
		**/
        String[] cities = getCity(args[0]);
		/**
		* call the getDistance method at args 1 from the two dimensional distance array 
		**/
        int[][] distance = getDistance(args[1]);

        System.out.println(Arrays.toString(tokens));
        System.out.println("Type true if  you would like to search cities above or equal to a certain distance or false if you would like to search cities below a certain distance: ");
        boolean IsOver = input.nextBoolean();
        System.out.println("Enter the distance you would like to search:  ");
        int Distance = input.nextInt();
        System.out.println("Enter the city you would like to start from:   ");
        String StartCity = input.nextLine();

    }


	/**
	* this method will store the string passed in at the command line and will pass a one-dimensional string array
	* that will return the list of cities people are flying to and from
	**/
    public static String [] getCity(String inputCityString) {
        String [] cities = inputCityString.split(",");
        return cities;

    }





	/**
	* this method will pass the distances string array and will return a two-dimensional int array that stores the distances between
	* the cities passed in
	***/
    public static int [] [] getDistance(String inputDistanceString) {

        String[] distances = inputDistanceString.split("<>");
        int[][] distanceValues = new int[distances.length][distances.length];
        for (int i = 0; i < distances.length; i++) {
            String[] distances2 = distances[i].split(",");

            for (int j = 0; j < distances2.length; j++) {
                distanceValues[i][j] = Integer.parseInt(distances2[j]);
            }
        }
        return distanceValues;
    }



/**
	* this method will search the city array for the index. It will then search the two dimensional int array for distances
	* above, equal to or below given distance from the given city based on the input
	* Once a distanceis found that meets the criteria, the method will search the array of cities to get the city that matches
	***/
    public static String [] searchDistance(int [][] distances, String[] cities, boolean isOver, int distance, String city) {
          int size = 0;
       int row = -1;
       String [] temp = new String[cities.length];
       for (int i = 0; i < cities.length; i++) {
           if (cities[i].equals(city))
               row = i;
       }
	   /**
	   * this for loop searches the city array for cities above or equal to a given distnce
	   **/
       if (isOver){
           for (int j = 0; j < cities.length; j++) {
               if (distances[row][j] >= distance && distances[row][j] != 0) {
                   temp[size] = cities[j];
                   size++;
               }
           }
       }else{
		/**
	   * this for loop searches the city array for cities below a given distnce
	   **/   
           for (int j = 0; j < cities.length; j++) {
               if (distances[row][j] < distance && distances[row][j] != 0) {
                   temp[size] = cities[j];
                   size++;
               }
           }
       }
        String[] result = new String[size];
       for (int i = 0; i < size; i++) {
           result[i] = temp[i];
       }
	   /**
	   * this sorts the cities found from the array
	   **/
        Arrays.sort(result);
       return result;
    }



}