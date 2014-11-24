import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Object;

/**
 * Created by ritchie on 11/24/14.
 */
public class year_avg {
    public static void main(String[] args) throws IOException{
        String file = "/Users/ritchie/Desktop/bitbootcamp/sql/practise/week1/googlebooks.txt";
        String line = null;
        List<Integer> year = new ArrayList<Integer>();

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String previous = null;
            String current = null;
            int count =0;
            int index = -1;

            while((line = br.readLine())!=null){
                String[] terms = line.split("\t");
                current = terms[0];
                if(current.equals(previous)){
                    count = count + 1;
                    year.set(index,year.get(index) + 1);
                }else{
                    year.add(1);
                    index = index + 1;
                }
                previous = current;
            }
            int med = year.get(year.size()/2);
            Collections.sort(year);
            int max = year.get(year.size()-1);
            int min = year.get(0);

            double sum = 0;
            int num = 0;
            for(Integer i:year){
                sum = sum + i;
                num = num + 1;
            }
            double avg = sum / num;
            double std = 0;

            for (Integer i : year){
                sum = (i-avg)*(i-avg);
            }
            std = Math.sqrt(sum/num);

            System.out.println("The years medium is : " + med);
            System.out.println("The average years of words is: " + avg);
            System.out.println("The min years of words is :" + min);
            System.out.println("The max years of words is " + max);
            System.out.println("The STD of years is " + std);
        }catch(FileNotFoundException e){
            System.out.println("File Not Found!");
        }
    }
}
