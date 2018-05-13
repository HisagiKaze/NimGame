class Test
{
    public static void main(String[] argv)
    {
	Graph m;
	int size;
	MaillonNoyau sommet;
	LCM a;
	

	

	int[] tab = {1,3,5,7};
	a = new LCM(null);
	
	size = 12;
	m = new Graph(null);

	m.ajoutNoyau(size);
	m.showNoyau();
	sommet = m.ajoutpeak(size);
	a.listSmart(3, tab);

	a.showPlays();
    }
}
