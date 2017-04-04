package cs143;

/**
 * This data-management class models a sorted set of Player objects.
 *
 * @author Phuc Hong Le
 * @author 
 * @author
 * @author
 */
public class SortedSet {
    
    //fields
    private Player[] players;
    private int count;

    /**
     * Default constructor.
     */
    public SortedSet() {
        this.players = new Player[10];
    }
    
    /**
     * Adds the given player to the set in sorted order. Does not add
     * the player if the case-insensitive name already exists in the set.
     * Calls growArray() if the addition of the player will exceed the size
     * of the current array. Uses an insertion sort algorithm to place the 
     * new player in the correct position in the set, taking advantage of
     * the private swapPlayers method in this class. 
     * 
     * @param player the player to add
     * @return the index where the player was added, or -1 if not added
     */
    public int add(Player player) {
        //insertion sort
                int temp;
        for (int i = 1; i < players.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(players[j].getName() != players[j-1].getName()){
                    swapPlayers(players[j], players[j-1]);
                }
            }
        }
        return input;

        if (count >= players.length) {
            growArray();
        }
        
        return -1;
    }
    
    /**
     * Removes the player with the given case-insensitive name from the set.
     * 
     * @param name the name of the player to remove
     * @return true if removed, false if not found
     */
    public boolean remove(String name) {
        // TODO write this method body //
        return true;
    }
    
    /**
     * Locates the player with the given case-insensitive name in the set.
     * 
     * @param name the player's name
     * @return the index where the player is stored, or -1 if not found
     */
    public int find(String name) {
        // TODO write this method body //
        return 0;
    }
    
    /**
     * Returns the player object stored at the given index.
     * 
     * @param index the index from which to retrieve the player
     * @return the player object, or null if index is out of bounds.
     */
    public Player get(int index) {
        // TODO write this method body //
        return null;        
    }
    
    /**
     * Provides access to the number of players currently in the set.
     * 
     * @return the number of players
     */
    public int size() {
        return count;
    }
    
    /**
     * Provides access to the current capacity of the underlying array.
     * 
     * @return the capacity of the array
     */
    public int capacity() {
        return players.length;
    }
    
    /**
     * Provides a default string representation of th sorted set. Takes 
     * advantage of Player's toString method to provide a single line String.
     * Example: [ (Player: joe, Score: 100) (Player: fred, Score: 98) ]  
     * @return the string representing the entire set
     */
    @Override
    public String toString() {
        // TODO write this method body //
        return null;
    }
    
    /**
     * Private method used during sorting to swap players in the underlying
     * array.
     * 
     * @param i the first index
     * @param j the second index
     */
    private void swapPlayers(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }
    
    /**
     * Private method used to double the array if adding a new player will
     * exceed the size of the current array.
     */
    private void growArray() {
        // TODO write this method body //
    }
    
}
