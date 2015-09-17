package com.mp1;

import java.util.Stack;

public class DepthFirstSearch extends UninformedSearch {

	private Stack<Node> frontier;
	
	public DepthFirstSearch(String filename) {
		super(filename);
		
		this.frontier = new Stack<Node>();
	}

	@Override
	protected boolean isFrontierEmpty() {
		return this.frontier.empty();
	}

	@Override
	protected void addNodeToFrontier(Node node) {
		if(node != null) {
			this.frontier.push(node);
		}
	}

	@Override
	protected Node popNodeOffFrontier() {
		return this.frontier.pop();
	}

	@Override
	protected boolean doesFrontierContain(Node child) {
		return this.frontier.contains(child);
	}
	
}
