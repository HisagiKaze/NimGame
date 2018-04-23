class Node
{
	private FT_ArrayList<Node> 	successors;
	private FT_ArrayList<Node> 	parents;
	private	int 				value;

	public Node(int i)
	{
		value = i;
		createSuccessors();
		createParents();
	}

	private void createSuccessors()
	{
		int						i;

		successors = new FT_ArrayList<Node>();
		i = 0;
		while (i < GameState.getMaxToBurn() - 1 && i > -1)
			successors.add(i--);
	}

	private void createParents()
	{
		int 					i;

		parents = new FT_ArrayList<Node>();
		i = 0;
		while (i++ < GameState.getMaxToBurn() - 1)
			parents.add(value + i);
	}

	public FT_ArrayList<Node> getSuccessors()
	{
		return (successors);
	}

	public FT_ArrayList<Node> getParents()
	{
		return (parents);
	}
}