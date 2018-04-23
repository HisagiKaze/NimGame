class Node
{
	private FT_ArrayList<Node> 	successors;
	private FT_ArrayList<Node> 	parents;
	private	int 				value;

	public 						Node(int i)
	{
		value = i;
		successors = new FT_ArrayList<Node>();
		parents = new FT_ArrayList<Node>();
	}

	public void 				createSuccessor(Node x)
	{
		if (value > 1)
			if (x < value && x >= (value - GameState.getMaxToBurn()))
				successors.add(x);
	}

	public void 				createParent(Node x)
	{
		if (x > value && x <= (value + GameState.getMaxToBurn()))
			parents.add(x);
	}

	public FT_ArrayList<Node> 	getSuccessors()
	{
		return (successors);
	}

	public FT_ArrayList<Node> 	getParents()
	{
		return (parents);
	}

	public int 					getValue()
	{
		return (value);
	}
}