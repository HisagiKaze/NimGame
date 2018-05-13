/**
 * Maillon dont les valeurs peuvent correspondre soit à des noyaux soit à des dommets menant à un noyau( le plus proche)
 * @author N'GONDO Cédric
 **/
class MaillonNoyau
{
    int info;
    int n1,n2,n3;
    MaillonNoyau next;

    /**
     * Constructeur de MaillonNoyau
     * @init la valeurs et l'adresse du Maillon
     * @param (l) int - correspondant à la valeur d'un noyau
     * @paral (n) MaillonNoyau - correspondant à l'adresse d'un Maillon
     **/
    public MaillonNoyau(int l, MaillonNoyau n)
    {
	this.info = l;
	this.next = n;
    }

    /**
     * Constructeur 2 de MaillonNoyau
     * @init l'adresse du Maillon
     * @param (n) MaillonNoyau - correspondant à l'adresse à attribuer au Maillon
     **/
    public MaillonNoyau(MaillonNoyau n)
    {
	this.next = n;
    }

    /**
     * Accesseur
     * @return (this.info) int - correspond à la valeurs du Maillon
     **/
    public int getList()
    {
	return (this.info);
    }

    /**
     * Accesseur
     * @return (this.next) MaillonNoyau - correspond à l'adresse du Maillon
     **/
    public MaillonNoyau getNext()
    {
	return (this.next);
    }

    /**
     * Mutateur
     * @param (l) int - correspond à la valeur à attribuer au Maillon
     **/
    public void setList(int l)
    {
	this.info = l;
    }

    /**
     * Mutateur
     * @param (n) MaillonNoyau  - correspond à l'adrsse à attribuer au Maillon
     **/
     public void setNext(MaillonNoyau n)
    {
	this.next = n;
    }
}
