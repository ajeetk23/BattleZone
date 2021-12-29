import java.util.ArrayList;

/**
 * 
 *  Is board that is 8 by 8 and can hold pieces.
 *  Contains methods such as fillBoard, getGame, getLocation, getPlayer arrays, 
 *  removing pieces from player array, turning and resetting gameBoard, etc. 
 *
 *  @author  Ajeet, Matthew
 *  @version May 28, 2019
 *  @author  Period: 4th
 *  @author  Assignment: APCSFinalProject
 *
 *  @author  Sources: NONE
 */
public class GameBoard
{
    GamePiece[][] game;
    ArrayList<GamePiece> playerOne;
    ArrayList<GamePiece> playerTwo;
    ArrayList<Location> locs = new ArrayList<Location>();
    
    /**
     * Constructs a GameBoard object with a an 8 by 8 Gamepiece array.
     */
    public GameBoard() 
    {
        game = new GamePiece[8][8];
        playerOne = new ArrayList<GamePiece>();
        playerTwo = new ArrayList<GamePiece>();
        for (int i = 0; i < game.length; i++)
        {
            for (int j = 0; j < game[0].length; j++)
            {
                locs.add( new Location(i, j) );
            }
        }
    }
    
    /**
     * 
     * Returns gamePiece array.
     * @return gamePiece array.
     */
    public GamePiece[][] getGame() 
    {
        return game;
    }
    
    /**
     * 
     * Returns the location in the GameBoard.
     * @param x - x-coordinate of the location.
     * @param y - y-coordinate of the location.
     * @return location in the GameBoard.
     */
    public Location getLocation(int x, int y)
    {
        return locs.get( x * 8 + y );
    }
    
    /**
     * 
     * Fills the GamePiece array with pieces from player one and player two.
     * @param p1 - player one.
     * @param p2 - player two.
     */
    public void fillGameBoard(String p1, String p2)
    {
        //make GameBoard 8 by 8.
        //Piece arrangement is similar
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < game.length; j+=2)
            {
                if (i == 0)
                {
                    GamePiece newPiece = new PieceThree(this, i, j, p2);
                    game[i][j] = newPiece;
                    playerTwo.add( newPiece );
                }
                else if (i == 1)
                {
                    GamePiece newPiece = new PieceTwo(this, i, j, p2);
                    game[i][j] = newPiece;
                    playerTwo.add( newPiece );
                }
                else if (i == 2)
                {
                    GamePiece newPiece = new PieceOne(this, i, j, p2);
                    game[i][j] = newPiece;
                    playerTwo.add( newPiece );
                }
            }
        }
        
        for (int i = game.length - 1; i > game.length - 4; i--)
        {
            for (int j = 1; j < game.length; j+=2)
            {
                if (i == game.length - 1)
                {
                    GamePiece newPiece = new PieceThree(this, i, j, p1);
                    game[i][j] = newPiece;
                    playerOne.add( newPiece );
                }
                else if (i == game.length - 2)
                {
                    GamePiece newPiece = new PieceTwo(this, i, j, p1);
                    game[i][j] = newPiece;
                    playerOne.add( newPiece );
                }
                else if (i == game.length - 3)
                {
                    GamePiece newPiece = new PieceOne(this, i, j, p1);
                    game[i][j] = newPiece;
                    playerOne.add( newPiece );
                }
            }
        }
    }
    
    /**
     * 
     * Returns an ArrayList containing all player one pieces.
     * @return an ArrayList containing all player one pieces.
     */
    public ArrayList<GamePiece> getPlayerOnePieces()
    {
        return playerOne;
    }
    
    /**
     * 
     * Removes a GamePiece from the player one array if it exists.
     * @param target being removed.
     */
    public void removePlayerOnePiece(GamePiece target)
    {
        playerOne.remove( target );
    }
    
    /**
     * 
     * Returns an ArrayList containing all player two pieces.
     * @return an ArrayList containing all player two pieces.
     */
    public ArrayList<GamePiece> getPlayerTwoPieces()
    {
        return playerTwo;
    }
    
    /**
     * 
     * Removes a GamePiece from the player two array if it exists.
     * @param target being removed.
     */
    public void removePlayerTwoPiece(GamePiece target)
    {
        playerTwo.remove( target );
    }
    
    /**
     * 
     * Determines whether piece can be moved to a new location.
     * @param piece - piece being moved.
     * @param newL - new Location piece is moved to.
     * @return whether piece can be moved to a new location.
     */
    public boolean setGameBoard(GamePiece piece, Location newL)
    {
          GamePiece spot = game[newL.getX()][newL.getY()]; 
          if (spot != null)
          {
              return false;
          }
          game[newL.getX()][newL.getY()] = piece;
          game[piece.getLocation().getX()][piece.getLocation().getY()] = null;
          return true;
    }
    
    /**
     * 
     * Rotates the gamePiece array by 180 degrees.
     */
    public void turnGameBoard()
    {
        GamePiece[][] newGame = new GamePiece[8][8];
        for ( int i = 0; i < game.length; i++ )
        {
            for ( int j = 0; j < game[0].length; j++ )
            {
                newGame[i][j] = game[game.length - 1 - i][game[0].length - 1 - j];
                if ( game[game.length - 1 - i][game[0].length - 1 - j] != null )
                {
                    game[game.length - 1 - i][game[0].length - 1 - j]
                        .setLocation( new Location( i, j ) );
                }
            }
        }
        game = newGame;
    }
    
    /**
     * 
     * Resets the GamePieces to their original positions.
     */
    public void resetGameBoard()
    {
        game = new GamePiece[8][8];
        this.fillGameBoard("PlayerOne" , "PlayerTwo");
    }
    
//    public String playerToString()
//    {
//        return "playerOne";
//    }
    
}
