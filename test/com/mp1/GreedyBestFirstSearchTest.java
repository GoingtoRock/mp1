package com.mp1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mp1.search.GreedyBestFirstSearch;
import com.mp1.search.base.Search;
import com.mp1.solution.MazeSolution;

public class GreedyBestFirstSearchTest {

	private void assertMazesAreEqual(MazeSolution actual, char[][] expectedPath) {
		assertEquals(actual.path.length, expectedPath.length);
		for(int i=0; i<actual.path.length; i++) {
			assertArrayEquals(actual.path[i], expectedPath[i]);
		}
	}
	
	@Test
	public void gbfsSimple() {
		System.out.println("Greedy Best First Search - simple");
		
		char[][] expectedPath = {
				{ '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%' },
				{ '%', '.', '.', '.', '.', '.', '%', '.', '.', '.', '.', '%' },
				{ '%', '%', '%', '%', '%', '.', '.', '.', '%', '%', 'P', '%' },
				{ '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%' } };

		Search x = new GreedyBestFirstSearch("simpleMaze.txt");
		MazeSolution actual = x.solve();

		System.out.println(actual.toString());
		
		assertEquals(actual.pathCost, 12);
		assertEquals(actual.numNodesExpanded, 13);
		assertMazesAreEqual(actual, expectedPath);
	}
	
	@Test
	public void dfsVsBfs() {
		System.out.println("Greedy Best First Search - should go up and across (tiebreaker is up)");
		
		char[][] expectedPath = {
				{ '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%' },
				{ '%', ' ', ' ', ' ', ' ', '.', '.', '.', '.', '.', '.', '%' },
				{ '%', ' ', ' ', ' ', ' ', 'P', ' ', ' ', ' ', ' ', ' ', '%' },
				{ '%', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '%' },
				{ '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%', '%' } };
		
		Search x = new GreedyBestFirstSearch("dfsVsBfs.txt");
		MazeSolution actual = x.solve();

		System.out.println(actual.toString());
		
		assertEquals(actual.pathCost, 6);
		assertEquals(actual.numNodesExpanded, 7);
		assertMazesAreEqual(actual, expectedPath);
	}
	
	@Test
	public void dfsVsBfs2() {
		System.out.println("Greedy Best First Search - should take fastest");
		
		char[][] expectedPath = {
				{ '%', '%', '%', '%', '%', '%', '%' },
				{ '%', ' ', '.', '.', ' ', ' ', '%' },
				{ '%', ' ', 'P', '%', '%', ' ', '%' },
				{ '%', ' ', ' ', ' ', ' ', ' ', '%' },
				{ '%', '%', '%', '%', '%', '%', '%' }};
		
		Search x = new GreedyBestFirstSearch("dfsVsBfs2.txt");
		MazeSolution actual = x.solve();

		System.out.println(actual.toString());
		
		assertEquals(actual.pathCost, 2);
		assertEquals(actual.numNodesExpanded, 3);
		assertMazesAreEqual(actual, expectedPath);
	}
	
	@Test
	public void badGreedy() {
		System.out.println("Greedy Best First Search - expands most nodes");
		
		char[][] expectedPath = {
				{ '%', '%', '%', '%', '%', '%' },
				{ '%', ' ', ' ', ' ', '%', '%' },
				{ '%', 'P', ' ', '%', '.', '%' },
				{ '%', '.', '%', '.', '.', '%' },
				{ '%', '.', '.', '.', ' ', '%' },
				{ '%', '%', '%', '%', '%', '%' }};
		
		Search x = new GreedyBestFirstSearch("badGreedy.txt");
		MazeSolution actual = x.solve();

		System.out.println(actual.toString());
		
		assertEquals(actual.pathCost, 7);
		assertEquals(actual.numNodesExpanded, 12);
		assertMazesAreEqual(actual, expectedPath);
	}
	
	@Test
	public void greedyVsAStar() {
		System.out.println("Greedy Best First Search - worse than Astar, goes down wrong path longer");
		
		char[][] expectedPath = {
				{ '%', '%', '%', '%', '%', '%', '%', '%' },
				{ '%', ' ', ' ', ' ', ' ', ' ', '%', '%' },
				{ '%', '.', 'P', '%', '%', ' ', ' ', '%' },
				{ '%', '.', '%', ' ', ' ', '%', ' ', '%' },
				{ '%', '.', '.', '.', '%', ' ', ' ', '%' },
				{ '%', ' ', ' ', '.', '.', '%', '%', '%' },
				{ '%', ' ', ' ', ' ', ' ', ' ', ' ', '%' },
				{ '%', '%', '%', '%', '%', '%', '%', '%' }};
		
		Search x = new GreedyBestFirstSearch("greedyVsAStar.txt");
		MazeSolution actual = x.solve();

		System.out.println(actual.toString());
		
		assertEquals(actual.pathCost, 7);
		assertEquals(actual.numNodesExpanded, 17);
		assertMazesAreEqual(actual, expectedPath);
	}
	
}
