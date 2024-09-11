import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Comparator;

/** This is my Drawable class. This is the parent class for everything that will be drawn on the screen
 *      eg. Walls, Terrain, Sprites
 * 
 */
public class Drawable implements Comparable<Drawable>{
    /** topHitBox (int) is the top y pos of the Drawable */
    private int topHitBox = 0;
    private int botHitBox = 0;	
    private int leftHitBox = 0;
    private int rightHitBox = 0;
    private int xPos = 0;
    private int yPos = 0;
    private int tileWidth = 64;
    private int tileHeight = 64;
    private int actionSequence = 0;				//The current row.
    private int actionStep = 0;					//The current column.
    private BufferedImage graphic;

    /** Default constructor
     * 
     */
    public Drawable() {

    }

    /** Constructor that sets x and y pos
     * 
     * @param xPos          Is the X Coordinate to be set
     * @param yPos          Is the Y Coordinate to be set
     */
    public Drawable(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getTopHitBox() {
        return topHitBox;
    }

    public int getBotHitBox() {
        return botHitBox;
    }	

    public int getLeftHitBox() {
        return leftHitBox;
    }

    public int getRightHitBox() {
        return rightHitBox;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getActionSequence() {
        return actionSequence;
    }

    public int getActionStep() {
        return actionStep;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void setTopHitBox(int topHitBox){
        this.topHitBox = topHitBox;
    }

    public void setBotHitBox(int botHitBox){
        this.botHitBox = botHitBox;
    }

    public void setLeftHitBox(int leftHitBox){
        this.leftHitBox = leftHitBox;
    }

    public void setRightHitBox(int rightHitBox){
        this.rightHitBox = rightHitBox;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    public void setActionSequence(int actionSequence) {
        this.actionSequence = actionSequence;
    }

    public void setActionStep(int actionStep) {
        this.actionStep = actionStep;
    }

    public void setGraphic(BufferedImage graphic){
        this.graphic = graphic;
    }

    public BufferedImage getGraphic(){
        return graphic;
    }

    /** Comparison method used to compare different Drawables
     *  This method gets the difference in the x Coordinates and the y coordinates for 2 Drawbles
     *  It then subtracts them (y - x)
     *  
     *  @param compareDrawable          The drawable we are comparing with
     */
    public int compareTo(Drawable compareDrawable){
        int compareXPos = ((Drawable) compareDrawable).getXPos();

        int yDif = this.getYPos() - compareDrawable.getYPos();
        return yDif - (this.getXPos() - compareXPos);

    }

    public static Comparator<Drawable> PosComparator = new Comparator<Drawable>(){
            public int compare(Drawable d1, Drawable d2){
                return d1.compareTo(d2);
            }
        };

    public void move(){

    }

    public void doLogic() {

    }

    public void paint(Graphics graphics) {
    }

}
