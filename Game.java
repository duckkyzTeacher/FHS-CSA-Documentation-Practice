import java.util.ArrayList;
/**
 * This a snippit of a Game class that runs a large battle area game.
 *
 * @author Mr. Johnson
 * @version 1
 */
public class Game
{
    /** This is a list of entities in the game */
    private static ArrayList<Drawable> drawables;
    /** The maps height */
    private static final int mapHeight = 2*1080;
    /** The maps width */
    private static final int mapWidth = 2*1920;

    
    
    public static void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }

    
    /** This method is checking to see if an entitiy can spawn
     *  
     *  This checks to see if our new entitiy is overlappin with any previously spawned entities
     *  
     * @param toSpawn       The drawable that is set to spawn
     * @return              Returns true if able to spawn, false if not
     */
    public static boolean checkCanSpawn(Drawable toSpawn){
        int newX = ((toSpawn.getXPos() + toSpawn.getLeftHitBox()));
        int newY = ((toSpawn.getYPos() + toSpawn.getTopHitBox()));
        int newMaxX = newX + (toSpawn.getTileWidth() - toSpawn.getLeftHitBox() - toSpawn.getRightHitBox());    //Right
        int newMaxY = newY + (toSpawn.getTileHeight() - toSpawn.getTopHitBox() - toSpawn.getBotHitBox());    //Bottom

        int dX;
        int dY;
        int dMaxX;
        int dMaxY;
        
        
        for(Drawable d : drawables){ //Cycles through all other entities
            dX = ((d.getXPos() + d.getLeftHitBox()));
            dY = ((d.getYPos() + d.getTopHitBox()));
            dMaxX = dX + (d.getTileWidth() - d.getLeftHitBox() - d.getRightHitBox());    //Right
            dMaxY = dY + (d.getTileHeight() - d.getTopHitBox() - d.getBotHitBox());    //Bottom

            if((newX >= dX) & (newX <= dMaxX)){             //Collision from the left
                if((newY >= dY) & (newY <= dMaxY)){        //Collision from the bottom
                    return false;
                }

                else if((newMaxY >= dY) & (newMaxY <= dMaxY)){    //Collision from top
                    return false;
                }
            }
            else if ((newMaxX >= dX) & (newMaxX <= dMaxX)){    //Collision from the right
                if((newY >= dY) & (newY <= dMaxY)){        //Collision from the bottom
                    return false;
                }

                else if((newMaxY >= dY) & (newMaxY <= dMaxY)){    //Collision from top
                    return false;
                }
            }
        }
        return true;
    }
    
    
    /** [REPLACE WITH YOUR DOCUMENTNATION]
     * 
     */
    public boolean checkForOutsideMap(Drawable d){
        if(d.getXPos() > mapWidth){
            removeDrawable(d);
            return true;
        }
        else if(d.getXPos() < 0){
            removeDrawable(d);
            return true;
        }
        else if(d.getYPos() > mapHeight){
            removeDrawable(d);
            return true;
        }
        else if(d.getYPos() < 0) {
            removeDrawable(d);
            return true;
        }
        else{
            return false;
        }
    }
}
