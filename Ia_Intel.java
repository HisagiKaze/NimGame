/**
 * Intelligence artificielle smart contre joueur
 * @author N'GONDO Cédric
 **/
class Ia_intel
{

    String name;
    int nbWin;
    

    /**
     * Constructeur Ia_intel
     * @init le nom et le nombre de victoire
     **/
    public Ia_intel(int[] tab)
    {
	this.name = "Bot-S";
	this.nbWin = 0;
	
    }

    /**
     * Accesseur de l'attribut name
     * @return le nom de de l'IA
     */
    public String getName()
    {
	   return this.name;
    }

    /**
     * Accesseur de l'attribut nbWin
     * @return le nombre de parties gangné de l'objet instancié
     */
    public int getNbWin()
    {
	   return this.nbWin;
    }
    
    

    /**
     * Mutateur de l'attribut name
     * @param n correspond au nom à afficher
     */
    public void setName(String n)
    {
	   this.name = n;
    }

    /**
     * Mutateur de l'attribut nbWin
     * @param n correspond au nombre de partie gagnée à afficher
     */
    public void setNbWin()
    {
	   this.nbWin++;
    }

    /**
     * Methode qui récupère un des sommet menant au noyau
     *@param (peaks) MaillonNoyau correspondant à la liste des sommet pouvant mener au noyau
     * @param (tab) int correspondant au tableau d'allumette
     * @return (infoNoyau) int correspondant au plus grand sommet menant au noyau en fonction du nombre d'allumette
     */
    public int playsPeaks(MaillonNoyau peaks, int[] tab)
    {
	int infNoyau;
	int i ;

	infNoyau = peaks.n1;
	if(infNoyau < (peaks.n2))
	    infNoyau = peaks.n2;
	if(infNoyau < (peaks.n3))
	    infNoyau = peaks.n3;

	return infNoyau;
    }
    
    /**
     * Méthdode SmartChoices - permettant à l'IA d'avoir de choisir un nombre d'allumette en fonction du noyau
     * @param (tab) int[] - correspondant au tableau d'allumette
     * @param match int - correspondant au nombre d'allumette
     * @return Move en fonction de la liste (LCM) et de la fonction "choice" qui renvoie un Move
     **/
    public Move SmartChoice(int[] tab, int match)
    {
	MaillonNoyau peaks;
	LCM a;
	int compt;
	int p;
	int i;
	Move choice;
	Graph nim;

	nim = new Graph(null);
	a = new LCM(null);
	compt = 0;
	i = 0;
	peaks = new MaillonNoyau(null);
	p = 0;
	choice = new Move();
	nim.ajoutNoyau(match);
	peaks = nim.ajoutpeak(match);
	p = this.playsPeaks(peaks,tab);
	if(nim.noyau.info < p)
	    p = p - (nim.noyau.info);
	else
	    p = 1;
	
	    
	System.out.print(p);
	a.seekLine(tab, p);
	a.showPlays();
	compt = a.nbElemList();
	
	i = (int) (Math.random() * (compt - 1) + 1);
	choice = a.choice(i);

	return new Move(choice.getLine(), choice.getMatchNb());
    }
}
