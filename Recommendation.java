package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;


public class RecommendationContentBased {
	public List<Item> recommend(String userId, double lat, double lon) {
		List<Item> recommendedItem = new ArrayList<>();

		// Step 1, get all favorited Itemids
		DBConnection connection = DBConnectionFactory.getConnection();
		Set<String> favoritedItemIds = connection.getFavoriteIds(userId);

		// Step 2, get all categories,  sort by count
		// {"Function": 5, "Size": 3, "Price": 2}
		Map<String, Integer> allCategories = new HashMap<>();
		for (String itemId : favoritedItemIds) {
			Set<String> categories = connection.getCategories(itemId);
			for (String category : categories) {
				allCategories.put(category, allCategories.getOrDefault(category, 0) + 1);
			}
		}
		List<Entry<String, Integer>> categoryList = new ArrayList<>(allCategories.entrySet());
		Collections.sort(categoryList, (Entry<String, Integer> e1, Entry<String, Integer> e2) -> {
			return Integer.compare(e2.getValue(), e1.getValue());
		});
		
		// Step 3, search based on category, filter out favorite items
		Set<String> visitedItemIds = new HashSet<>();
		for (Entry<String, Integer> category : categoryList) {
			List<Item> items = connection.searchItem(lat, lon, category.getKey());
			
			for (Event item : items) {
				if (!favoritedItemIds.contains(item.getId()) && !visitedItemIds.contains(item.getId())) {
					recommendedEvents.add(item);
					visitedItemIds.add(event.getId());
				}
			}
		}
		
		connection.cleanUp();
		return recommendedItems;

	}

}
