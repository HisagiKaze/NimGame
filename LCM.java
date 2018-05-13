/**
 * Liste de Move permettant à l'IA de choisir ses coups
 * @author Cédric
 **/
class LCM
{
    MaillonM tete;

    /**
     * Constructeur LCM
     * @param n qui correspond à l'adresse donner à la tete
     */
    public LCM(MaillonM n)
    {
	this.tete = n;
    }

    /**
     * Méthode qui recupère l'adresse de la tete de la liste
     * @return l'adresse de "this.tete"
     **/
    public MaillonM getTete()
    {
	return (this.tete);
    }

    /**
     * Accesseur 
     * @param n qui correspond à l'adresse donner à la tet
     **/
    public void setTete(MaillonM n)
    {
	this.tete = n;
    }

    /**
     * Méthode permettant d'avoir la valeur en tete de liste
     * @return la valeur en tete de liste
     **/
    public Move elementTete()
    {
	return (this.tete.list);
    }

    /**
     * Méthode qui ajoute les coups disponible (IA naïve)
     * @param tab qui correspond au tableau d'allumette
     **/
    public void ajoutPlays(int[] tab)
    {
	
	Move plays;
	int i;
	int j;

	j = 0;
	i = -1;
	
	while(++i < tab.length)
	{
	    
	    if(tab[i] < 3 && tab[i] > 0)
	    {
		while(++j <= tab[i])
		{
		    MaillonM old = this.tete;
		    this.tete = new MaillonM(plays = new Move(i   , j ), old);
		}
	    }
	    else if(tab[i] >= 3)
	    {
		while(++j <= 3)
		{
		    MaillonM old = this.tete;
		    this.tete = new MaillonM(plays = new Move(i   , j ), old);
		}
	    }
	    j = 0;
	}
	
    }

    
    /**
     * Methode qui cherche les ligne en fonction du nombre d'allumette restante (IA smart)
     * @param (tab) correspondant au tableau d'allumette
     * @param (p) correspond au nombre d'allumette à retirer en fonction u noyau
     **/
    public void seekLine(int[] tab, int p)
    {
	int i;
	Move a;
	    
	i = -1;

	while(++i < tab.length)
	{
	    if(tab[i] >= p)
	    {
		MaillonM old = this.tete;
		this.tete = new MaillonM(a = new Move(i, p), old);
	    }
	}
	
    }

    /**
     * Méthode cherchant si un Move correspond à une valeur de la list LCM
     * @param (Move) correspondant au Move à rechercher
     * @return (val) boolean - vrai si le Move appartient à la liste , faux sinon
     **/
    public boolean appartientListe(Move x)
    {
	MaillonM p;
	boolean val;

	val = false;
	p = this.tete;
	while(p != null && val == false)
	{
	    if(p.list == x)
		val = true;
	    p = p.getNext();
	}
	return val;
    }

    /**
     * Méthode comptant le nombre d'élement dans la liste
     * @return (compt) int calculant le nombre d'élément qu'il y a dans la liste
     **/
    public int nbElemList()
    {
	int compt;
	MaillonM l;

	l = new MaillonM(null);
	compt = 0;
	l = this.tete;
	while(l != null)
	{
	    
		
	    l = l.next;

	    compt++;
	}

	return (compt);
    }

    /**
     * Méthode permettant le choix  d'un Move dans la liste
     * @param (x) int - correspond à un indice de la liste
     * @return (l.list) Move correspondant au choix de la variable (x)
     **/
    public Move choice (int x)
    {
	int compt;
	MaillonM l;
	boolean var;

	var = false;;
        
	compt = 0;
	l = this.tete;
	while(l != null && var == false)
	{
	    compt++;
	    if(compt == x)
		var = true;
	    else
		l = l.next;
	}
	return l.list;
    }

    /**
     * Méthode permettant d'afficher la liste LCM
     **/
    public void showPlays()
    {
	LCM p;
	boolean a;

	a = false;
	p = new LCM(this.tete);

	System.out.print("[");
	while(p.tete != null &&  a == false)
	{
	    System.out.print("(" + p.tete.list.getLine() + "," + p.tete.list.getMatchNb() + ")");
	    if(p.tete.next != null)
	    {
	        System.out.print(";");
		p.tete = p.tete.next;
	    }
	    else
		a =true;
	}
	System.out.print("]");
	System.out.println();
    }




}
