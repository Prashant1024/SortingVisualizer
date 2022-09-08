import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sorting extends JPanel
{
    private static final int MIN_WIDTH = 1920;
    private static final int MIN_HEIGHT = 1080;
    private static final int BAR_WIDTH = 8;
    private  static final int NO_OF_BARS = MIN_WIDTH / BAR_WIDTH;
    Random rand = new Random();
    int max = 0;
    JPanel panel;
    private int arr[];
    public Sorting(){

        arr = new int[NO_OF_BARS];
        for(int i = 0 ;i < arr.length; i++){
            arr[i] = rand.nextInt(NO_OF_BARS * 2 ) + 50;
            if(arr[i] > max){
                max = arr[i];
            }
        }
        setBackground(Color.DARK_GRAY);

    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        graphics.setColor(Color.WHITE);
        for(int i = 0; i < NO_OF_BARS; i++){
            int height = arr[i] * 2;
            int x = i * BAR_WIDTH;
            int y = MIN_HEIGHT - height;
            graphics.fillRect(x,y,BAR_WIDTH,height);
        }

    }
    //BUBBLE SORT
    public void BubbleSort() throws InterruptedException {
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            repaint();
            Thread.sleep(50);
        }
    }
    //SELECTIONS SORT
    public void SelectionSort() throws InterruptedException {
        for(int i = 0; i < arr.length; i++){
            int pos = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[pos]){
                    pos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
            repaint();
            Thread.sleep(50);
        }
    }
    //INSERTION SORT
    public void InsertionSort() throws InterruptedException {
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            repaint();
            Thread.sleep(50);
        }
    }
    //COUNTING SORT
    public void CountingSort() throws InterruptedException{
        int n = arr.length;
        int count[] = new int[max+1];
        for(int i = 0; i < n; i++){
            int pos = arr[i];
            count[pos] += 1;
        }
        int j = 0;
        for(int i = 0; i < count.length; i++){
            int temp = count[i];
            while(temp > 0){
                arr[j++] = i;
                temp--;
            }
            repaint();
            Thread.sleep(50);
        }


    }
}
