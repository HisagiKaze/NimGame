/**
 * Objet correspond à une liste qui pour valeur un Move
 * @author Cédric N'GONDO
 **/
class MaillonM
{
    Move list;
    MaillonM next;

    /**
     * Constructeur de la class MaillonM
     * @param (l) Move correspondant à la valeur à donner à la variable (list);
     * @param (n) MaillonM correspond à ladresse à donner au maillon
     **/
    public MaillonM(Move l, MaillonM n)
    {
	this.list = l;
	this.next = n;
    }

    /**
     * Constructeur de la class MaillonM
     * @param (n) MaillonM correspond à ladresse à donner au maillon
     **/
    public MaillonM(MaillonM n)
    {
	this.next = n;
    }

    /**
     * Mutateur permettant d'avoir la valeur du maillon
     * @return (this.list) Move qui correspond à la valeur du maillon
     **/
    public Move getList()
    {
	return (this.list);
    }

    /**
     * Mutateur permettant d'avoir l'adresse du maillon
     * @return (this.list) MaillonM qui correspond à l'adresse du maillon
     **/
    public MaillonM getNext()
    {
	return (this.next);
    }

    /**
     * Accesseur permettant d'attribuer une valeur à un maillon
     * @param (l) Move correspondant à la valeur à attribuer maillon
     **/
    public void setList(Move l)
    {
	this.list = l;
    }

    /**
     * Accesseur permettant d'attribuer une adresse à un maillon
     * @param (n) MaillonM correspondant à l'adresse à attribuer au maillon
     **/
    public void setNext(MaillonM n)
    {
	this.next = n;
    }

    
}
