/**
 * Liste des noyaux en fonction du nombre d'allumette
 * @author N'GONDO Cédric
 **/
class Graph
{
    MaillonNoyau noyau;

    /**
     * Constructeur Graph
     * @int l'adresse de la tete du noau
     **/
    public Graph(MaillonNoyau m)
    {
	this.noyau = m;
    }

    /**
     * Accesseur 
     * @return l'adresse du noyau
     **/
    public MaillonNoyau getNoyau()
    {
	return (this.noyau);
    }
    
    /**
     * Mutateur
     * @param (n) MaillonNoyau - correspondant à l'adresse à attribuer à la tete de la liste
     **/
    public void setNoyau(MaillonNoyau n)
    {
	this.noyau = n;
    }

    /**
     * Méthode permettant de retourner la valeur de la tete de la liste
     * @return (this.noyau.info) int - correspondant à la valeur de la liste en tete
     **/
    public int elementNoyau()
    {
	return (this.noyau.info);
    }

    /**
     * Méthode "ajoutNoyau" permet de construire liste des noyau en fonction du nombre d'allumette
     * @param (match) int - correspondant au nombre d'allumette restante
     **/
    public void ajoutNoyau(int match)
    {
	int i;

	i = 1;
	while(i <= match)
	{
	    
	    MaillonNoyau old = this.noyau;
	    this.noyau = new MaillonNoyau(i , old);
	    
	    i  = i + 4;
	    System.out.print(this.noyau.info);
	}
	
    }

    /**
     * Méthode "ajoutpeak" qui construit un maillon dont les valeurs correspeondent au sommet menant vers le noyau
     * @param (match) int - correspondant au nombre d'allumette restante
     * @return (peaks) MaillonNyau - qui correspond à une liste qui contient les sommet menant au noyau le plus proche
     **/
    public MaillonNoyau ajoutpeak(int match)
    {
	MaillonNoyau peaks =  this.noyau;
	int i;
	int j;
	boolean pair;

	pair = false;
	

	i = this.noyau.info;
	j = 1;
	peaks.n1 = 0;
	peaks.n2 = 0;
	peaks.n3 = 0;

	if(i != match)
	    pair = true;
	while(i < match && (pair))
	{
	    
	    MaillonNoyau old = peaks;
	    if(j == 1)
		peaks.n1 = i + 1;
	    if(j == 2)
		peaks.n2 = i + 1;
	    if(j == 3)
		peaks.n3 = i + 1;
	    
	        
	    
	    j++;
	    i++;
	}
        
	System.out.print("["+peaks.n1+","+peaks.n2+","+peaks.n3+"]");
	return peaks;
	
    }

  
    /**
     * Méthode "showNoyau" qui permet d'afficher la liste
     **/
    public void showNoyau()
    {
	Graph p;
	
	p = new Graph(this.noyau);

	System.out.print("[");
	while(p.noyau != null)
	{
	    System.out.print( p.noyau.info );
	    if(p.noyau.next != null)
	        System.out.print(";");
	    p.noyau = p.noyau.next;
	}
	System.out.print("]");
	System.out.println();
    }
}
