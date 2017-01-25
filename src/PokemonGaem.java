
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author bulka4927
 */
public class PokemonGaem extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    //game variables
    //player
    Rectangle user = new Rectangle(100, 200, 50, 50);
    //scoreboard and lives alotted
    int score = 0;
    Font scoreFont = new Font("Arial", Font.BOLD, 42);
    //subject to change
    int lives = 10;
    //pokeballs (weapons)
    int[] pokeX = new int[10];
    int[] pokeY = new int[10];
    //enemy rattata
    int[] ratX = new int[10];
    int[] ratY = new int[10];
    //speed
    int x = 300;
    int y = 550;
    int speed = 12;
    //direction keys variable
    boolean left = false;
    boolean right = false;
    boolean space = false;
    //background of game anim
    BufferedImage pokeBackground = loadImage("route.png");
    //enemy anim
    BufferedImage rattata = loadImage("bad.png");
    //pokeballs anim 
    BufferedImage pokeball = loadImage("pokeball.png");
    //player anim
    BufferedImage player = loadImage("pokeplayers.png");
    
    

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);


        // GAME DRAWING GOES HERE 
        g.drawImage(pokeBackground, 0, 0, WIDTH, HEIGHT, null);
        //player anim 
        g.drawImage(player, player.getWidth(), player.getHeight(), null);

        
        







        // GAME DRAWING ENDS HERE
    }
    //way to load in images

    public BufferedImage loadImage(String PokemonGaem) {
        BufferedImage img = null;
        try {
            File file = new File(PokemonGaem);
            img = ImageIO.read(file);
        } catch (Exception e) {
            //if there is an error, print it
            e.printStackTrace();
        }
        return img;
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void Pokemon() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;



        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            //method to take away player lives when enemy passes them
            for (int i = 0; i < ratX.length; i ++)
                if(ratY[i] == y + 100 && ratX[i] < 1000)
                {
                    lives--;
                }
            //if player has 0 lives then game over
            if(lives == 0);
            {
                //game displayed to player
                System.out.println("GAME OVER");
            }
            //movement of player directional
            {
            if(left)
                
            {
              //x direction speed
                x = x - speed;  
            }
            //ensure player doesnt veer off the screen x 
            if(x < 0)
            {
                x = 0;
            }
            if( x + 90 > WIDTH)
            {
                //ensure player doesnt veer off the screen y 
                if(y < 0)
                {
            if (y + 40 > HEIGHT)
            {
                y = HEIGHT - 40;
            }
                }
                //enemy rats coming toward player
                
                int y = 10;
                
                for (int i = 0; i < )
                
                
            
            


            // GAME LOGIC ENDS HERE 

            // update the drawing (calls paintComponent)
            repaint();



            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        PokemonGaem game = new PokemonGaem();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);
        

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // starts my game loop
        game.Pokemon();
    }
        public void keyTyped(KeyEvent e) {
    }
//fire the pokeball with space bar
@Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            space = true;
        }
    }
//stops firing once key is released
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            space = false;
        }
    }
    //player go left
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
    }
    //stop going left
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
    }
    //player go right
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
    }
    //stop going right
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }
}