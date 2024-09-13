package db;

import java.util.List;
import java.util.Set;

import entity.Item;

public interface DBConnection {
	/**
	 * Close the connection.
	 */
	public void cleanUp();

	/**
	 * Insert the favorite item for a user.
	 * 
	 * @param userId
	 * @param itemIds
	 */
	public void setFavorites(String userId, List<String> itemIds);

	/**
	 * Delete the favorite item for a user.
	 * 
	 * @param userId
	 * @param itemIds
	 */
	public void unsetFavorites(String userId, List<String> itemIds);

	/**
	 * Get the favorite item id for a user.
	 * 
	 * @param userId
	 * @return itemIds
	 */
	public Set<String> getFavoritemIds(String userId);

	/**
	 * Get the favorite item for a user.
	 * 
	 * @param userId
	 * @return event
	 */
	public Set<Item> getFavorites(String userId);

	/**
	 * Gets classifications based on item id
	 * 
	 * @param itemId
	 * @return set of classifications
	 */
	public Set<String> getCategories(String itemId);

	/**
	 * Search items near a size and a term (optional).
	 * 
	 * @param userId
	 * @param height
	 * @param width
	 * @param term
	 *            (Nullable)
	 * @return list of items
	 */
	public List<Item> searchItem(double height, double width, String term);

	/**
	 * Save event into db.
	 * 
	 * @param item
	 */
	public void saveItem(Item item);

	/**
	 * Get full name of a user. (This is not needed for main course, just for demo
	 * and extension).
	 * 
	 * @param userId
	 * @return full name of the user
	 */
	public String getUserName(String userId);

	/**
	 * Return whether the credential is correct. (This is not needed for main
	 * course, just for demo and extension)
	 * 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public boolean verifyLogin(String userId, String password);
	
	/**
	 * Register one user.
	 * @param userId
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @return boolean
	 */
	
	public boolean registerUser(String userId, String password, String firstname, String lastname);
}
