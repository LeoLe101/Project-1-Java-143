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
     * Adds the given player to the set in sorted order. Does not add the player
     * if the case-insensitive name already exists in the set. Calls growArray()
     * if the addition of the player will exceed the size of the current array.
     * Uses an insertion sort algorithm to place the new player in the correct
     * position in the set, taking advantage of the private swapPlayers method
     * in this class.
     *
     * @param player the player to add
     * @return the index where the player was added, or -1 if not added
     */
    public int add(Player player) {
        int result = -1;
        int pos = 0;
        //checking condition to add a new player
        if (count >= players.length) {
            growArray();
        }
        if (this.find(player.getName()) == -1) {
            //add the player at the end of the array
            players[count] = player;
            count++;
            //insertion sort the player for more than 1 player
            if (count > 1) {
                for (int i = 0; i < count; i++) {
                    pos = i;
                    while (pos > 0 && players[pos].getScore() > players[pos - 1].getScore()) {
                        swapPlayers(pos, pos - 1);
                        pos = pos - 1;
                    }
                }
            }
            //find the index of the newly add player
            result = this.find(player.getName());
        }
        return result;
    }

    /**
     * Removes the player with the given case-insensitive name from the set.
     *
     * @param name the name of the player to remove
     * @return true if removed, false if not found
     */
    public boolean remove(String name) {
        int index = find(name);
        //case that the player is not found to remove
        if (index == -1) {
            return false;
        } else {
            //case that the player is found to remove
            Player[] playerListShrink = new Player[players.length];
            //copy the array until the index
            for (int i = 0; i < index; i++) {
                playerListShrink[i] = players[i];
            }
            //copy the rest of the array without copying the object
            for (int i = index; i < count; i++) {
                    playerListShrink[i] = players[i + 1];
            }
            players = playerListShrink;
            count--;
            return true;
        }
    }

    /**
     * Locates the player with the given case-insensitive name in the set.
     *
     * @param name the player's name
     * @return the index where the player is stored, or -1 if not found
     */
    public int find(String name) {
        int result = -1;
        for (int i = 0; i < count && result < 0; i++) {
            if (this.players[i].getName().equalsIgnoreCase(name)) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Returns the player object stored at the given index.
     *
     * @param index the index from which to retrieve the player
     * @return the player object, or null if index is out of bounds.
     */
    public Player get(int index) {
        //in case that the index is larger or smaller than expected
        if (index < count && index >= 0) {
            return players[index];
        } else {
            return null;
        }
    }

    /**
     * Provides access to the number of players currently in the set.
     * Don't use it in the method because it is not efficient to do so!
     *
     * @return the number of players
     */
    public int size() {
        return count;
    }

    /**
     * Provides access to the current capacity of the underlying array.
     * Don't use it in the method because it is not efficient to do so!
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
     *
     * @return the string representing the entire set
     */
    @Override
    public String toString() {
        //toString for output
        String stringOutPut = "";
        for (int i = 0; i < count; i++) {
            stringOutPut += "(" + players[i].toString() + ") ";
        }
        //stringOutPut = stringOutPut.substring(0, stringOutPut.length());
        return "[ " + stringOutPut + "]";
    }

    /**
     * Private method used during sorting to swap players in the underlying
     * array.
     *
     * @param i the first index
     * @param j the second index
     */
    private void swapPlayers(int i, int j) {
        Player temp = (Player) players[i]; //cast the element number into the Player Object
        players[i] = players[j];
        players[j] = temp;
    }

    /**
     * Private method used to double the array if adding a new player will
     * exceed the size of the current array.
     */
    private void growArray() {
        //when the element is equal with the array's length, double the array
        if (count == players.length) {
            Player[] playerListDouble = new Player[players.length * 2];
            for (int i = 0; i < players.length; i++) {
                playerListDouble[i] = players[i];
            }
            players = playerListDouble;
        }
    }

}
