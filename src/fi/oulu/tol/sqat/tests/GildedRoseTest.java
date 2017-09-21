package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 0) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_7_6() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(6, itemElixir.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_80_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePasses_20_21() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		Item itemBackStagePass = items.get(0);
		assertEquals(21, itemBackStagePass.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_Quality_6_5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		Item itemManaCake = items.get(0);
		assertEquals(5, itemManaCake.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_Quality_50_48() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", -1, 50));
		
		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		Item itemManaCake = items.get(0);
		assertEquals(48, itemManaCake.getQuality());
	}

}
