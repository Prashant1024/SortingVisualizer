import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class SortingVisualizer{
    private Sorting sortingObj;
    //CREATING GLOBAL VARIABLES
    JFrame frame = new JFrame();
    JFrame startPage = new JFrame();
        public SortingVisualizer(){
        Scanner sc = new Scanner(System.in);
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("SORTING VISUALIZER");
        sortingObj = new Sorting();
        frame.add(sortingObj);
        sortingObj.repaint();
        try{
            sortingObj.SelectionSort();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args){
        new SortingVisualizer();
    }


}
